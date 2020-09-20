package br.ufcg.coisa.repositorios;

import java.util.ArrayList;

import br.ufcg.coisa.entidades.Disciplina;

//TODO: Documentar
public class DisciplinaRepositorio {
    // TODO: Documentar
    private ArrayList<Disciplina> disciplinas;

    // TODO: Documentar
    public DisciplinaRepositorio() {
        this.disciplinas = new ArrayList<Disciplina>();
    }

    // TODO: Documentar
    public void cadastrarDisciplina(String nomeDisciplina) {
        Disciplina disciplina = new Disciplina(nomeDisciplina);
        this.disciplinas.add(disciplina);
    }

    // TODO: DOCUMENTAR
    private Disciplina getDisciplina(String nomeDisciplina) {
        Disciplina disciplina = null;

        for (Disciplina disciplinaAux : this.disciplinas) {
            if (disciplinaAux.getNomeDisciplina().equals(nomeDisciplina)) {
                disciplina = disciplinaAux;
                break;
            }
        }

        return disciplina;
    }

    // TODO: Documentar
    public void cadastrarHoras(String nomeDisciplina, int horas) {
        Disciplina disciplina = this.getDisciplina(nomeDisciplina);
        disciplina.cadastraHoras(horas);
    }

    // TODO: Documentar
    public void cadastrarNota(String nomeDisciplina, int nota, double valorNota) {
        Disciplina disciplina = this.getDisciplina(nomeDisciplina);
        disciplina.cadastraNota(nota, valorNota);
    }

    // TODO: Documentar
    public boolean aprovado(String nomeDisciplina) {
        Disciplina disciplina = this.getDisciplina(nomeDisciplina);
        return disciplina.aprovado();
    }

    // TODO: Documentar
    public String disciplinaToString(String nomeDisciplina) {
        Disciplina disciplina = this.getDisciplina(nomeDisciplina);
        return disciplina.toString();
    }
}
