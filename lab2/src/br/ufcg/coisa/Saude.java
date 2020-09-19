package br.ufcg.coisa;

/**
 * Representação da Saúde do Aluno.
 * 
 * TODO: Adicionar EMOJI a descrição da saúde.
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
     * Constrói o objeto Saúde com a Saúde Mental e Fisica por padrão "boas".
     */
    public Saude() {
        this.saudeMental = "boa";
        this.saudeFisica = "boa";
    }

    /**
     * Atualiza a atual situação da Saúde Mental do Aluno.
     * 
     * @param valor Situação da Saúde Mental, deve ser "boa" ou "fraca"
     */
    public void defineSaudeMental(String valor) {
        if (valor.equals("boa") || valor.equals("fraca")) {
            this.saudeMental = valor;
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
        }
    }

    /**
     * Retorna a atual situação da Saúde Geral do aluno.
     * 
     * @return "boa" - se a saúde Mental e Fisica está boa, "ok" - se a saúde Mental
     *         ou Fisica está "boa" e a outra "fraca", "fraca" - se ambas estiverem
     *         "fraca"
     */
    public String getStatusGeral() {
        if (this.saudeMental == "boa" && this.saudeFisica == "boa") {
            return "boa";
        } else if (this.saudeMental == "fraca" && this.saudeFisica == "fraca") {
            return "fraca";
        } else {
            return "ok";
        }
    }

}
