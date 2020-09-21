package br.ufcg.coisa.cli;

import java.util.Scanner;

import br.ufcg.coisa.entidades.Aluno;
import br.ufcg.coisa.repositorios.AlunoRepositorio;

//TODO: Implementar as funções
/**
 * Classe responsável pela inteface da linha de comando para utilização do
 * sistema de Controle Institucional da Situação Acadêmica (COISA).
 * 
 * @author Paulo Hernane Fontes e Silva
 */
public class CommandLineInterface {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] cmd;
        String feedback = "";
        Aluno alunoLogado = null;
        AlunoRepositorio alunos = new AlunoRepositorio();

        menu: while (true) {
            if (alunoLogado == null) {
                System.out.print("[OFF]>");
            } else {
                System.out.print(alunoLogado.getNome() + ">");
            }
            cmd = input.nextLine().split(" ");

            if (cmd[0].equals("cadastrar")) {
                if (cmd.length == 3) {
                    if (cmd[1].equals("aluno")) {
                        alunos.cadastrarAluno(cmd[2]);
                    } else if (alunoLogado != null) {
                        if (cmd[1].equals("laboratorio")) {
                            alunos.cadastraLaboratorio(alunoLogado.getNome(), cmd[2]);
                        } else if (cmd[1].equals("disciplina")) {
                            alunos.cadastraDisciplina(alunoLogado.getNome(), cmd[2]);
                        } else if (cmd[1].equals("cantina")) {
                            alunos.cadastraCantina(alunoLogado.getNome(), cmd[2]);
                        } else {
                            feedback = "    Argumentos incorretos (ajuda cadastro)\n";
                        }
                    } else {
                        feedback = "     Argumentos incorretos (ajuda cadastro)\n";
                    }
                } else if (cmd.length == 4) {
                    if (cmd[1].equals("laboratorio")) {
                        alunos.cadastraLaboratorio(alunoLogado.getNome(), cmd[2], Integer.parseInt(cmd[3]));
                    } else {
                        feedback = "     Argumentos incorretos\n";
                    }
                } else {
                    feedback = "     Argumentos incorretos\n";
                }

            } else if (cmd[0].equals("login") && cmd.length == 2) {
                if (alunos.haAlunosCadastrados()) {
                    if (alunos.temAluno(cmd[1])) {
                        alunoLogado = alunos.getAluno(cmd[1]);
                    } else {
                        feedback = "    Aluno não cadastrado (ajuda)\n";
                    }
                } else {
                    feedback = "    Não há nenhum aluno cadastrado (ajuda)\n";
                }

            } else if (cmd[0].equals("definir") && cmd.length == 4) {
                if (cmd[1].equals("saude")) {
                    if (cmd[2].equals("mental")) {
                        if (cmd[3].equals("boa") || cmd[3].equals("fraca")) {
                            alunos.defineSaudeMental(alunoLogado.getNome(), cmd[3]);
                        } else {
                            feedback = "    Valor incorreto para Saude. = boa ou fraca\n";
                        }

                    } else if (cmd[2].equals("fisica")) {
                        if (cmd[3].equals("boa") || cmd[3].equals("fraca")) {
                            alunos.defineSaudeFisica(alunoLogado.getNome(), cmd[3]);
                        } else {
                            feedback = "    Valor incorreto para Saude. = boa ou fraca\n";
                        }

                    } else if (cmd[2].equals("emoji")) {
                        alunos.defineSaudeEmoji(alunoLogado.getNome(), cmd[3]);

                    } else {
                        feedback = "    Argumentos incorretos\n";
                    }
                }
            } else if (cmd[0].equals("sair")) {
                input.close();
                break menu;

            } else if (cmd[0].equals("ajuda")) {
                feedback = "    Ajuda\n" + "    Você precisa logar para utilizar o sistema.\n"
                        + "    Efetue seu cadastro com:\n" + "        cadastrar aluno *seuNome*\n"
                        + "    Logo depois faça login:\n" + "        login *seuNome*\n"
                        + "    Você pode cadastrar e logar quantas vezes quiser\n";

            } else if (cmd[0].equals("laboratorio")) {
                if (cmd.length == 2) {

                }
            } else if (cmd[0].equals("disciplina")) {

            } else if (cmd[0].equals("cantina")) {

            }
            /*
             * else { feedback = "    Argumentos incorretos\n"; }
             */

            System.out.print(feedback);
            feedback = "";
        }

    }
}
