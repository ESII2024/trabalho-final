package Educational;

import java.util.ArrayList;

public class Course extends EducationalComponent {
    private ArrayList<EducationalComponent> components = new ArrayList<>();
    private String name;
    private CourseProgress progress;


    public Course(String course) {
        this.name = course;
    }

    public CourseProgress getProgress() {
        return this.progress;
    }

    public void setProgress(CourseProgress progress) {
        this.progress = progress;
        System.out.println("Progresso do curso definido para: " + progress.getCurrentLesson() + ", Progresso: " + progress.getLessonProgress() + "%");
    }

    public CourseProgress saveProgress() {
        System.out.println("A guardar o progesso do curso...");
        return new CourseProgress(progress.getCurrentLesson(), progress.getLessonProgress());
    }

    public void restoreProgress(CourseProgress progress) {
        this.progress = progress;
        System.out.println("Restaurando progresso do curso para: " + progress.getCurrentLesson() + ", Progresso da lesson: " + progress.getLessonProgress() + "%");
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
        System.out.println("Educational.Course: " + name);
        for (EducationalComponent component : components) {
            component.display();
        }
    }
}
