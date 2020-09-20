package br.ufcg.coisa.entidades;

import br.ufcg.coisa.repositorios.*;

/**
 * Representação de um Alunos.
 * 
 * @author Paulo Hernane Fontes e Silva
 */
public class Aluno {

    // TODO: Documentar
    private String nome;
    // TODO: Documentar
    private DisciplinaRepositorio disciplinas;
    // TODO: Documentar
    private ContaLaboratorioRepositorio contasLaboratorios;
    // TODO: Documentar
    private ContaCantinaRepositorio contasCantinas;
    // TODO: Documentar
    private Saude saude;

    // TODO: Documentar
    public Aluno(String nome) {
        this.nome = nome;
        this.disciplinas = new DisciplinaRepositorio();
        this.contasLaboratorios = new ContaLaboratorioRepositorio();
        this.contasCantinas = new ContaCantinaRepositorio();
        this.saude = new Saude();
    }

    // TODO: Documentar
    public String getNome() {
        return this.nome;
    }

    // TODO: Documentar
    /**
     * 
     * @param nomeLaboratorio
     */
    public void cadastraLaboratorio(String nomeLaboratorio) {
        this.contasLaboratorios.cadastrarLaboratorio(nomeLaboratorio);
    }

    // TODO: Documentar
    /**
     * 
     * @param nomeLaboratorio
     * @param cota
     */
    public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
        this.contasLaboratorios.cadastrarLaboratorio(nomeLaboratorio, cota);
    }

    // TODO: Documentar
    /**
     * 
     * @param nomeLaboratorio
     * @param mbytes
     */
    public void consomeEspaco(String nomeLaboratorio, int mbytes) {
        this.contasLaboratorios.consomeEspaco(nomeLaboratorio, mbytes);
    }

    // TODO: Documentar
    public void liberaEspaco(String nomeLaboratorio, int mbytes) {
        this.contasLaboratorios.liberaEspaco(nomeLaboratorio, mbytes);
    }

    // TODO: Documentar
    public boolean atingiuCota(String nomeLaboratorio) {
        return this.contasLaboratorios.atingiuCota(nomeLaboratorio);
    }

    // TODO: Documentar
    public String laboratorioToString(String nomeLaboratorio) {
        return this.contasLaboratorios.laboratorioToString(nomeLaboratorio);
    }

    // TODO: Documentar
    public void cadastraDisciplina(String nomeDisciplina) {
        this.disciplinas.cadastrarDisciplina(nomeDisciplina);
    }

    // TODO: Documentar
    public void cadastraHoras(String nomeDisciplina, int horas) {
        this.disciplinas.cadastrarHoras(nomeDisciplina, horas);
    }

    // TODO: Documentar
    public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
        this.disciplinas.cadastrarNota(nomeDisciplina, nota, valorNota);
    }

    // TODO: Documentar
    public boolean aprovado(String nomeDisciplina) {
        return this.disciplinas.aprovado(nomeDisciplina);
    }

    // TODO: Documentar
    public String disciplinaToString(String nomeDisciplina) {
        return this.disciplinas.disciplinaToString(nomeDisciplina);
    }

    // TODO: Documentar
    public void cadastraCantina(String nomeCantina) {
        this.contasCantinas.cadastrarCantina(nomeCantina);
    }

    // TODO: Documentar
    public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
        this.contasCantinas.cadastrarLanche(nomeCantina, qtdItens, valorCentavos);
    }

    // TODO: Documentar
    public void pagarConta(String nomeCantina, int valorCentavos) {
        this.contasCantinas.pagarConta(nomeCantina, valorCentavos);
    }

    // TODO: Documentar
    public int getFaltaPagar(String nomeCantina) {
        return this.contasCantinas.getFaltaPagar(nomeCantina);
    }

    // TODO: Documentar
    public String cantinaToString(String nomeCantina) {
        return this.contasCantinas.cantinaToString(nomeCantina);
    }

    // TODO: Documentar
    public void defineSaudeMental(String valor) {
        this.saude.defineSaudeMental(valor);
    }

    // TODO: Documentar
    public void defineSaudeFisica(String valor) {
        this.saude.defineSaudeFisica(valor);
    }

    // TODO: Documentar
    public void defineSaudeEmoji(String emoji) {
        this.saude.definirEmoji(emoji);
    }

    // TODO: Documentar
    public String getStatusGeral() {
        return this.saude.getStatusGeral();
    }
}
