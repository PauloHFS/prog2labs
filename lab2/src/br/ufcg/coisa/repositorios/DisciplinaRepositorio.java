package br.ufcg.coisa.repositorios;

import java.util.ArrayList;

import br.ufcg.coisa.entidades.Disciplina;

/**
 * Repositório de Disciplinas.
 * 
 * @author Paulo Hernane Fontes e Silva
 * @see br.ufcg.coisa.entidades.Disciplina
 */
public class DisciplinaRepositorio {
    /**
     * Array que armazena as disciplinas.
     */
    private ArrayList<Disciplina> disciplinas;

    /**
     * Constrói um repositorio de Disciplinas vazio.
     */
    public DisciplinaRepositorio() {
        this.disciplinas = new ArrayList<Disciplina>();
    }

    /**
     * Cadastra uma nova Disciplina a partir do seu nome no Repositório.
     * 
     * @param nomeDisciplina Nome da Disciplina
     */
    public void cadastrarDisciplina(String nomeDisciplina) {
        if (this.getDisciplina(nomeDisciplina) == null) {
            Disciplina disciplina = new Disciplina(nomeDisciplina);
            this.disciplinas.add(disciplina);
        }
    }

    /**
     * Retorna a Disciplina cadastrada no Repositório a partir do seu nome.
     * 
     * @param nomeDisciplina Nome da Disciplina a ser procurada
     * @return A Disciplina se estiver cadastrada ou null se não estiver cadastrada
     * @see br.ufcg.coisa.entidades.Disciplina#getNomeDisciplina()
     */
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

    /**
     * Cadastra Horas de estudo na Disciplina.
     * 
     * @param nomeDisciplina Nome da Disciplina que irá receber as Horas
     * @param horas          Quantidade de Horas em minutos a ser cadastrada
     * @see br.ufcg.coisa.entidades.Disciplina#cadastraHoras(int)
     */
    public void cadastrarHoras(String nomeDisciplina, int horas) {
        Disciplina disciplina = this.getDisciplina(nomeDisciplina);
        if (disciplina != null) {
            disciplina.cadastraHoras(horas);
        }
    }

    /**
     * Cadastra um Nota na Disciplina.
     * 
     * @param nomeDisciplina Nome da Disciplina que irá receber a Nota
     * @param nota           Identificador da nota a ser cadastrada
     * @param valorNota      A Nota que irá ser cadastrada
     * @see br.ufcg.coisa.entidades.Disciplina#cadastraNota(int, double)
     */
    public void cadastrarNota(String nomeDisciplina, int nota, double valorNota) {
        Disciplina disciplina = this.getDisciplina(nomeDisciplina);
        if (disciplina != null) {
            disciplina.cadastraNota(nota, valorNota);
        }
    }

    /**
     * Verifica se o Aluno está aprovado na Disciplina ou não.
     * 
     * @param nomeDisciplina Nome da Disciplina que será verificada
     * @return false por padrão, true se está aprovado
     * @see br.ufcg.coisa.entidades.Disciplina#aprovado()
     */
    public boolean aprovado(String nomeDisciplina) {
        Disciplina disciplina = this.getDisciplina(nomeDisciplina);
        if (disciplina != null) {
            return disciplina.aprovado();
        }
        return false;
    }

    /**
     * Retorna a representação em String da Disciplina.
     * 
     * @param nomeDisciplina Nome da Disciplina
     * @return Representação em String da Disciplina
     * @see br.ufcg.coisa.entidades.Disciplina#toString()
     */
    public String disciplinaToString(String nomeDisciplina) {
        Disciplina disciplina = this.getDisciplina(nomeDisciplina);
        if (disciplina != null) {
            return disciplina.toString();
        }
        return "Disciplina não cadastrada";
    }
}
