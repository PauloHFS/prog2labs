package br.ufcg.coisa.repositorios;

import java.util.ArrayList;

import br.ufcg.coisa.entidades.Aluno;

//TODO: Documentar
public class AlunoRepositorio {

    // TODO: Documentar
    private ArrayList<Aluno> alunos;

    // TODO: Documentar
    public AlunoRepositorio() {
        this.alunos = new ArrayList<Aluno>();
    }

    // TODO: Documentar
    public void cadastrarAluno(String nomeAluno) {
        Aluno aluno = new Aluno(nomeAluno);
        this.alunos.add(aluno);
    }

    // TODO: Documentar
    private Aluno getAluno(String nomeAluno) {
        Aluno aluno = null;

        for (Aluno a : this.alunos) {
            if (a.getNome().equals(nomeAluno)) {
                aluno = a;
            }
        }

        return aluno;
    }

    // TODO: Documentar
    public void cadastraLaboratorio(String nomeAluno, String nomeLaboratorio) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.cadastraLaboratorio(nomeLaboratorio);
    }

    // TODO: Documentar
    public void cadastraLaboratorio(String nomeAluno, String nomeLaboratorio, int cota) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.cadastraLaboratorio(nomeLaboratorio, cota);
    }

    // TODO: Documentar
    public void consomeEspaco(String nomeAluno, String nomeLaboratorio, int mbytes) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.consomeEspaco(nomeLaboratorio, mbytes);
    }

    // TODO: Documentar
    public void liberaEspaco(String nomeAluno, String nomeLaboratorio, int mbytes) {
        Aluno aluno = this.getAluno(nomeAluno);
        aluno.liberaEspaco(nomeLaboratorio, mbytes);
    }

    // TODO: Documentar
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

    // TODO: Documentar
    public String getStatusGeral(String nomeAluno) {
        Aluno aluno = this.getAluno(nomeAluno);
        return aluno.getStatusGeral();
    }

}
