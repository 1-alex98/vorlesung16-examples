import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMain {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        Student student = new Student();
        Class<? extends Student> theClass = student.getClass();


        Field age = theClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(student, 20);
        System.out.println(student.getAge());


        Method[] methods = theClass.getMethods();
        for(Method method: methods){
            if(method.getName().toLowerCase().startsWith("a")){
                method.invoke(student);
            }
        }
        System.out.println(student.getAge());
    }
}
