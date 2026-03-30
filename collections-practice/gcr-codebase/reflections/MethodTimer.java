import java.lang.reflect.Method;

class SampleService {
    public void fastMethod() {
        System.out.println("Fast method executed!");
    }

    public void slowMethod() {
        try {
            Thread.sleep(500); // simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Slow method executed!");
    }
}

public class MethodTimer {

    public static void measureExecutionTime(Object obj) {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            try {
                long start = System.nanoTime();
                method.invoke(obj);
                long end = System.nanoTime();
                System.out.println("Method: " + method.getName() +
                        " executed in " + (end - start)/1_000_000.0 + " ms");
                System.out.println("---------------------------");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SampleService service = new SampleService();
        measureExecutionTime(service);
    }
}
