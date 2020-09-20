package br.ufcg.coisa.utils;

//TODO: Documentar
/**
 * 
 * @author Paulo Hernane Fontes e Silva
 */
public class Lanche {
    /**
     * Quantidade de itens contidos no Lanche.
     */
    private Integer numItens;

    /**
     * Preço em centavos do Lanche.
     */
    private Integer valorLanche;

    /**
     * Detalhes sobre o Lanche.
     */
    private String detalhes;

    //TODO: Documentar
    /**

     * @param qtdItens
     * @param valorCentavos
     * @param detalhes
     */
    public Lanche(int qtdItens, int valorCentavos, String detalhes) {
        this.numItens = qtdItens;
        this.valorLanche = valorCentavos;
        this.detalhes = detalhes;
    }

    //TODO: Documentar
    /**
     * @param qtdItens
     * @param valorCentavos
     */
    public Lanche(int qtdItens, int valorCentavos) {
        this(qtdItens, valorCentavos, null);
    }

    //TODO: Documentar
    /**
     */
    @Override
    public String toString() {
        if (this.detalhes != null) {
            return this.numItens + " " + this.valorLanche + " " + this.detalhes;
        } else {
            return this.numItens + " " + this.valorLanche;
        }
    }
}
