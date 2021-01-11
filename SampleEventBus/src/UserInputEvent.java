import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserInputEvent {
    private int number;

    public UserInputEvent(int number) {
        this.number = number;
    }
}
