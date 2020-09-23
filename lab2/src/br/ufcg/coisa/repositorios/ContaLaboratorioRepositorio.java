package br.ufcg.coisa.repositorios;

import java.util.ArrayList;

import br.ufcg.coisa.entidades.ContaLaboratorio;

/**
 * Repositório de ContaLaboratorio.
 * 
 * @author Paulo Hernane Fontes e Silva
 * @see br.ufcg.coisa.entidades.ContaLaboratorio
 */
public class ContaLaboratorioRepositorio {
    /**
     * Array que armazena os Laboratórios.
     */
    private ArrayList<ContaLaboratorio> contasLaboratorios;

    /**
     * Constrói um Repositório de Laboratórios vazios.
     */
    public ContaLaboratorioRepositorio() {
        this.contasLaboratorios = new ArrayList<ContaLaboratorio>();
    }

    /**
     * Cadastra um novo Laboratório com a cota padrão no Repositório.
     * 
     * @param nomeLaboratorio Nome do Laboratório
     */
    public void cadastrarLaboratorio(String nomeLaboratorio) {
        ContaLaboratorio contaLab = new ContaLaboratorio(nomeLaboratorio);
        this.contasLaboratorios.add(contaLab);
    }

    /**
     * Cadastra um novo Laboratório com uma cota diferente no Repositório.
     * 
     * @param nomeLaboratorio Nome do Laboratório
     * @param cota            Cota do Laboratório
     */
    public void cadastrarLaboratorio(String nomeLaboratorio, int cota) {
        ContaLaboratorio contaLab = new ContaLaboratorio(nomeLaboratorio, cota);
        this.contasLaboratorios.add(contaLab);
    }

    /**
     * Retorna uma ContaLaboratorio cadastrada no Repositório.
     * 
     * @param nomeLaboratorio Nome do Laboratorio desejado
     * @return ContaLaboratorio desejado, null se não estiver cadastrado
     * @see br.ufcg.coisa.entidades.ContaLaboratorio#getNomeLaboratorio()
     */
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

    /**
     * Consome o Espaço na Cota do Laboratório desejado.
     * 
     * @param nomeLaboratorio Nome do Laboratório desejado
     * @param mbytes          Quantidade de Espaço a ser consumida em MEGAbytes
     * @see br.ufcg.coisa.entidades.ContaLaboratorio#consomeEspaco(int)
     */
    public void consomeEspaco(String nomeLaboratorio, int mbytes) {
        ContaLaboratorio contaLaboratorio = this.getContaLaboratorio(nomeLaboratorio);
        if (contaLaboratorio != null) {
            contaLaboratorio.consomeEspaco(mbytes);
        }
    }

    /**
     * Libera Espaço na Cota do Laboratório desejado.
     * 
     * @param nomeLaboratorio Nome do Laboratório desejado
     * @param mbytes          Quantidade de Espaço a ser liberada em MEGAbytes
     * @see br.ufcg.coisa.entidades.ContaLaboratorio#liberaEspaco(int)
     */
    public void liberaEspaco(String nomeLaboratorio, int mbytes) {
        ContaLaboratorio contaLaboratorio = this.getContaLaboratorio(nomeLaboratorio);
        if (contaLaboratorio != null) {
            contaLaboratorio.liberaEspaco(mbytes);
        }
    }

    /**
     * Verifica se a Cota no Laboratório já foi atingida.
     * 
     * @param nomeLaboratorio Nome do Laboratório desejado
     * @return true se a Cota foi atingida, false se não (por padrão).
     * @see br.ufcg.coisa.entidades.ContaLaboratorio#atingiuCota()
     */
    public boolean atingiuCota(String nomeLaboratorio) {
        ContaLaboratorio contaLaboratorio = this.getContaLaboratorio(nomeLaboratorio);
        if (contaLaboratorio != null) {
            return contaLaboratorio.atingiuCota();
        }
        return false;
    }

    /**
     * Retorna a representação em String do Laboratório.
     * 
     * @param nomeLaboratorio Nome do Laboratório desejado
     * @return A representação em String do Laboratório
     * @see br.ufcg.coisa.entidades.ContaLaboratorio#toString()
     */
    public String laboratorioToString(String nomeLaboratorio) {
        ContaLaboratorio contaLaboratorio = this.getContaLaboratorio(nomeLaboratorio);
        if (contaLaboratorio != null) {
            return contaLaboratorio.toString();
        }
        return "ContaLaboratorio não cadasrado";
    }
}
