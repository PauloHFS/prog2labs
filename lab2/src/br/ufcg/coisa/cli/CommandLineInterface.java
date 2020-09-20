package br.ufcg.coisa.cli;

import java.util.Scanner;

//TODO: Implementar as funções
/**
 * Classe responsável pela inteface da linha de comando para utilização do
 * sistema COISA.
 * 
 * @author Paulo Hernane Fontes e Silva
 */
public class CommandLineInterface {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] cmd;

        menu: while (true) {
            cmd = input.nextLine().split(" ");

            if (cmd[0].equals("sair")) {
                input.close();
                break menu;
            }
        }

    }
}
