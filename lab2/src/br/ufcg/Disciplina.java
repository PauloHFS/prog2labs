package br.ufcg;

public class Disciplina {
    private String nomeDisciplina;
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    /*
    void cadastraHoras(int horas) {}
    void cadastraNota(int nota, double valorNota) {// notas possíveis: 1, 2, 3 e 4
    }
    boolean aprovado() {
    }
     */

    @Override
    public String toString() {
        return this.nomeDisciplina;
    }
}
