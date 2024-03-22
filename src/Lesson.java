public class Lesson extends EducationalComponent {
    String name;

    public Lesson(String name) {
        this.name = name;
    }

    @Override
    public void addComponent(EducationalComponent component) {

    }

    @Override
    public void display() {
        System.out.println("Lesson: " + name);
    }
}