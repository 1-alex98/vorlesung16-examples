import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EventBus {
    private static final EventBus instance = new EventBus();
    private final List<Object> registered = new ArrayList<>();

    public static EventBus getInstance() {
        return instance;
    }

    public void post(Object event) throws InvocationTargetException, IllegalAccessException {
        for (Object listener: registered){
            Method[] methods = listener.getClass().getMethods();
            for(Method method: methods){
                Class<?>[] parameterTypes = method.getParameterTypes();

                if(parameterTypes.length == 1 && parameterTypes[0] == event.getClass()){
                    method.invoke(listener, event);

                }
            }
        }
    }

    public void register(Object object) {
        registered.add(object);
    }
}
