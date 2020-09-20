package br.ufcg.coisa.repositorios;

import java.util.ArrayList;

import br.ufcg.coisa.entidades.ContaLaboratorio;

//TODO: Documentar
public class ContaLaboratorioRepositorio {
    // TODO: Documentar
    private ArrayList<ContaLaboratorio> contasLaboratorios;

    // TODO: Documentar
    public ContaLaboratorioRepositorio() {
        this.contasLaboratorios = new ArrayList<ContaLaboratorio>();
    }

    // TODO: Documentar
    public void cadastrarLaboratorio(String nomeLaboratorio) {
        ContaLaboratorio contaLab = new ContaLaboratorio(nomeLaboratorio);
        this.contasLaboratorios.add(contaLab);
    }

    // TODO: DOcumentar
    public void cadastrarLaboratorio(String nomeLaboratorio, int cota) {
        ContaLaboratorio contaLab = new ContaLaboratorio(nomeLaboratorio, cota);
        this.contasLaboratorios.add(contaLab);
    }

    // TODO: Documentar
    public void consomeEspaco(String nomeLaboratorio, int mbytes) {
        for (ContaLaboratorio contaLab : this.contasLaboratorios) {
            if (contaLab.getNomeLaboratorio().equals(nomeLaboratorio)) {
                contaLab.consomeEspaco(mbytes);
                break;
            }
        }
    }

    // TODO: DOcumentar
    public void liberaEspaco(String nomeLaboratorio, int mbytes) {
        for (ContaLaboratorio contaLab : this.contasLaboratorios) {
            if (contaLab.getNomeLaboratorio().equals(nomeLaboratorio)) {
                contaLab.liberaEspaco(mbytes);
                break;
            }
        }
    }

    // TODO: Documentar
    public boolean atingiuCota(String nomeLaboratorio) {
        boolean atingiuCota = false;

        for (ContaLaboratorio contaLab : this.contasLaboratorios) {
            if (contaLab.getNomeLaboratorio().equals(nomeLaboratorio)) {
                atingiuCota = contaLab.atingiuCota();
                break;
            }
        }

        return atingiuCota;
    }

    // TODO: Documentar
    public String laboratorioToString(String nomeLaboratorio) {
        String laboratorioString = null;

        for (ContaLaboratorio contaLab : this.contasLaboratorios) {
            if (contaLab.getNomeLaboratorio().equals(nomeLaboratorio)) {
                laboratorioString = contaLab.toString();
                break;
            }
        }

        return laboratorioString;
    }
}
