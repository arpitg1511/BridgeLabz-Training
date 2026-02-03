import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1️⃣ Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {}

// 2️⃣ Define an interface for the service
interface ExpensiveService {
    @CacheResult
    long computeFactorial(int n);

    long simpleAdd(int a, int b);
}

// 3️⃣ Implement the service
class ExpensiveServiceImpl implements ExpensiveService {

    @Override
    public long computeFactorial(int n) {
        // simulate expensive computation
        try {
            Thread.sleep(200); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        System.out.println("Computed factorial for " + n);
        return result;
    }

    @Override
    public long simpleAdd(int a, int b) {
        return a + b;
    }
}

// 4️⃣ Dynamic proxy with caching
class CachingHandler implements InvocationHandler {

    private final Object target;
    private final Map<String, Object> cache = new HashMap<>();

    public CachingHandler(Object target) {
        this.target = target;
    }

    private String buildKey(Method method, Object[] args) {
        return method.getName() + Arrays.toString(args);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(CacheResult.class)) {
            String key = buildKey(method, args);
            if (cache.containsKey(key)) {
                System.out.println("Returning cached result for " + key);
                return cache.get(key);
            }
            Object result = method.invoke(target, args);
            cache.put(key, result);
            return result;
        } else {
            return method.invoke(target, args);
        }
    }
}

// 5️⃣ Demo main method
public class CacheResultDemo {

    public static void main(String[] args) {
        ExpensiveService service = new ExpensiveServiceImpl();

        ExpensiveService proxy = (ExpensiveService) Proxy.newProxyInstance(
                ExpensiveService.class.getClassLoader(),
                new Class[]{ExpensiveService.class},
                new CachingHandler(service)
        );

        System.out.println(proxy.computeFactorial(5)); // Computed
        System.out.println(proxy.computeFactorial(5)); // Cached
        System.out.println(proxy.computeFactorial(6)); // Computed
        System.out.println(proxy.simpleAdd(2, 3));     // No cache, normal execution
    }
}
