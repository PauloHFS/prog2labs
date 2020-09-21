package br.ufcg.coisa.repositorios;

import java.util.ArrayList;

import br.ufcg.coisa.entidades.ContaCantina;

/**
 * Repósitorio de ContaCantinas.
 * 
 * @author Paulo Hernane Fontes e Silva
 * @see br.ufcg.coisa.entidade.ContaCantina
 */
public class ContaCantinaRepositorio {
    /**
     * Array que armazena as ContaCantinas.
     */
    private ArrayList<ContaCantina> contasCantinas;

    /**
     * Contrói um Repositório de ContaCantina vazio.
     */
    public ContaCantinaRepositorio() {
        this.contasCantinas = new ArrayList<ContaCantina>();
    }

    /**
     * Cadastra uma ConcaCantina no Repositóro.
     * 
     * @param nomeCantina Nome da Cantina
     * @see br.ufcg.coisa.entidades.ContaCantina
     */
    public void cadastrarCantina(String nomeCantina) {
        ContaCantina contaCantina = new ContaCantina(nomeCantina);
        this.contasCantinas.add(contaCantina);
    }

    /**
     * Retorna a ContaCantina a partir de seu nome.
     * 
     * @param nomeCantina Nome da Cantina da Conta
     * @return ContaCantina com o nome desejado, null se não tiver cadastrado
     * @see br.ufcg.coisa.entidades.ContaCantina#getNomeCantina()
     */
    private ContaCantina getContaCantina(String nomeCantina) {
        ContaCantina contaCantina = null;

        for (ContaCantina contaCantinaAux : this.contasCantinas) {
            if (contaCantinaAux.getNomeCantina().equals(nomeCantina)) {
                contaCantina = contaCantinaAux;
                break;
            }
        }

        return contaCantina;
    }

    /**
     * Cadastra um Lanche na ContaCantina desejada.
     * 
     * @param nomeCantina   Nome da Cantina em que o Lanche vai ser cadastrado
     * @param qtdItens      Quantidade de Itens do Lanche
     * @param valorCentavos Valor Total do Lanche em centavos
     * @see br.ufcg.coisa.entidades.ContaCantina#cadastraLanche(int, int)
     */
    public void cadastrarLanche(String nomeCantina, int qtdItens, int valorCentavos) {
        ContaCantina contaCantina = this.getContaCantina(nomeCantina);
        if (contaCantina != null) {
            contaCantina.cadastraLanche(qtdItens, valorCentavos);
        }
    }

    /**
     * Efetua o pagamento do débito na Conta desejada.
     * 
     * @param nomeCantina   Nome da Cantina desejada
     * @param valorCentavos Valor do débito em centavos
     * @see br.ufcg.coisa.entidades.ContaCantina#pagaConta(int)
     */
    public void pagarConta(String nomeCantina, int valorCentavos) {
        ContaCantina contaCantina = this.getContaCantina(nomeCantina);
        if (contaCantina != null) {
            contaCantina.pagaConta(valorCentavos);
        }
    }

    /**
     * Retorna o valor que falta pagar na Cantina desejada.
     * 
     * @param nomeCantina Nome da Cantina desejada
     * @return O valor que falta ser pago, -1 se a cantina não existir
     * @see br.ufcg.coisa.entidades.ContaCantina#getFaltaPagar()
     */
    public int getFaltaPagar(String nomeCantina) {
        ContaCantina contaCantina = this.getContaCantina(nomeCantina);
        if (contaCantina != null) {
            return contaCantina.getFaltaPagar();
        }
        return -1;
    }

    /**
     * A representação em String da ContaCantina desejada.
     * 
     * @param nomeCantina nome da ContaCantina desejada
     * @return A representação da ContaCantina em String
     * @see br.ufcg.coisa.entidades.ContaCantina#toString()
     */
    public String cantinaToString(String nomeCantina) {
        ContaCantina contaCantina = this.getContaCantina(nomeCantina);
        if (contaCantina != null) {
            return contaCantina.toString();
        }
        return "    ContaCantina não cadastrada.";
    }
}
