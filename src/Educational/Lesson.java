package Educational;

import Data.print;

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
        print.log("Educational.Lesson: " + name);
    }
}