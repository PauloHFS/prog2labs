package br.ufcg.coisa.repositorios;

import java.util.ArrayList;

import br.ufcg.coisa.entidades.Aluno;

/**
 * Repositório de Alunos.
 * 
 * @author Paulo Hernane Fontes e Silva
 * @see br.ufcg.coisa.entidades.Aluno
 */
public class AlunoRepositorio {

    /**
     * Array que armazena os Alunos.
     */
    private ArrayList<Aluno> alunos;

    /**
     * Contrói um Repositório de Alunos vazio.
     */
    public AlunoRepositorio() {
        this.alunos = new ArrayList<Aluno>();
    }

    /**
     * Cadastra um novo Aluno no Repositório.
     * 
     * @param nomeAluno Nome do Aluno
     */
    public void cadastrarAluno(String nomeAluno) {
        Aluno aluno = new Aluno(nomeAluno);
        this.alunos.add(aluno);
    }

    /**
     * Retorna o Aluno desejado com base no seu Nome.
     * 
     * @param nomeAluno Nome do Aluno Desejado
     * @return Aluno desejado, null se não estiver cadastrado no repositório
     */
    public Aluno getAluno(String nomeAluno) {
        Aluno aluno = null;

        for (Aluno a : this.alunos) {
            if (a.getNome().equals(nomeAluno)) {
                aluno = a;
            }
        }

        return aluno;
    }

    /**
     * Verifica se há Alunos cadastrados no Repositório.
     * 
     * @return true se tiver algum Aluno cadastrado, false se não
     */
    public boolean haAlunosCadastrados() {
        return this.alunos.size() != 0;
    }

    /**
     * Cadastrar um novo Laboratório com a Cota Padrão no Repositório.
     * 
     * @param nomeAluno       Nome do Aluno
     * @param nomeLaboratorio Nome do Laboratório
     * @see br.ufcg.coisa.entidades.Aluno#cadastraLaboratorio(String)
     */
    public void cadastraLaboratorio(String nomeAluno, String nomeLaboratorio) {
        Aluno aluno = this.getAluno(nomeAluno);
        if (aluno != null) {
            aluno.cadastraLaboratorio(nomeLaboratorio);
        }
    }

    /**
     * Cadastrar um novo Laboratório com um Cota personalizada no Repositório.
     * 
     * @param nomeAluno       Nome do Aluno
     * @param nomeLaboratorio Nome do Laboratório
     * @param cota            Cota do Laboratório em MEGAbytes
     * @see br.ufcg.coisa.entidades.Aluno#cadastraLaboratorio(String, int)
     */
    public void cadastraLaboratorio(String nomeAluno, String nomeLaboratorio, int cota) {
        Aluno aluno = this.getAluno(nomeAluno);
        if (aluno != null) {
            aluno.cadastraLaboratorio(nomeLaboratorio, cota);
        }
    }

    /**
     * Consome Espaço no Laborátorio.
     * 
     * @param nomeAluno       Nome do Aluno
     * @param nomeLaboratorio Nome do Laboratório
     * @param mbytes          Espaço consumido em MEGAbytes
     * @see br.ufcg.coisa.entidades.Aluno#consomeEspaco(String, int)
     */
    public void consomeEspaco(String nomeAluno, String nomeLaboratorio, int mbytes) {
        Aluno aluno = this.getAluno(nomeAluno);
        if (aluno != null) {
            aluno.consomeEspaco(nomeLaboratorio, mbytes);
        }
    }

    /**
     * Liberar Espaço no Laboratório.
     * 
     * @param nomeAluno       Nome do Aluno
     * @param nomeLaboratorio Nome do Laboratório
     * @param mbytes          Espaço a ser liberado em MEGAbytes
     * @see br.ufcg.coisa.entidades.Aluno#liberaEspaco(String, int)
     */
    public void liberaEspaco(String nomeAluno, String nomeLaboratorio, int mbytes) {
        Aluno aluno = this.getAluno(nomeAluno);
        if (aluno != null) {
            aluno.liberaEspaco(nomeLaboratorio, mbytes);
        }
    }

    /**
     * Verifica se o aluno atingiu a cota de dados laboratório.
     * 
     * @param nomeAluno       Nome do Aluno
     * @param nomeLaboratorio Nome de Laboratorio
     * @return True se o aluno atingiu a cota do laboratorio, False se não atingiu
     */
    public boolean atingiuCota(String nomeAluno, String nomeLaboratorio) {
        Aluno aluno = this.getAluno(nomeAluno);
        return aluno.atingiuCota(nomeLaboratorio);
    }

    /**
     * Retorna a representação em String do Laboratorio.
     * 
     * @param nomeAluno       Nome do Aluno
     * @param nomeLaboratorio Nome do Laboratorio
     * @return a representação em String do Laboratorio
     * @see java.lang.Object#toString()
     */
    public String laboratorioToString(String nomeAluno, String nomeLaboratorio) {
        Aluno aluno = this.getAluno(nomeAluno);
        return aluno.laboratorioToString(nomeLaboratorio);
    }

    /**
     * Cadastra uma nova Disciplina.
     * 
     * @param nomeAluno      Nome do Aluno
     * @param nomeDisciplina Nome da Disciplina
     */
    public void cadastraDisciplina(String nomeAluno, String nomeDisciplina) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.cadastraDisciplina(nomeDisciplina);
    }

    /**
     * Cadastra horas de estudos em uma Disciplina.
     * 
     * @param nomeAluno      Nome do Aluno
     * @param nomeDisciplina Nome da Disciplina
     * @param horas          Horas a serem adicionadas
     */
    public void cadastraHoras(String nomeAluno, String nomeDisciplina, int horas) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.cadastraHoras(nomeDisciplina, horas);
    }

    /**
     * Cadastra uma nova nota na Disciplina.
     * 
     * @param nomeAluno      Nome do Aluno
     * @param nomeDisciplina Nome da Disciplina
     * @param nota           Número da Nota
     * @param valorNota      Valor da nota
     */
    public void cadastraNota(String nomeAluno, String nomeDisciplina, int nota, double valorNota) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.cadastraNota(nomeDisciplina, nota, valorNota);
    }

    /**
     * Verifica se o Aluno está Aprovado na Disciplina.
     * 
     * @param nomeAluno      Nome do Aluno
     * @param nomeDisciplina Nome da Disciplina
     * @return true se está aprovado, false se não
     */
    public boolean aprovado(String nomeAluno, String nomeDisciplina) {
        Aluno aluno = this.getAluno(nomeAluno);
        return aluno.aprovado(nomeDisciplina);
    }

    /**
     * Retorna a representação em String da Disciplina.
     * 
     * @param nomeAluno      Nome do Aluno
     * @param nomeDisciplina Nome da Disciplina
     * @return a representaçãoe me String da Disciplina
     */
    public String disciplinaToString(String nomeAluno, String nomeDisciplina) {
        Aluno aluno = this.getAluno(nomeAluno);
        return aluno.disciplinaToString(nomeDisciplina);
    }

    /**
     * Cadastra um ContaCantina.
     * 
     * @param nomeAluno   Nome do Aluno
     * @param nomeCantina Nome da Cantina
     */
    public void cadastraCantina(String nomeAluno, String nomeCantina) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.cadastraCantina(nomeCantina);
    }

    /**
     * Cadastar um Lanche na Cantina especifica.
     * 
     * @param nomeAluno     Nome do Aluno
     * @param nomeCantina   Nome da Cantina
     * @param qtdItens      Quantidade de Itens
     * @param valorCentavos Valor do Lanche em centavos
     */
    public void cadastraLanche(String nomeAluno, String nomeCantina, int qtdItens, int valorCentavos) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.cadastraLanche(nomeCantina, qtdItens, valorCentavos);
    }

    /**
     * Efetua o pagamento de um débito em uma Cantina.
     * 
     * @param nomeAluno     Nome do Aluno
     * @param nomeCantina   Nome da Cantina
     * @param valorCentavos Valor do Pagamento em centavos
     */
    public void pagarConta(String nomeAluno, String nomeCantina, int valorCentavos) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.pagarConta(nomeCantina, valorCentavos);
    }

    /**
     * Retorna o Valor do débito na Cantina.
     * 
     * @param nomeAluno   Nome do Aluno
     * @param nomeCantina Nome da Cantina
     * @return O valor do Débito
     */
    public int getFaltaPagar(String nomeAluno, String nomeCantina) {
        Aluno aluno = this.getAluno(nomeAluno);
        return aluno.getFaltaPagar(nomeCantina);
    }

    /**
     * Retorna a representação da ContaCantina em String.
     * 
     * @param nomeAluno   Nome do Aluno
     * @param nomeCantina Nome da Cantina
     * @return A representação da COntaCantina em String
     */
    public String cantinaToString(String nomeAluno, String nomeCantina) {
        Aluno aluno = this.getAluno(nomeAluno);
        return aluno.cantinaToString(nomeCantina);
    }

    /**
     * Define a Saúde Mental do Aluno.
     * 
     * @param nomeAluno Nome do Aluno
     * @param valor     Situação da Saude Mental (boa ou fraca)
     */
    public void defineSaudeMental(String nomeAluno, String valor) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.defineSaudeMental(valor);
    }

    /**
     * Define a Saúde Fisica do Aluno.
     * 
     * @param nomeAluno Nome do Aluno
     * @param valor     Situação da Saude fisica (boa ou fraca)
     */
    public void defineSaudeFisica(String nomeAluno, String valor) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.defineSaudeFisica(valor);
    }

    /**
     * Define um Emoji referente a situação do Aluno.
     * 
     * @param nomeAluno Nome do Aluno
     * @param emoji     Emoji
     */
    public void defineSaudeEmoji(String nomeAluno, String emoji) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.defineSaudeEmoji(emoji);
    }

    /**
     * Retorna o Status Geral do Aluno.
     * 
     * @param nomeAluno Nome do Aluno
     * @return A Situação da Saúde do Aluno
     */
    public String getStatusGeral(String nomeAluno) {
        Aluno aluno = this.getAluno(nomeAluno);
        return aluno.getStatusGeral();
    }

}
