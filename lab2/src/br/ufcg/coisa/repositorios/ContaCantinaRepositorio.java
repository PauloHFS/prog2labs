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

    // TODO: DOcumentar
    public void cadastrarLanche(String nomeCantina, int qtdItens, int valorCentavos) {
        for (ContaCantina contaCantina : this.contasCantinas) {
            if (contaCantina.getNomeCantina().equals(nomeCantina)) {
                contaCantina.cadastraLanche(qtdItens, valorCentavos);
                break;
            }
        }
    }

    // TODO: Documentar
    public void pagarConta(String nomeCantina, int valorCentavos) {
        for (ContaCantina contaCantina : this.contasCantinas) {
            if (contaCantina.getNomeCantina().equals(nomeCantina)) {
                contaCantina.pagaConta(valorCentavos);
                break;
            }
        }
    }

    // TODO: DOCUMENTAR
    public int getFaltaPagar(String nomeCantina) {
        int divida = 0;

        for (ContaCantina contaCantina : this.contasCantinas) {
            if (contaCantina.getNomeCantina().equals(nomeCantina)) {
                divida = contaCantina.getFaltaPagar();
                break;
            }
        }

        return divida;
    }

    // TODO: Documentar
    public String cantinaToString(String nomeCantina) {
        String cantinaString = null;

        for (ContaCantina contaCantina : this.contasCantinas) {
            if (contaCantina.getNomeCantina().equals(nomeCantina)) {
                cantinaString = contaCantina.toString();
                break;
            }
        }

        return cantinaString;
    }
}
