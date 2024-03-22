package Educational;

public class Quiz extends BadgeDecorator {
    public Quiz() {
        super();
    }

    @Override
    public void display() {
        System.out.println("Displaying Quiz");
    }
}
