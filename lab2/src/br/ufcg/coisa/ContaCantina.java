package br.ufcg.coisa;

/**
 * Representação de um Conta em uma Cantina.
 * 
 * TODO: Adicionar descrições nos lanches.
 * 
 * @author Paulo Hernane Fontes e Silva
 */
public class ContaCantina {
    /**
     * Nome da Cantina no qual está a conta.
     */
    private String nomeCantina;

    /**
     * Valor da Divida atual na Cantina.
     */
    private Integer valorDivida;

    /**
     * Valor da Divida Histórica na Cantina, armazena o valor total de vendas para
     * essa conta na cantina.
     */
    private Integer valorDividaHistorica;

    /**
     * Armazena a quantidade de itens vendidos nesta conta.
     */
    private Integer numItensComprados;

    /**
     * Constrói uma Conta na Cantina a partir do nome da cantina.
     * 
     * @param nomeCantina Nome da Cantina em que a conta irá ser criada
     */
    public ContaCantina(String nomeCantina) {
        this.nomeCantina = nomeCantina;
        this.valorDivida = 0;
        this.valorDividaHistorica = 0;
        this.numItensComprados = 0;
    }

    /**
     * Efetua a operação de venda na cantina sendo armazenada o valor da divida e a
     * quantidade de itens vendidos na conta.
     * 
     * @param qtdItens      Quantidade de itens vendidos
     * @param valorCentavos Valor da venda
     */
    public void cadastraLanche(int qtdItens, int valorCentavos) {
        this.numItensComprados += qtdItens;
        this.valorDivida += valorCentavos;
        this.valorDividaHistorica += valorCentavos;
    }

    /**
     * Efetua a quitação de debitos abertos na conta.
     * 
     * @param valorCentavos Valor a ser quitado, pode ser menor ou igual a divida
     */
    public void pagaConta(int valorCentavos) {
        if (valorCentavos <= this.valorDivida) {
            this.valorDivida -= valorCentavos;
        }
    }

    /**
     * Retorna o valor atual da divida em aberto na conta.
     * 
     * @return Valor da divida aberta
     */
    public int getFaltaPagar() {
        return this.valorDivida;
    }

    /**
     * Retorna a representação em String da Conta na Cantina.
     * 
     * @return a representação em String da Conta na Cantina
     */
    @Override
    public String toString() {
        return this.nomeCantina + " " + this.numItensComprados + " " + this.valorDividaHistorica;
    }

}
