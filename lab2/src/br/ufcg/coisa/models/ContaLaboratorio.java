package br.ufcg.coisa.models;

/**
 * Representação de uma Conta no Laboratório da UFCG.
 *
 * @author Paulo Hernane Fontes e Silva
 */
public class ContaLaboratorio {
    /**
     * Nome do Laboratório da UFCG, Padrão: LCCX sendo x podendo ser 1, 2 ou 3.
     */
    private String nomeLaboratorio;

    /**
     * Cota da conta do Laboratório (em MB) cota >= 0 cota, valor padrão: 2000.
     */
    private Integer cota;

    /**
     * Armazena quanto da cota o usuário consumiu, o consumo é maior ou igual a 0, o
     * consumo poder ser maior que a cota.
     */
    private Integer consumo;

    /**
     * Controi uma Conta do laboratório a partir de seu nome e sua cota.
     *
     * @param nomeLaboratorio Nome do laboratório em que a Conta irá ser criada
     * @param cota            Cota da Conta no laboratório que irá ser criada
     */
    public ContaLaboratorio(String nomeLaboratorio, int cota) {
        this.nomeLaboratorio = nomeLaboratorio;
        this.cota = cota;
        this.consumo = 0;
    }

    /**
     * Constroi uma Conta do laboratório a partir de seu nome, sera contruido com a
     * cota padrão de 2000mb.
     *
     * @param nomeLaboratorio Nome do Laboratório em que a irá ser criada
     */
    public ContaLaboratorio(String nomeLaboratorio) {
        this(nomeLaboratorio, 2000);
    }

    // TODO: Documentar
    public String getNomeLaboratorio() {
        return this.nomeLaboratorio;
    }

    /**
     * Consome espaço na conta do laboratório.
     *
     * @param mbytes espaço em MB a ser consumido
     */
    public void consomeEspaco(int mbytes) {
        this.consumo += mbytes;
    }

    /**
     * Libera espaço na conta do laboratório.
     *
     * @param mbytes espaço em MB a ser liberados
     */
    public void liberaEspaco(int mbytes) {
        this.consumo -= mbytes;
    }

    /**
     * Verifica se a cota no laboratório foi atingido.
     *
     * @return true se consumo for maior ou igual a cota, false se consumo for menor
     *         que a cota
     */
    public boolean atingiuCota() {
        if (this.consumo >= this.cota) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna a String que representa o Laboratório Padrão: Nome do Laborotario
     * Espaço Consumido/Cota.
     *
     * @return a representação em String do Laboratório
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.nomeLaboratorio + " " + this.consumo + "/" + this.cota;
    }
}
