import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class ConsoleInput {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        new Listener(8);
        System.out.println("Gimme a number");

        Scanner scanner = new Scanner(System.in);
        while (true){
            int i = scanner.nextInt();
            UserInputEvent userInputEvent = new UserInputEvent(i);
            EventBus.getInstance().post(userInputEvent);
        }

    }
}
