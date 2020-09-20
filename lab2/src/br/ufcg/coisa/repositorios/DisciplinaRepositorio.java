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

    // TODO: Documentar
    public void cadastrarHoras(String nomeDisciplina, int horas) {
        for (Disciplina disciplina : this.disciplinas) {
            if (disciplina.getNomeDisciplina().equals(nomeDisciplina)) {
                disciplina.cadastraHoras(horas);
                break;
            }
        }
    }

    // TODO: Documentar
    public void cadastrarNota(String nomeDisciplina, int nota, double valorNota) {
        for (Disciplina disciplina : this.disciplinas) {
            if (disciplina.getNomeDisciplina().equals(nomeDisciplina)) {
                disciplina.cadastraNota(nota, valorNota);
                break;
            }
        }
    }

    // TODO: Documentar
    // FIXME: REFATORAR
    public boolean aprovado(String nomeDisciplina) {
        boolean isAprovado = false;

        for (Disciplina disciplina : this.disciplinas) {
            if (disciplina.getNomeDisciplina().equals(nomeDisciplina)) {
                isAprovado = disciplina.aprovado();
                break;
            }
        }

        return isAprovado;
    }

    // TODO: Documentar
    public String disciplinaToString(String nomeDisciplina) {
        String disciplinaString = null;

        for (Disciplina disciplina : this.disciplinas) {
            if (disciplina.getNomeDisciplina().equals(nomeDisciplina)) {
                disciplinaString = disciplina.toString();
                break;
            }
        }

        return disciplinaString;
    }
}
