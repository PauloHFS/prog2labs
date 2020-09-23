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

    // TODO: Documentar
    // FIXME: Refatorar para o getAluno
    public boolean temAluno(String nomeAluno) {
        return this.getAluno(nomeAluno) != null;
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

    // TODO: Documentar
    /**
     * 
     * 
     * @return True se o aluno atingiu a a cota do laboratorio
     */
    public boolean atingiuCota(String nomeAluno, String nomeLaboratorio) {
        Aluno aluno = this.getAluno(nomeAluno);
        return aluno.atingiuCota(nomeLaboratorio);
    }

    // TODO: Documentar
    public String laboratorioToString(String nomeAluno, String nomeLaboratorio) {
        Aluno aluno = this.getAluno(nomeAluno);
        return aluno.laboratorioToString(nomeLaboratorio);
    }

    // TODO: Documentar
    public void cadastraDisciplina(String nomeAluno, String nomeDisciplina) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.cadastraDisciplina(nomeDisciplina);
    }

    // TODO: Documentar
    public void cadastraHoras(String nomeAluno, String nomeDisciplina, int horas) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.cadastraHoras(nomeDisciplina, horas);
    }

    // TODO: Documentar
    public void cadastraNota(String nomeAluno, String nomeDisciplina, int nota, double valorNota) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.cadastraNota(nomeDisciplina, nota, valorNota);
    }

    // TODO: Documentar
    public boolean aprovado(String nomeAluno, String nomeDisciplina) {
        Aluno aluno = this.getAluno(nomeAluno);
        return aluno.aprovado(nomeDisciplina);
    }

    // TODO: Documentar
    public String disciplinaToString(String nomeAluno, String nomeDisciplina) {
        Aluno aluno = this.getAluno(nomeAluno);
        return aluno.disciplinaToString(nomeDisciplina);
    }

    // TODO: Documentar
    public void cadastraCantina(String nomeAluno, String nomeCantina) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.cadastraCantina(nomeCantina);
    }

    // TODO: Documentar
    public void cadastraLanche(String nomeAluno, String nomeCantina, int qtdItens, int valorCentavos) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.cadastraLanche(nomeCantina, qtdItens, valorCentavos);
    }

    // TODO: Documentar
    public void pagarConta(String nomeAluno, String nomeCantina, int valorCentavos) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.pagarConta(nomeCantina, valorCentavos);
    }

    // TODO: Documentar
    public int getFaltaPagar(String nomeAluno, String nomeCantina) {
        Aluno aluno = this.getAluno(nomeAluno);
        return aluno.getFaltaPagar(nomeCantina);
    }

    // TODO: Documentar
    public String cantinaToString(String nomeAluno, String nomeCantina) {
        Aluno aluno = this.getAluno(nomeAluno);
        return aluno.cantinaToString(nomeCantina);
    }

    // TODO: Documentar
    public void defineSaudeMental(String nomeAluno, String valor) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.defineSaudeMental(valor);
    }

    // TODO: Documentar
    public void defineSaudeFisica(String nomeAluno, String valor) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.defineSaudeFisica(valor);
    }

    public void defineSaudeEmoji(String nomeAluno, String emoji) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.defineSaudeEmoji(emoji);
    }

    /**
     * Retorna o Status Geral do Aluno
     * 
     * @param nomeAluno Nome do Aluno
     * @return
     */
    public String getStatusGeral(String nomeAluno) {
        Aluno aluno = this.getAluno(nomeAluno);
        return aluno.getStatusGeral();
    }

}
