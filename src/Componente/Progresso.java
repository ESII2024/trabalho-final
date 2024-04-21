package Componente;

public class Progresso {
    private Componente componente;
    private int progresso;

    public Progresso(Componente componente, int progresso) {
        this.componente = componente;
        this.progresso = progresso;
    }

    public Componente getComponente() { return componente; }
    public void setComponente(Componente componente) { this.componente = componente; }

    public int getProgresso() { return progresso; }
    public void setProgresso(int progresso) { this.progresso = progresso; }
}
