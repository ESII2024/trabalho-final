import java.util.ArrayList;

public class Course extends EducationalComponent {
    ArrayList<EducationalComponent> components = new ArrayList<>();
    String name;

    public Course(String course) {

        this.name = course;
    }

    @Override
    public void addComponent(EducationalComponent component) {
        components.add(component);
    }

    public void removeComponent(EducationalComponent component) {
        components.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Course: " + name);
        for (EducationalComponent component : components) {
            component.display();
        }
    }
}
