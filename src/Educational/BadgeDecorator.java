package Educational;

public class BadgeDecorator extends EducationalObject {
    private EducationalObject decoratedObject;

    public BadgeDecorator() {
        this.decoratedObject = decoratedObject;
    }

    @Override
    public void display() {
        decoratedObject.display();
        addBadge();
    }

    private void addBadge() {
        System.out.println("Badge adicionado!");
    }
}