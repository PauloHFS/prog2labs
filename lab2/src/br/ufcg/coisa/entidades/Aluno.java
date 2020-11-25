package br.ufcg.coisa.entidades;

import br.ufcg.coisa.repositorios.*;

/**
 * Representação de um Alunos.
 * 
 * @author Paulo Hernane Fontes e Silva
 */
public class Aluno {

    /**
     * Nome do Aluno.
     */
    private String nome;
    /**
     * Disciplinas do Aluno.
     */
    private DisciplinaRepositorio disciplinas;
    /**
     * Contas de Laboratório do Aluno.
     */
    private ContaLaboratorioRepositorio contasLaboratorios;
    /**
     * Contas nas Cantinas do Aluno.
     */
    private ContaCantinaRepositorio contasCantinas;
    /**
     * Saúde do Aluno.
     */
    private Saude saude;

    /**
     * Constrói um novo Aluno.
     * 
     * @param nome Nome do Aluno
     */
    public Aluno(String nome) {
        this.nome = nome;
        this.disciplinas = new DisciplinaRepositorio();
        this.contasLaboratorios = new ContaLaboratorioRepositorio();
        this.contasCantinas = new ContaCantinaRepositorio();
        this.saude = new Saude();
    }

    /**
     * Retorna o nome do Aluno.
     * 
     * @return o nome do Aluno
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Cadastra uma conta de Laboratório.
     * 
     * @param nomeLaboratorio Nome do Laboratorio
     */
    public void cadastraLaboratorio(String nomeLaboratorio) {
        this.contasLaboratorios.cadastrarLaboratorio(nomeLaboratorio);
    }

    /**
     * Cadastra uma conta de Laboratório.
     * 
     * @param nomeLaboratorio Nome do Laboratório
     * @param cota            Cota do laboratório
     */
    public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
        this.contasLaboratorios.cadastrarLaboratorio(nomeLaboratorio, cota);
    }

    /**
     * Consome espaço no laboratorio.
     * 
     * @param nomeLaboratorio Nome do Laboratório
     * @param mbytes          Espaço consumido
     */
    public void consomeEspaco(String nomeLaboratorio, int mbytes) {
        this.contasLaboratorios.consomeEspaco(nomeLaboratorio, mbytes);
    }

    /**
     * Libera espaço no laboratorio.
     * 
     * @param nomeLaboratorio Nome do Laboratorio
     * @param mbytes          Espaço liberado
     */
    public void liberaEspaco(String nomeLaboratorio, int mbytes) {
        this.contasLaboratorios.liberaEspaco(nomeLaboratorio, mbytes);
    }

    /**
     * Verifica se o Aluno atingiu a cota no Laboratorio.
     * 
     * @param nomeLaboratorio Nome do Laboratorio
     * @return true se atingiu a cota, false se não atingiu.
     */
    public boolean atingiuCota(String nomeLaboratorio) {
        return this.contasLaboratorios.atingiuCota(nomeLaboratorio);
    }

    /**
     * Retorna a representação do Laboratorio em String.
     * 
     * @param nomeLaboratorio Nome do Laboratorio
     * @return a representação do Laboratorio em String
     */
    public String laboratorioToString(String nomeLaboratorio) {
        return this.contasLaboratorios.laboratorioToString(nomeLaboratorio);
    }

    /**
     * Cadastra uma Disciplina.
     * 
     * @param nomeDisciplina Nome da Disciplina
     */
    public void cadastraDisciplina(String nomeDisciplina) {
        this.disciplinas.cadastrarDisciplina(nomeDisciplina);
    }

    /**
     * Cadastra horas de estudo em uma Disciplina.
     * 
     * @param nomeDisciplina Nome da Disciplina
     * @param horas          Quantidade de horas
     */
    public void cadastraHoras(String nomeDisciplina, int horas) {
        this.disciplinas.cadastrarHoras(nomeDisciplina, horas);
    }

    /**
     * Cadastra nota em uma disciplina.
     * 
     * @param nomeDisciplina Nome da Disciplina
     * @param nota           Nota a ser cadastrada
     * @param valorNota      Valor da nota
     */
    public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
        this.disciplinas.cadastrarNota(nomeDisciplina, nota, valorNota);
    }

    /**
     * Verifica se o Aluno foi aprovado na disciplina.
     * 
     * @param nomeDisciplina Nome da Disciplina
     * @return true se o aluno for aprovado, false se não.
     */
    public boolean aprovado(String nomeDisciplina) {
        return this.disciplinas.aprovado(nomeDisciplina);
    }

    /**
     * Retorna a representação da Disciplina em String.
     * 
     * @param nomeDisciplina Nome da Disciplina
     * @return a representação da Disciplina em String
     */
    public String disciplinaToString(String nomeDisciplina) {
        return this.disciplinas.disciplinaToString(nomeDisciplina);
    }

    /**
     * Cadastra uma nova ContaCantina.
     * 
     * @param nomeCantina Nome da Cantina
     */
    public void cadastraCantina(String nomeCantina) {
        this.contasCantinas.cadastrarCantina(nomeCantina);
    }

    /**
     * Cadastra um Lanche em uma Cantina.
     * 
     * @param nomeCantina   Nome da Cantina
     * @param qtdItens      Quantidade de Itens
     * @param valorCentavos Valor do Lanche em centavos
     */
    public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
        this.contasCantinas.cadastrarLanche(nomeCantina, qtdItens, valorCentavos);
    }

    /**
     * Efetua o pagamento de um debito em uma Cantina.
     * 
     * @param nomeCantina   Nome da Cantina
     * @param valorCentavos Valor pago
     */
    public void pagarConta(String nomeCantina, int valorCentavos) {
        this.contasCantinas.pagarConta(nomeCantina, valorCentavos);
    }

    /**
     * Retorna o valor do débito na Cantina.
     * 
     * @param nomeCantina Nome da Cantina
     * @return O valor do débito
     */
    public int getFaltaPagar(String nomeCantina) {
        return this.contasCantinas.getFaltaPagar(nomeCantina);
    }

    /**
     * Retorna a representação da Cantina em String.
     * 
     * @param nomeCantina Nome da Cantina
     * @return a representação da Cantina em String
     */
    public String cantinaToString(String nomeCantina) {
        return this.contasCantinas.cantinaToString(nomeCantina);
    }

    /**
     * Define a situação da Saude Mental do Aluno.
     * 
     * @param valor situação da saude (boa ou fraca)
     */
    public void defineSaudeMental(String valor) {
        this.saude.defineSaudeMental(valor);
    }

    /**
     * Define a situação da saude fisica do Aluno.
     * 
     * @param valor situação da saude (boa ou fraca)
     */
    public void defineSaudeFisica(String valor) {
        this.saude.defineSaudeFisica(valor);
    }

    /**
     * Define o Emoji que representa a situação da Saude do aluno.
     * 
     * @param emoji Emoji
     */
    public void defineSaudeEmoji(String emoji) {
        this.saude.definirEmoji(emoji);
    }

    /**
     * Retorna o Status Geral do Aluno.
     * 
     * @return o status geral do aluno
     */
    public String getStatusGeral() {
        return this.saude.getStatusGeral();
    }
}
