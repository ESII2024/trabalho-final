import Educational.*;
import Singleton.ConfigurationManager;

public class Main {
    public static void main(String[] args) {
        Teste();
    }

    private static void SingletonPattern() {
        // Test Singleton pattern - DANIEL
        System.out.println("\nSingletonPattern");
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        configManager.setConfiguration("app.name", "E-Learning App");
        configManager.setConfiguration("app.version", "1.0");
        System.out.println("App Name: " + configManager.getConfiguration("app.name"));
        System.out.println("App Version: " + configManager.getConfiguration("app.version"));
    }

    private static void FactoryPattern() {
        // Test Factory pattern - DANIEL
        System.out.println("\nFactoryPattern");
        EducationalObject quiz = EducationalObjectFactory.createObject("quiz");
        EducationalObject video = EducationalObjectFactory.createObject("video");
        EducationalObject article = EducationalObjectFactory.createObject("article");
        quiz.display();
        video.display();
        article.display();
    }

    private static void BridgePattern() {
        // Test Bridge pattern - MIGUEL
        System.out.println("\nBridgePattern");
        Educational.EducationalContent quizWeb = new BridgePattern.Quiz(new Platform.WebPlatform());
        Educational.EducationalContent quizMobile = new BridgePattern.Quiz(new Platform.MobilePlatform());
        quizWeb.display();
        quizMobile.display();
    }

    private static void CompositePattern() {
        // Test Composite pattern - LUCAS
        System.out.println("\nCompositePattern");
        EducationalComponent lesson1 = new Lesson("Educational.Lesson 1");
        EducationalComponent lesson2 = new Lesson("Educational.Lesson 2");
        EducationalComponent course1 = new Course("Educational.Course 1");
        course1.addComponent(lesson1);
        course1.addComponent(lesson2);
        course1.display();
    }

    private static void ObjectPoolPattern() {
        // Test Object Pool pattern - JOAO
        System.out.println("\nObjectPoolPattern");
        DatabaseConnection connection1 = DatabaseConnection.getConnection();
        DatabaseConnection connection2 = DatabaseConnection.getConnection();
        connection1.releaseConnection(connection1);
        connection2.releaseConnection(connection2);
    }

    private static void MementoPattern() {
        // Test Memento pattern - JOAO
        System.out.println("\nMementoPattern");
        Course myCourse = new Course("My Educational.Course");
        CourseProgress progress1 = new CourseProgress("Educational.Lesson 1", 50);
        myCourse.setProgress(progress1);
        CourseProgress savedProgress = myCourse.saveProgress();
        System.out.println("Current Educational.Lesson: " + myCourse.getProgress().getCurrentLesson());
        System.out.println("Educational.Lesson Progress: " + myCourse.getProgress().getLessonProgress());
        CourseProgress progress2 = new CourseProgress("Educational.Lesson 2", 25);
        myCourse.setProgress(progress2);
        System.out.println("Current Educational.Lesson: " + myCourse.getProgress().getCurrentLesson());
        System.out.println("Educational.Lesson Progress: " + myCourse.getProgress().getLessonProgress());
        myCourse.restoreProgress(savedProgress);
        System.out.println("Current Educational.Lesson: " + myCourse.getProgress().getCurrentLesson());
        System.out.println("Educational.Lesson Progress: " + myCourse.getProgress().getLessonProgress());
    }

    private static void DecoratorPattern() {
        // Test Decorator pattern - LUCAS | verificar se esta bem
        System.out.println("\nDecoratorPattern");
        EducationalObject quizWithBadge = new BadgeDecorator(new Quiz());
        quizWithBadge.display();
        EducationalObject quizWithCertificate = new CertificateDecorator(quizWithBadge);
        quizWithCertificate.display();
    }

    private static void Teste() {
        System.out.println("\n\nDaniel");
        SingletonPattern();

        FactoryPattern();

        System.out.println("\n\nMiguel");
        BridgePattern();

        System.out.println("\n\nJoão");
        ObjectPoolPattern();

        MementoPattern();

        System.out.println("\n\nLucas");
        CompositePattern();

        DecoratorPattern();
    }
}

/**

 1. Singleton: A instância singleton de `data.ConfigurationManager` é obtida e utilizada para definir e obter configurações globais.

 2. Factory: O método `createObject` da classe `EducationalObjectFactory` é utilizado para criar diferentes tipos de objetos educacionais (quiz, vídeo e artigo), que são exibidos.

 3. Bridge: Diferentes implementações de `PresentationPlatform` (web e mobile) são utilizadas com a abstração `Quiz` para exibir o conteúdo educacional em diferentes plataformas.

 4. Composite: Uma estrutura composta de lições e cursos é criada, onde um curso contém duas lições, e a exibição é tratada de forma uniforme.

 5. Object Pool: Duas conexões à base de dados são obtidas a partir do pool, utilizadas e, em seguida, liberadas de volta para o pool.

 6. Memento: O progresso de um curso é salvo, alterado e, em seguida, restaurado para o estado anterior.

 7. Decorator: Um objeto `Quiz` é decorado com badges e certificados, e a exibição é realizada com as funcionalidades adicionais.

 **/