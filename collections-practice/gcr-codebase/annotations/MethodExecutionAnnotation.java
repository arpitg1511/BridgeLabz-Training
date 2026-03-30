import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class SampleTasks {

    @LogExecutionTime
    public void fastTask() {
        for (int i = 0; i < 1000; i++) {
        }
    }

    @LogExecutionTime
    public void slowTask() {
        for (int i = 0; i < 1000000; i++) {
        }
    }

    public void normalTask() {
        for (int i = 0; i < 500; i++) {
        }
    }
}

public class MethodExecutionAnnotation {

    public static void main(String[] args) throws Exception {

        SampleTasks obj = new SampleTasks();
        Method[] methods = SampleTasks.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long startTime = System.nanoTime();
                method.invoke(obj);
                long endTime = System.nanoTime();

                System.out.println("Method Name   : " + method.getName());
                System.out.println("Execution Time: " + (endTime - startTime) + " ns");
                System.out.println("----------------------------");
            }
        }
    }
}
