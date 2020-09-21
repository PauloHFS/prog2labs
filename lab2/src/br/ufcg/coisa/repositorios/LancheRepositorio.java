package br.ufcg.coisa.repositorios;

import br.ufcg.coisa.entidades.Lanche;

/**
 * Repositório de Lanches
 * 
 * O repositório mantém apenas os 5 primeiros Lanches cadastrados.
 * 
 * @author Paulo Hernane Fontes e Silva
 * @see br.ufcg.coisa.entidades.Lanche
 */
public class LancheRepositorio {
    /**
     * Array que armazena os Lanches.
     */
    private Lanche[] lanches;

    /**
     * Armazena o número de Lanches Cadastrados no repositório.
     */
    private Integer lanchesCadatrados;

    /**
     * Contrói um repositório de Lanches vazio.
     */
    public LancheRepositorio() {
        this.lanches = new Lanche[5];
        this.lanchesCadatrados = 0;
    }

    /**
     * Realiza o cadastro de um Lanche, com as informações da Quantidade de Itens, o
     * Valor em Centavos, e sua descrição.
     * 
     * O repositório mantém as informações dos 5 ultimos lanches, assim, quando
     * cadastrado um lanche o primeiro lanche cadastrado é removido.
     * 
     * @param qtdItens      Quantidade de Itens do Lanche
     * @param valorCentavos Valor Total em centavos do Lanche
     * @param detalhes      Detalhes do lanche
     */
    public void cadastraLanche(int qtdItens, int valorCentavos, String detalhes) {
        if (this.lanchesCadatrados < 5) {
            this.lanchesCadatrados += 1;
        } else {
            for (int i = 0; i < 4; i++) {
                this.lanches[i] = this.lanches[i + 1];
            }
        }
        this.lanches[this.lanchesCadatrados - 1] = new Lanche(qtdItens, valorCentavos, detalhes);
    }

    /**
     * Retorna a representação em do Repositório, que por sua vez é as informações
     * dos Lanches cadastrados.
     * 
     * @return A representação em String do Repositório
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String lancheRepositorioString = "";
        for (int i = 0; i < this.lanchesCadatrados; i++) {
            lancheRepositorioString += this.lanches[i].toString();
            if (i != this.lanchesCadatrados - 1) {
                lancheRepositorioString += "\n";
            }
        }
        return lancheRepositorioString;
    }
}
