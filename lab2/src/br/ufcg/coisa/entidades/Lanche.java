package br.ufcg.coisa.entidades;

/**
 * Representação de um Lanche
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

    /**
     * Controi um Lanche a partir da sua Quantidade de Itens, seu Valor e seus
     * Detalhes.
     * 
     * @param qtdItens      Quantidade de Itens no Lanche
     * @param valorCentavos Valor Total em centavos do Lanche
     * @param detalhes      Detalhes do Lanche
     */
    public Lanche(int qtdItens, int valorCentavos, String detalhes) {
        this.numItens = qtdItens;
        this.valorLanche = valorCentavos;
        this.detalhes = detalhes;
    }

    /**
     * Controi um Lanche a partir da sua Quantidade de Itens e seu Valor.
     * 
     * @param qtdItens      Quantidade de Itens no Lanche
     * @param valorCentavos Valor Total em centavos do Lanche
     * 
     * @see br.ufcg.coisa.entidades.Lanche#Lanche(int, int, String)
     */
    public Lanche(int qtdItens, int valorCentavos) {
        this(qtdItens, valorCentavos, null);
    }

    /**
     * Retorna a representação do Lanche em String.
     * 
     * @return A representação do Lanche em String
     * @see java.lang.Object#toString()
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
