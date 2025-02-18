import Complemento.*;
import Componente.*;
import Exceptions.*;
import Objeto.*;
import Uteis.*;
import Conteudo.*;
import ObjectPool.*;
import Plataforma.*;
import SingletonPattern.*;
import Uteis.Enums.*;

import java.net.HttpURLConnection;

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

        ObjetoFabrica<Conteudo> fabrica = new ConteudoFabrica();

        Conteudo articuloObjeto = fabrica.createObjeto(ConteudoTipo.ARTICULO);
        articuloObjeto.display();

        Conteudo videoObjeto = fabrica.createObjeto(ConteudoTipo.VIDEO);
        videoObjeto.display();

        Conteudo quizObjeto = fabrica.createObjeto(ConteudoTipo.QUIZ);
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
        try {
            DatabaseConnection pool = DatabaseConnection.getInstance();
            pool.setMaxPoolSize(5);

            for (int i = 0; i < 7; i++) {
                try {
                    String connection = pool.acquire();
                    System.out.println("Connection acquired: " + connection);

                    pool.release(connection);
                    System.out.println("Connection released: " + connection);
                } catch (PoolExhaustedException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            pool.resetPool();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void CompositePattern() {
        print.pattern("CompositePattern");
        CursoComponente link = new CursoComponente("Curso 1");

        LicaoComponente submenu = new LicaoComponente("Licao 1");

        CursoComponente link1 = new CursoComponente("Curso 2");

        LicaoComponente submenu2 = new LicaoComponente("Lição 2");

        CursoComponente link2 = new CursoComponente("Curso 3");

        submenu2.addComponente(link2);

        submenu.addComponente(link1);
        submenu.addComponente(submenu2);

        System.out.println("Link:");
        link.display();

        System.out.println("\nSubmenu:");
        submenu.display();
    }

    private static void MementoPattern() {
        print.pattern("MementoPattern");
        CursoComponente myCursoComponente = new CursoComponente("My Component.Course");

        CursoProgresso progress1 = new CursoProgresso(new LicaoComponente("Lição 1"), 50);
        myCursoComponente.setProgress(progress1);

        CursoProgresso savedProgress = myCursoComponente.saveProgress();
        print.test("Current Component.Lesson: " + myCursoComponente.getProgress().getComponente().getNome());
        print.test("Component.Lesson Progress: " + myCursoComponente.getProgress().getProgresso());

        CursoProgresso progress2 = new CursoProgresso(new LicaoComponente("Lição 2"), 25);

        myCursoComponente.setProgress(progress2);
        print.test("Current Component.Lesson: " + myCursoComponente.getProgress().getComponente().getNome());
        print.test("Component.Lesson Progress: " + myCursoComponente.getProgress().getProgresso());
        myCursoComponente.restoreProgress(savedProgress);
        print.test("Current Component.Lesson: " + myCursoComponente.getProgress().getComponente().getNome());
        print.test("Component.Lesson Progress: " + myCursoComponente.getProgress().getProgresso());
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
