package br.ufcg.coisa.entidades;

/**
 * Representação de uma Disciplina.
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
     * Pesos das Notas da Disciplina
     */
    private int[] pesos;

    /**
     * Horas de Estudo da Disciplina.
     */
    private Integer horasDeEstudo;

    /**
     * Média das notas da Disciplina.
     */
    private Double media;

    /**
     * Constrói uma Disciplina a partir de seu nome.
     * 
     * @param nomeDisciplina Nome da Disciplina
     */
    public Disciplina(String nomeDisciplina) {
        this(nomeDisciplina, 4);
    }

    /**
     * Constrói uma Disciplina a partir de seu nome e da quantidade de notas.
     * 
     * @param nomeDisciplina Nome da Disciplina
     * @param numNotas       Quantidade de Notas da Disciplina
     */
    public Disciplina(String nomeDisciplina, int numNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new Double[numNotas];
        this.horasDeEstudo = 0;
        this.media = 0.0;
        int[] pesos = { 1, 1, 1, 1 };
        this.pesos = pesos;
    }

    /**
     * Constrói uma Disciplina a partir de seu nome e da quantidade de notas com
     * seus respectivos pesos. O tamanho da Array dos pesos deve ser igual a
     * quantidade de notas.
     * 
     * @param nomeDisciplina Nome da Disciplina
     * @param numNotas       Quantidade de Notas da Disciplina
     * @param pesoNotas      Array com os Pesos de cada nota
     */
    public Disciplina(String nomeDisciplina, int numNotas, int[] pesoNotas) {
        this(nomeDisciplina, numNotas);
        for (int i = 0; i < this.notas.length; i++) {
            this.notas[i] = 0.0;
        }
        this.pesos = pesoNotas;
    }

    /**
     * Retorna o nome da Disciplina.
     * 
     * @return O nome da Disciplina
     */
    public String getNomeDisciplina() {
        return this.nomeDisciplina;
    }

    /**
     * Atualiza a média com base nas notas da disciplina. Sempre utilizar quando
     * fizer uma alteração em alguma nota.
     * 
     * @see #cadastraNota(int, double)
     */
    private void atualizarMedia() {
        Double somatorioNotas = 0.0;
        int somatorioPesos = 0;

        for (int i = 0; i < this.notas.length; i++) {
            somatorioNotas += this.notas[i] * this.pesos[i];
            somatorioPesos += this.pesos[i];
        }

        this.media = somatorioNotas / somatorioPesos;
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

    /**
     * Retorna uma representação em String de Disciplina. O padrão é: {Nome da
     * Disciplina} {Horas de Estudo} {Média} {Notas}.
     * 
     * @return Uma representação em String de Disciplina
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String notasString = "[";
        for (int i = 0; i < this.notas.length; i++) {
            if (i == this.notas.length - 1) {
                notasString += this.notas[i] + "]";
            } else {
                notasString += this.notas[i] + ", ";
            }
        }
        return this.nomeDisciplina + " " + this.horasDeEstudo + " " + this.media + " " + notasString;
    }
}
