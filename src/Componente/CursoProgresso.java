package Componente;

public class CursoProgresso {
    private String currentLesson;
    private int lessonProgress;

    public CursoProgresso(String currentLesson, int lessonProgress) {
        this.currentLesson = currentLesson;
        this.lessonProgress = lessonProgress;
    }

    public String getCurrentLesson() {
        return currentLesson;
    }

    public int getLessonProgress() {
        return lessonProgress;
    }
}

