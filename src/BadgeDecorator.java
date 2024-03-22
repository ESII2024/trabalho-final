public class BadgeDecorator implements EducationalObject {
    private EducationalObject decoratedObject;

    public BadgeDecorator(EducationalObject decoratedObject) {
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