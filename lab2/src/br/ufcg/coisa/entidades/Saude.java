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

    /**
     * Constrói o objeto Saúde com a Saúde Mental e Fisica por padrão "boas" e sem
     * emoji.
     */
    public Saude() {
        this.saudeMental = "boa";
        this.saudeFisica = "boa";
        this.emoji = null;
    }

    /**
     * Atualiza a atual situação da Saúde Mental do Aluno.
     * 
     * Como a situação mudou o Emoji deve ser atualizado pois acredita-se que o
     * anterior não representa mais a situação do aluno.
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
     * Como a situação mudou o Emoji deve ser atualizado pois acredita-se que o
     * anterior não representa mais a situação do aluno.
     * 
     * @param valor Situação da Saúde Fisica, deve ser "boa" ou "fraca"
     */
    public void defineSaudeFisica(String valor) {
        if (valor.equals("boa") || valor.equals("fraca")) {
            this.saudeFisica = valor;
            this.emoji = null;
        }
    }

    /**
     * Defini o emoji representante da situação do aluno.
     * 
     * @param valor Emoji
     */
    void definirEmoji(String valor) {
        this.emoji = valor;
    }

    /**
     * Retorna a atual situação da Saúde Geral do aluno.
     * 
     * @return "boa" - se a saúde Mental e Fisica está boa, "ok" - se a saúde Mental
     *         ou Fisica está "boa" e a outra "fraca", "fraca" - se ambas estiverem
     *         "fraca", se houver um Emoji ele será apresentado
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
