import Complemento.*;
import Componente.*;
import Uteis.*;
import Conteudo.*;
import Objeto.*;
import ObjectPool.*;
import Plataforma.*;
import SingletonPattern.*;
import Uteis.Enums.*;

public class Main {
    public static void main(String[] args) {
        Teste();
    }

    private static void SingletonPattern() {
        print.pattern("\nSingletonPattern");
        ConfigurationManager configManager = ConfigurationManager.getInstance(); //cria uma instancia
        configManager.setConfiguration("app.name", "E-Learning App"); //define 2 configurações nome
        configManager.setConfiguration("app.version", "1.0"); //versão
        print.test("App Name: " + configManager.getConfiguration("app.name")); //recupera as configurações e mostra
        print.test("App Version: " + configManager.getConfiguration("app.version"));
    }

    private static void FactoryPattern() {
        print.pattern("\nFactoryPattern");

        ObjetoFabrica fabrica = new ConteudoFabrica();

        Conteudo articuloObjeto = fabrica.getObjeto(ConteudoTipo.ARTICULO);
        articuloObjeto.display();

        Conteudo videoObjeto = fabrica.getObjeto(ConteudoTipo.VIDEO);
        videoObjeto.display();

        Conteudo quizObjeto = fabrica.getObjeto(ConteudoTipo.QUIZ);
    }

    private static void BridgePattern() {
        print.pattern("\nBridgePattern");

        Conteudo quiz = new QuizConteudo();
        Plataforma webQuiz = new WebPlataforma(quiz);
        webQuiz.display();
        Plataforma webMovel = new MovelPlataforma(quiz);
        webMovel.display();
        Plataforma webDesktop = new DesktopPlataforma(quiz);
        webDesktop.display();

        Conteudo articulo = new ArticuloConteudo();
        Plataforma articuloQuiz = new WebPlataforma(articulo);
        articuloQuiz.display();
        Plataforma articuloMovel = new MovelPlataforma(articulo);
        articuloMovel.display();
        Plataforma articuloDesktop = new DesktopPlataforma(articulo);
        articuloDesktop.display();

        Conteudo video = new VideoConteudo();
        Plataforma videoQuiz = new WebPlataforma(video);
        videoQuiz.display();
        Plataforma videoMovel = new MovelPlataforma(video);
        videoMovel.display();
        Plataforma videoDesktop = new DesktopPlataforma(video);
        videoDesktop.display();

    }

    private static void ObjectPoolPattern() {
        print.pattern("\nObjectPoolPattern");
        DatabaseConnection connection1 = DatabaseConnection.getConnection();
        DatabaseConnection connection2 = DatabaseConnection.getConnection();
        if (connection1 != null)
            connection1.releaseConnection(connection1);
        if (connection2 != null)
            connection2.releaseConnection(connection2);
    }

    private static void MementoPattern() {
        print.pattern("\nMementoPattern");
        CursoComponente myCursoComponente = new CursoComponente("My Component.Course");
        CursoProgresso progress1 = new CursoProgresso("Component.Lesson 1", 50);
        myCursoComponente.setProgress(progress1);
        CursoProgresso savedProgress = myCursoComponente.saveProgress();
        print.test("Current Component.Lesson: " + myCursoComponente.getProgress().getCurrentLesson());
        print.test("Component.Lesson Progress: " + myCursoComponente.getProgress().getLessonProgress());
        CursoProgresso progress2 = new CursoProgresso("Component.Lesson 2", 25);
        myCursoComponente.setProgress(progress2);
        print.test("Current Component.Lesson: " + myCursoComponente.getProgress().getCurrentLesson());
        print.test("Component.Lesson Progress: " + myCursoComponente.getProgress().getLessonProgress());
        myCursoComponente.restoreProgress(savedProgress);
        print.test("Current Component.Lesson: " + myCursoComponente.getProgress().getCurrentLesson());
        print.test("Component.Lesson Progress: " + myCursoComponente.getProgress().getLessonProgress());
    }

    private static void CompositePattern() {
        print.pattern("\nCompositePattern");
        Componente lesson1 = new LicaoComponente("Component.Lesson 1");
        Componente lesson2 = new LicaoComponente("Component.Lesson 2");
        Componente course1 = new CursoComponente("Component.Course 1");
        course1.addComponent(lesson1);
        course1.addComponent(lesson2);
        course1.display();
    }

    private static void DecoratorPattern() {
        print.pattern("\nDecoratorPattern");
        QuizConteudo quiz = new QuizConteudo();
        Complemento quizCracha = new CrachaComplemento(quiz);
        Complemento quizCrachaCerteficado = new CerteficadoComplemento(quizCracha);
        Complemento quizCrachaCerteficadoCracha = new CrachaComplemento(quizCrachaCerteficado);
        Complemento quizCrachaCerteficadoCrachaCracha = new CrachaComplemento(quizCrachaCerteficadoCracha);
        Complemento quizCrachaCerteficadoCrachaCrachaCerteficado = new CerteficadoComplemento(quizCrachaCerteficadoCrachaCracha);
        quizCrachaCerteficadoCrachaCrachaCerteficado.display();
    }

    private static void Teste() {
        ///SingletonPattern();
        ///FactoryPattern();
        ///BridgePattern();
        ObjectPoolPattern();
        //MementoPattern();
        //CompositePattern();
        ///DecoratorPattern();
    }
}
