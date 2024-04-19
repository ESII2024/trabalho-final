package Componente;

import Uteis.print;

import java.util.ArrayList;

public class CursoComponente extends Componente {
    private final ArrayList<Componente> componentes = new ArrayList<>();
    private String name;
    private CursoProgresso progress;


    public CursoComponente(String curso) {
        this.name = curso;
    }

    public CursoProgresso getProgress() {
        return this.progress;
    }

    public void setProgress(CursoProgresso progress) {
        this.progress = progress;
        print.log("Progresso do curso definido para: " + progress.getLicaoAtual() + ", Progresso: " + progress.getLicaoProgresso() + "%");
    }

    public CursoProgresso saveProgress() {
        print.log("A guardar o progesso do curso...");
        return new CursoProgresso(progress.getLicaoAtual(), progress.getLicaoProgresso());
    }

    public void restoreProgress(CursoProgresso progress) {
        this.progress = progress;
        print.log("Restaurando progresso do curso para: " + progress.getLicaoAtual() + ", Progresso da lesson: " + progress.getLicaoProgresso() + "%");
    }

    @Override
    public void addComponente(Componente componente) {
        componentes.add(componente);
    }

    public void removeComponent(Componente componente) {
        componentes.remove(componente);
    }

    @Override
    public void display() {
        print.log("Component.Curso: " + name);
        for (Componente componente : componentes) {
            componente.display();
        }
    }
}
