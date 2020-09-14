package br.ufcg;

public class ContaCantina {
    private String nomeCantina;

    public ContaCantina(String nomeCantina) {
        this.nomeCantina = nomeCantina;
    }

    /*
    void cadastraLanche(int qtdItens, int valorCentavos) {}
    void pagaConta(int valorCentavos) {}
    int getFaltaPagar() {
    }

     */

    @Override
    public String toString() {
        return this.nomeCantina;
    }

}
