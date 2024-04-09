import Data.print;
import DecoratorPattern.BadgeDecorator;
import DecoratorPattern.CertificateDecorator;
import DecoratorPattern.Quiz;
import Educational.*;
import ObjectPool.DatabaseConnection;
import SingletonPattern.ConfigurationManager;

public class Main {
    public static void main(String[] args) {
        Teste();
    }

    private static void SingletonPattern() {
        // Test Singleton pattern - DANIEL
        print.pattern("\nSingletonPattern");
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        configManager.setConfiguration("app.name", "E-Learning App");
        configManager.setConfiguration("app.version", "1.0");
        print.test("App Name: " + configManager.getConfiguration("app.name"));
        print.test("App Version: " + configManager.getConfiguration("app.version"));
    }

    private static void FactoryPattern() {
        // Test Factory pattern - DANIEL
        print.pattern("\nFactoryPattern");
        EducationalObject quiz = EducationalObjectFactory.createObject("quiz");
        EducationalObject video = EducationalObjectFactory.createObject("video");
        EducationalObject article = EducationalObjectFactory.createObject("article");
        quiz.display();
        video.display();
        article.display();
    }

    private static void BridgePattern() {
        // Test Bridge pattern - MIGUEL
        print.pattern("\nBridgePattern");
        Educational.EducationalContent quizWeb = new BridgePattern.Quiz(new Platform.WebPlatform());
        Educational.EducationalContent quizMobile = new BridgePattern.Quiz(new Platform.MobilePlatform());
        quizWeb.display();
        quizMobile.display();
    }

    private static void ObjectPoolPattern() {
        // Test Object Pool pattern - JOAO
        print.pattern("\nObjectPoolPattern");
        DatabaseConnection connection1 = DatabaseConnection.getConnection();
        DatabaseConnection connection2 = DatabaseConnection.getConnection();
        if (connection1 != null)
            connection1.releaseConnection(connection1);
        if (connection2 != null)
            connection2.releaseConnection(connection2);
    }

    private static void MementoPattern() {
        // Test Memento pattern - JOAO
        print.pattern("\nMementoPattern");
        Course myCourse = new Course("My Educational.Course");
        CourseProgress progress1 = new CourseProgress("Educational.Lesson 1", 50);
        myCourse.setProgress(progress1);
        CourseProgress savedProgress = myCourse.saveProgress();
        print.test("Current Educational.Lesson: " + myCourse.getProgress().getCurrentLesson());
        print.test("Educational.Lesson Progress: " + myCourse.getProgress().getLessonProgress());
        CourseProgress progress2 = new CourseProgress("Educational.Lesson 2", 25);
        myCourse.setProgress(progress2);
        print.test("Current Educational.Lesson: " + myCourse.getProgress().getCurrentLesson());
        print.test("Educational.Lesson Progress: " + myCourse.getProgress().getLessonProgress());
        myCourse.restoreProgress(savedProgress);
        print.test("Current Educational.Lesson: " + myCourse.getProgress().getCurrentLesson());
        print.test("Educational.Lesson Progress: " + myCourse.getProgress().getLessonProgress());
    }

    private static void CompositePattern() {
        // Test Composite pattern - LUCAS
        print.pattern("\nCompositePattern");
        EducationalComponent lesson1 = new Lesson("Educational.Lesson 1");
        EducationalComponent lesson2 = new Lesson("Educational.Lesson 2");
        EducationalComponent course1 = new Course("Educational.Course 1");
        course1.addComponent(lesson1);
        course1.addComponent(lesson2);
        course1.display();
    }

    private static void DecoratorPattern() {
        // Test Decorator pattern - LUCAS
        print.pattern("\nDecoratorPattern");
        DecoratorPattern.Quiz quiz = new Quiz();
        EducationalObject quizWithBadge = new BadgeDecorator(quiz);
        quizWithBadge.display();
        EducationalObject quizWithCertificate = new CertificateDecorator(quizWithBadge);
        quizWithCertificate.display();
    }

    private static void Teste() {
        print.responsavel("\n\nDaniel");
        SingletonPattern();
        FactoryPattern();

        print.responsavel("\n\nMiguel");
        BridgePattern();

        print.responsavel("\n\nJoão");
        ObjectPoolPattern();
        MementoPattern();

        print.responsavel("\n\nLucas");
        CompositePattern();
        DecoratorPattern();
    }
}
