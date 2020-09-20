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
    private ContaLaboratorio getContaLaboratorio(String nomeLaboratorio) {
        ContaLaboratorio contaLaboratorio = null;

        for (ContaLaboratorio contaLab : this.contasLaboratorios) {
            if (contaLab.getNomeLaboratorio().equals(nomeLaboratorio)) {
                contaLaboratorio = contaLab;
                break;
            }
        }

        return contaLaboratorio;
    }

    // TODO: Documentar
    public void consomeEspaco(String nomeLaboratorio, int mbytes) {
        ContaLaboratorio contaLaboratorio = this.getContaLaboratorio(nomeLaboratorio);
        contaLaboratorio.consomeEspaco(mbytes);
    }

    // TODO: DOcumentar
    public void liberaEspaco(String nomeLaboratorio, int mbytes) {
        ContaLaboratorio contaLaboratorio = this.getContaLaboratorio(nomeLaboratorio);
        contaLaboratorio.liberaEspaco(mbytes);
    }

    // TODO: Documentar
    public boolean atingiuCota(String nomeLaboratorio) {
        ContaLaboratorio contaLaboratorio = this.getContaLaboratorio(nomeLaboratorio);
        return contaLaboratorio.atingiuCota();
    }

    // TODO: Documentar
    public String laboratorioToString(String nomeLaboratorio) {
        ContaLaboratorio contaLaboratorio = this.getContaLaboratorio(nomeLaboratorio);
        return contaLaboratorio.toString();
    }
}
