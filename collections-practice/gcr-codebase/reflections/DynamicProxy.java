import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 1️⃣ Define an interface
interface Greeting {
    void sayHello(String name);
}

// 2️⃣ Implement the interface
class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// 3️⃣ Logging Invocation Handler
class LoggingHandler implements InvocationHandler {

    private final Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log method name and arguments
        System.out.println("Invoking method: " + method.getName());
        if (args != null) {
            for (Object arg : args) {
                System.out.println("  Arg: " + arg);
            }
        }

        // Call the original method
        return method.invoke(target, args);
    }
}

// 4️⃣ Demo main method
public class DynamicProxy {

    public static void main(String[] args) {
        // Original object
        Greeting greeting = new GreetingImpl();

        // Create proxy
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingHandler(greeting)
        );

        // Call method via proxy
        proxy.sayHello("Arpit");
    }
}
