import Complemento.*;
import Componente.*;
import Objeto.ObjetoFabrica;
import Uteis.*;
import Conteudo.*;
import ObjectPool.*;
import Plataforma.*;
import SingletonPattern.*;
import Uteis.Enums.*;

public class Main {
    public static void main(String[] args) {
        Teste();
    }

    private static void SingletonPattern() {
        print.pattern("SingletonPattern");
        ConfigurationManager configManager = ConfigurationManager.getInstance(); //cria uma instancia
        configManager.setConfiguration("app.name", "E-Learning App"); //define 2 configurações nome
        configManager.setConfiguration("app.version", "1.0"); //versão
        print.test("App Name: " + configManager.getConfiguration("app.name")); //recupera as configurações e mostra
        print.test("App Version: " + configManager.getConfiguration("app.version"));
    }

    private static void FactoryPattern() {
        print.pattern("FactoryPattern");

        ObjetoFabrica fabrica = new ConteudoFabrica();

        Conteudo articuloObjeto = (Conteudo)fabrica.createObjeto(ConteudoTipo.ARTICULO);
        articuloObjeto.display();

        Conteudo videoObjeto = (Conteudo)fabrica.createObjeto(ConteudoTipo.VIDEO);
        videoObjeto.display();

        Conteudo quizObjeto = (Conteudo)fabrica.createObjeto(ConteudoTipo.QUIZ);
        quizObjeto.display();
    }

    private static void BridgePattern() {
        print.pattern("BridgePattern");

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
        print.pattern("ObjectPoolPattern");
        DatabaseConnection connection1 = DatabaseConnection.getConnection();
        DatabaseConnection connection2 = DatabaseConnection.getConnection();
        if (connection1 != null)
            connection1.releaseConnection(connection1);
        if (connection2 != null)
            connection2.releaseConnection(connection2);
    }

    private static void CompositePattern() {
        print.pattern("CompositePattern");
        Componente lesson1 = new LicaoComponente("Componente.Lição 1");
        Componente lesson2 = new LicaoComponente("Componente.Lição 2");
        Componente licaoglobal = new LicaoComponente("Componente.Lição Global");
        Componente course1 = new CursoComponente("Componente.Curso 1");
        course1.addComponente(lesson1);
        course1.addComponente(lesson2);
        course1.display();
        print.blank();
        licaoglobal.addComponente(course1);
        licaoglobal.display();
    }

    private static void MementoPattern() {
        print.pattern("MementoPattern");
        CursoComponente myCursoComponente = new CursoComponente("My Component.Course");
        CursoProgresso progress1 = new CursoProgresso("Component.Lesson 1", 50);
        myCursoComponente.setProgress(progress1);
        CursoProgresso savedProgress = myCursoComponente.saveProgress();
        print.test("Current Component.Lesson: " + myCursoComponente.getProgress().getLicaoAtual());
        print.test("Component.Lesson Progress: " + myCursoComponente.getProgress().getLicaoProgresso());
        CursoProgresso progress2 = new CursoProgresso("Component.Lesson 2", 25);
        myCursoComponente.setProgress(progress2);
        print.test("Current Component.Lesson: " + myCursoComponente.getProgress().getLicaoAtual());
        print.test("Component.Lesson Progress: " + myCursoComponente.getProgress().getLicaoProgresso());
        myCursoComponente.restoreProgress(savedProgress);
        print.test("Current Component.Lesson: " + myCursoComponente.getProgress().getLicaoAtual());
        print.test("Component.Lesson Progress: " + myCursoComponente.getProgress().getLicaoProgresso());
    }

    private static void DecoratorPattern() {
        print.pattern("DecoratorPattern");
        QuizConteudo quiz = new QuizConteudo();
        Complemento quizCracha = new CrachaComplemento(quiz);
        Complemento quizCrachaCerteficado = new CerteficadoComplemento(quizCracha);
        Complemento quizCrachaCerteficadoCracha = new CrachaComplemento(quizCrachaCerteficado);
        Complemento quizCrachaCerteficadoCrachaCracha = new CrachaComplemento(quizCrachaCerteficadoCracha);
        Complemento quizCrachaCerteficadoCrachaCrachaCerteficado = new CerteficadoComplemento(quizCrachaCerteficadoCrachaCracha);
        quizCrachaCerteficadoCrachaCrachaCerteficado.display();
    }

    private static void Teste() {
        //SingletonPattern();
        //FactoryPattern();
        //BridgePattern();
        ObjectPoolPattern();
        CompositePattern();
        //MementoPattern();
        //DecoratorPattern();
    }
}
