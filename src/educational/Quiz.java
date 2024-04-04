package educational;

public class Quiz extends BadgeDecorator implements EducationalContent {
    public Quiz() {
        super();
    }

    @Override
    public void display() {
        System.out.println("Displaying Quiz");
    }
}

