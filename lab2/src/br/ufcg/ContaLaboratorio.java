package br.ufcg;

public class ContaLaboratorio {
    private String nomeLaboratorio;
    public ContaLaboratorio(String nomeLaboratorio) {
        this.nomeLaboratorio = nomeLaboratorio;
    }

    /*
    void consomeEspaco(int mbytes) {}

    void liberaEspaco(int mbytes) {}

    boolean atingiuCota() {

    }

     */

    @Override
    public String toString() {
        return this.nomeLaboratorio;
    }
}
