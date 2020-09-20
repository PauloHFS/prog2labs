package br.ufcg.coisa.repositorios;

import br.ufcg.coisa.models.utils.Lanche;

//TODO: Documentar
/**
 */
public class LancheRepositorio {
    // TODO: Documentar
    /**
     */
    private Lanche[] lanches;

    // TODO: Documentar
    /**
     */
    private Integer lanchesCadatrados;

    // TODO: Documentar
    /**
     */
    public LancheRepositorio() {
        this.lanches = new Lanche[5];
        this.lanchesCadatrados = 0;
    }

    // TODO: Documentar
    // FIXME: reajustar array quando cadastrado acima do limite
    /**
     * @param qtdItens
     * @param valorCentavos
     * @param detalhes
     */
    public void cadastraLanche(int qtdItens, int valorCentavos, String detalhes) {
        if (lanchesCadatrados < 5) {
            this.lanches[lanchesCadatrados] = new Lanche(qtdItens, valorCentavos, detalhes);
            lanchesCadatrados += 1;
        }
    }

    // TODO: Documentar
    /**
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
