package Educational;

public class BadgeDecorator extends EducationalObject {
    private EducationalObject decoratedObject;

    public BadgeDecorator(EducationalObject decoratedObject) {
        this.decoratedObject = decoratedObject;
    }

    public BadgeDecorator() {}

    @Override
    public void display() {
        decoratedObject.display();
    }
}