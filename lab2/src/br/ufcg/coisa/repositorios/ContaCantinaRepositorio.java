package br.ufcg.coisa.repositorios;

import java.util.ArrayList;

import br.ufcg.coisa.entidades.ContaCantina;

//TODO: Documentar
public class ContaCantinaRepositorio {
    // TODO: Documentar
    private ArrayList<ContaCantina> contasCantinas;

    // TODO: DOcumentar
    public ContaCantinaRepositorio() {
        this.contasCantinas = new ArrayList<ContaCantina>();
    }

    // TODO: Documentar
    public void cadastrarCantina(String nomeCantina) {
        ContaCantina contaCantina = new ContaCantina(nomeCantina);
        this.contasCantinas.add(contaCantina);
    }

    // TODO: Documentar
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

    // TODO: DOcumentar
    public void cadastrarLanche(String nomeCantina, int qtdItens, int valorCentavos) {
        ContaCantina contaCantina = this.getContaCantina(nomeCantina);
        contaCantina.cadastraLanche(qtdItens, valorCentavos);
    }

    // TODO: Documentar
    public void pagarConta(String nomeCantina, int valorCentavos) {
        ContaCantina contaCantina = this.getContaCantina(nomeCantina);
        contaCantina.pagaConta(valorCentavos);
    }

    // TODO: DOCUMENTAR
    public int getFaltaPagar(String nomeCantina) {
        ContaCantina contaCantina = this.getContaCantina(nomeCantina);
        return contaCantina.getFaltaPagar();
    }

    // TODO: Documentar
    public String cantinaToString(String nomeCantina) {
        ContaCantina contaCantina = this.getContaCantina(nomeCantina);
        return contaCantina.toString();
    }
}
