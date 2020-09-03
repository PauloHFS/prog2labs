package lp2.lab01;

public class IdadePreferencialInteligente {
    public static void main(String[] args) {
        int idade = 20, numCriancas = 0;
        boolean gestante = false;

        String preferencia = "";
        if (idade >= 60) {
            preferencia = "Preferencial Idoso.";
        } else if (gestante) {
            preferencia = "Preferencial Gestante.";
        } else if (numCriancas > 0) {
            preferencia = "Preferencial pois está com " + numCriancas + " crianças de colo.";
        } else {
            preferencia = "Você não tem preferencia.";
        }

        System.out.println(preferencia);
    }
}
