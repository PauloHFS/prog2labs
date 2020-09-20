package br.ufcg.coisa.models;

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

    // TODO: Documentar e IMPLEMENTAR
    /**
     * 
     * @param nomeLaboratorio
     */
    void cadastraLaboratorio(String nomeLaboratorio) {
    }

    // TODO: Documentar e IMPLEMENTAR
    /**
     * 
     * @param nomeLaboratorio
     * @param cota
     */
    void cadastraLaboratorio(String nomeLaboratorio, int cota) {
    }

    // TODO: Documentar e IMPLEMENTAR
    /**
     * 
     * @param nomeLaboratorio
     * @param mbytes
     */
    void consomeEspaco(String nomeLaboratorio, int mbytes) {
    }

    // TODO: Documentar e IMPLEMENTAR
    void liberaEspaco(String nomeLaboratorio, int mbytes) {
    }

    // TODO: Documentar e IMPLEMENTAR
    boolean atingiuCota(String nomeLaboratorio) {
        return false;
    }

    // TODO: Documentar e IMPLEMENTAR
    String laboratorioToString(String nomeLaboratorio) {
        return nomeLaboratorio;
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
    void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
        this.disciplinas.cadastrarNota(nomeDisciplina, nota, valorNota);
    }

    // TODO: Documentar
    boolean aprovado(String nomeDisciplina) {
        return this.disciplinas.aprovado(nomeDisciplina);
    }

    // TODO: Documentar
    String disciplinaToString(String nomeDisciplina) {
        return this.disciplinas.disciplinaToString(nomeDisciplina);
    }

    // TODO: Documentar e IMPLEMENTAR
    void cadastraCantina(String nomeCantina) {
    }

    // TODO: Documentar e IMPLEMENTAR
    void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
    }

    // TODO: Documentar e IMPLEMENTAR
    void pagarConta(String nomeCantina, int valorCentavos) {
    }

    // TODO: Documentar e IMPLEMENTAR
    int getFaltaPagar(String nomeCantina) {
        return 0;
    }

    // TODO: Documentar e IMPLEMENTAR
    String cantinaToString(String nomeCantina) {
        return nomeCantina;
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
