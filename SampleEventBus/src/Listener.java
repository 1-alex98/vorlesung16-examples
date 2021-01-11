public class Listener {
    private final int magicNumber;

    public Listener(int magicNumber) {
        this.magicNumber = magicNumber;
        EventBus.getInstance().register(this);
    }

    @Subscribe
    public void onUserInputEvent(UserInputEvent userInputEvent){
        if(userInputEvent.getNumber() == magicNumber){
            System.out.println("Congratulations "+userInputEvent.getNumber()+" is the magic number.");
        }
    }
}
