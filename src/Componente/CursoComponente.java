package Componente;

import Uteis.print;

import java.util.ArrayList;

public class CursoComponente extends Componente {
    private CursoProgresso progress; // para o memento

    // Métodos para o memento (progress)

    public CursoComponente(String nome) {
        super(nome);
    }

    public CursoProgresso getProgress() {
        return this.progress;
    }

    public void setProgress(CursoProgresso progress) {
        this.progress = progress;
        print.log("Progresso do curso definido para: " + progress.getComponente().getNome() + ", Progresso: " + progress.getProgresso() + "%");
    }

    public CursoProgresso saveProgress() {
        print.log("A guardar o progesso do curso...");
        return new CursoProgresso(progress.getComponente(), progress.getProgresso());
    }

    public void restoreProgress(CursoProgresso progress) {
        this.progress = progress;
        print.log("Restaurando progresso do curso para: " + progress.getComponente().getNome() + ", Progresso da lesson: " + progress.getProgresso() + "%");
    }

    @Override
    public void display() {
        print.log("Curso: " + getNome());
    }
}
