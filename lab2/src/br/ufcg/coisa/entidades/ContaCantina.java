package br.ufcg.coisa.entidades;

import br.ufcg.coisa.repositorios.LancheRepositorio;

/**
 * Representação de um Conta em uma Cantina.
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
     * Repositório que armazena os lanches feitos na cantina.
     */
    private LancheRepositorio lanches;

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
        this.lanches = new LancheRepositorio();
    }

    /**
     * Retorna o o nome da Cantina a qual pertence a Conta
     * 
     * @return O nome da Cantina
     */
    public String getNomeCantina() {
        return this.nomeCantina;
    }

    /**
     * Cadastra um novo Lanche na Cantina a partir da Quantidade de Itens, o Valor
     * do Lanche e seus Detalhes.
     * 
     * @param qtdItens      Quantidade de Itens do Lanche
     * @param valorCentavos Valor Total em centavos do Lanche
     * @param detalhes      Detalhes do Lanche
     * 
     * @see br.ufcg.coisa.repositorios.LancheRepositorio#cadastraLanche(int, int,
     *      String)
     */
    public void cadastraLanche(int qtdItens, int valorCentavos, String detalhes) {
        this.lanches.cadastraLanche(qtdItens, valorCentavos, detalhes);
        this.numItensComprados += qtdItens;
        this.valorDivida += valorCentavos;
        this.valorDividaHistorica += valorCentavos;
    }

    /**
     * Efetua a operação de venda na cantina sendo armazenada o valor da divida e a
     * quantidade de itens vendidos na conta.
     * 
     * @param qtdItens      Quantidade de itens vendidos
     * @param valorCentavos Valor da venda
     * 
     * @see br.ufcg.coisa.entidades.ContaCantina#cadastraLanche(int, int, String)
     */
    public void cadastraLanche(int qtdItens, int valorCentavos) {
        this.cadastraLanche(qtdItens, valorCentavos, null);
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
     * Retorna os detalhes dos ultimos Lanches cadastrados.
     * 
     * @return Os detalhes em String dos Lanches
     * @see br.ufcg.coisa.repositorios.LancheRepositorio#toString()
     */
    public String listarDetalhes() {
        return this.lanches.toString();
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
