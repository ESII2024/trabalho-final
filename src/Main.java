import educational.*;
import data.ConfigurationManager;

public class Main {
    public static void main(String[] args) {
        Teste();
        SetupConstants();
    }

    private static void SetupConstants() {
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        configManager.setConfiguration("MAX_POOL_SIZE", 10);
        //System.out.println("MAX_POOL_SIZE " + configManager.getConfiguration("MAX_POOL_SIZE"));
    }

    private static void Teste() {
        // Test Singleton pattern - DANIEL
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        configManager.setConfiguration("app.name", "E-Learning App");
        configManager.setConfiguration("app.version", "1.0");
        System.out.println("App Name: " + configManager.getConfiguration("app.name"));
        System.out.println("App Version: " + configManager.getConfiguration("app.version"));

        // Test Factory pattern - DANIEL
        EducationalObject quiz = EducationalObjectFactory.createObject("quiz");
        EducationalObject video = EducationalObjectFactory.createObject("video");
        EducationalObject article = EducationalObjectFactory.createObject("article");
        quiz.display();
        video.display();
        article.display();

        // Test Bridge pattern - MIGUEL
        /*Educational.EducationalContent quizWeb = new Quiz(new platform.WebPlatform());
        Educational.EducationalContent quizMobile = new Quiz(new platform.MobilePlatform());
        quizWeb.display();
        quizMobile.display();*/

        // Test Composite pattern - LUCAS
        EducationalComponent lesson1 = new Lesson("Educational.Lesson 1");
        EducationalComponent lesson2 = new Lesson("Educational.Lesson 2");
        EducationalComponent course1 = new Course("Educational.Course 1");
        course1.addComponent(lesson1);
        course1.addComponent(lesson2);
        course1.display();

        // Test Object Pool pattern - JOAO
        DatabaseConnection connection1 = DatabaseConnection.getConnection();
        DatabaseConnection connection2 = DatabaseConnection.getConnection();
        connection1.releaseConnection(connection1);
        connection2.releaseConnection(connection2);

        // Test Memento pattern - JOAO
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

        // Test Decorator pattern - LUCAS | verificar se esta bem
        EducationalObject quizWithBadge = new BadgeDecorator(new Quiz());
        quizWithBadge.display();
        EducationalObject quizWithCertificate = new CertificateDecorator(quizWithBadge);
        quizWithCertificate.display();
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