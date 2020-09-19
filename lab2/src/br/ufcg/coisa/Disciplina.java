package br.ufcg.coisa;

/**
 * Representação de uma Disciplina.
 * 
 * TODO: Adicionar mais notas na disciplina.
 * 
 * @author Paulo Hernane Fontes e Silva
 */
public class Disciplina {
    /**
     * Nome da Disciplina.
     */
    private String nomeDisciplina;

    /**
     * Notas da Disciplina São 4 notas de 0 a 10 Por padrão as notas são 0.
     */
    private Double[] notas;

    /**
     * Horas de Estudo da Disciplina.
     */
    private Integer horasDeEstudo;

    /**
     * Média das notas da Disciplina.
     */
    private Double media;

    /**
     * Controi uma Disciplina a partir de seu nome.
     * 
     * @param nomeDisciplina Nome da Disciplina
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new Double[4];
        for (int i = 0; i < this.notas.length; i++) {
            this.notas[i] = 0.0;
        }
        this.horasDeEstudo = 0;
        this.media = 0.0;
    }

    /**
     * Atualiza a média com base nas notas da disciplina. Sempre utilizar quando
     * fizer uma alteração em alguma nota.
     * 
     * @see #cadastraNota(int, double)
     */
    private void atualizarMedia() {
        Double somatorioNotas = 0.0;

        for (int i = 0; i < this.notas.length; i++) {
            somatorioNotas += this.notas[i];
        }

        this.media = somatorioNotas / this.notas.length;
    }

    /**
     * Acrescenta mais horas de estudo a disciplina.
     * 
     * @param horas Horas a serem adicionadas
     */
    public void cadastraHoras(int horas) {
        this.horasDeEstudo += horas;
    }

    /**
     * Realiza o cadastro da nota da disciplina com base no seu número.
     * 
     * @param nota      Número referente a nota a ser adicionada, pode ser 1, 2, 3
     *                  ou 4
     * @param valorNota Nota propriamente dita a ser adicionada
     */
    public void cadastraNota(int nota, double valorNota) {

        int index = -1;

        if (nota == 1) {
            index = 0;
        } else if (nota == 2) {
            index = 1;
        } else if (nota == 3) {
            index = 2;
        } else if (nota == 4) {
            index = 3;
        }

        if (index != -1) {
            this.notas[index] = valorNota;
            this.atualizarMedia();
        }
    }

    /**
     * Verifica se a média alcançada na disciplina é aprovativa ou não.
     * 
     * @return true - se a nota for maior ou igual a 7, false - se não for
     */
    public boolean aprovado() {
        return this.media >= 7;
    }

    // FIXME: Arrumar uma solução para printar as notas
    /**
     * Retorna uma representação em String de Disciplina. O padrão é: {Nome da
     * Disciplina} {Horas de Estudo} {Média} {Notas}.
     * 
     * @return Uma representação em String de Disciplina
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.nomeDisciplina + " " + this.horasDeEstudo + " " + this.media + " " + this.notas;
    }
}
