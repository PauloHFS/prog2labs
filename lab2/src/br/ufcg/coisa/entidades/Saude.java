package br.ufcg.coisa.entidades;

/**
 * Representação da Saúde do Aluno.
 * 
 * @author Paulo Hernane Fontes e Silva
 */
public class Saude {

    /**
     * Armazena a atual Saúde Mental do Aluno.
     */
    private String saudeMental;

    /**
     * Armazena a atual Saúde Fisica do Aluno.
     */
    private String saudeFisica;

    /**
     * Emoji que descreve a sensação geral do Aluno.
     */
    private String emoji;

    // TODO: atualizar documentação
    /**
     * Constrói o objeto Saúde com a Saúde Mental e Fisica por padrão "boas".
     */
    public Saude() {
        this.saudeMental = "boa";
        this.saudeFisica = "boa";
        this.emoji = null;
    }

    /**
     * Atualiza a atual situação da Saúde Mental do Aluno.
     * 
     * @param valor Situação da Saúde Mental, deve ser "boa" ou "fraca"
     */
    public void defineSaudeMental(String valor) {
        if (valor.equals("boa") || valor.equals("fraca")) {
            this.saudeMental = valor;
            this.emoji = null;
        }
    }

    /**
     * Atualiza a atual situação da Saúde Fisica do Aluno.
     * 
     * @param valor Situação da Saúde Fisica, deve ser "boa" ou "fraca"
     */
    public void defineSaudeFisica(String valor) {
        if (valor.equals("boa") || valor.equals("fraca")) {
            this.saudeFisica = valor;
            this.emoji = null;
        }
    }

    // TODO: Documentar
    /**
     * @param valor
     */
    void definirEmoji(String valor) {
        this.emoji = valor;
    }

    // TODO: atualizar Documentação
    /**
     * Retorna a atual situação da Saúde Geral do aluno.
     * 
     * @return "boa" - se a saúde Mental e Fisica está boa, "ok" - se a saúde Mental
     *         ou Fisica está "boa" e a outra "fraca", "fraca" - se ambas estiverem
     *         "fraca"
     */
    public String getStatusGeral() {
        String statusGeralString;

        if (this.saudeMental == "boa" && this.saudeFisica == "boa") {
            statusGeralString = "boa";
        } else if (this.saudeMental == "fraca" && this.saudeFisica == "fraca") {
            statusGeralString = "fraca";
        } else {
            statusGeralString = "ok";
        }

        if (this.emoji != null) {
            statusGeralString += " " + this.emoji;
        }

        return statusGeralString;
    }

}
