package br.ufcg.coisa.cli;

import java.util.Scanner;

import br.ufcg.coisa.repositorios.AlunoRepositorio;

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
        String feedback = "", funcao = "", aluno = "", nomeEntidade = "", nomeAluno = "";
        AlunoRepositorio alunos = new AlunoRepositorio();
        menu: while (true) {
            System.out.print(">");
            cmd = input.nextLine().split(" ");
            if (cmd.length >= 3) {
                funcao = cmd[0];
                aluno = cmd[1];
                if (!aluno.equals("disciplina") && !aluno.equals("laboratorio") && !aluno.equals("cantina")) {

                    if (funcao.equals("cadastrar")) {
                        if (alunos.getAluno(cmd[1]) != null) {
                            nomeEntidade = cmd[2];
                            if (nomeEntidade.equals("laboratorio")) {
                                if (cmd.length == 4) {
                                    String nomeLaboratorio = cmd[3];
                                    alunos.cadastraLaboratorio(aluno, nomeLaboratorio);
                                } else if (cmd.length == 5) {
                                    String nomeLaboratorio = cmd[3];
                                    int cota = Integer.parseInt(cmd[4]);
                                    alunos.cadastraLaboratorio(aluno, nomeLaboratorio, cota);
                                } else {
                                    feedback += "Argumento invalido!\n";
                                }
                            } else if (nomeEntidade.equals("disciplina")) {
                                if (cmd.length == 4) {
                                    String nomeDisciplina = cmd[3];
                                    alunos.cadastraDisciplina(aluno, nomeDisciplina);
                                } else {
                                    feedback += "Argumento invalido!\n";
                                }
                            } else if (nomeEntidade.equals("cantina")) {
                                if (cmd.length == 4) {
                                    String nomeCantina = cmd[3];
                                    alunos.cadastraDisciplina(aluno, nomeCantina);
                                } else {
                                    feedback += "Argumento invalido!\n";
                                }
                            } else {
                                feedback += "Argumento invalido!\n";
                            }
                        } else if (cmd[1].equals("aluno")) {
                            nomeAluno = cmd[2];
                            alunos.cadastrarAluno(nomeAluno);
                            feedback += nomeAluno + " foi cadastrado com sucesso.\n";
                        } else {
                            feedback += "Argumento invalido!\n";
                        }
                    } else if (funcao.equals("laboratorio")) {
                        String labFuncao, nomeLaboratorio = cmd[3];
                        if (cmd.length == 4) {
                            labFuncao = cmd[3];
                            if (labFuncao.equals("status")) {
                                alunos.laboratorioToString(aluno, nomeLaboratorio);
                            } else if (labFuncao.equals("atingiuCota")) {
                                alunos.atingiuCota(aluno, nomeLaboratorio);
                            } else {
                                feedback += "Argumento invalido!\n";
                            }
                        } else if (cmd.length == 5) {
                            labFuncao = cmd[3];
                            int espaco = Integer.parseInt(cmd[4]);
                            if (labFuncao.equals("consomeEspaco")) {
                                alunos.consomeEspaco(aluno, nomeLaboratorio, espaco);
                            } else if (labFuncao.equals("liberaEspaco")) {
                                alunos.liberaEspaco(aluno, nomeLaboratorio, espaco);
                            } else {
                                feedback += "Argumento invalido!\n";
                            }
                        } else {
                            feedback += "Argumento invalido!\n";
                        }
                    } else if (funcao.equals("disciplina")) {
                        String discFunc = cmd[3], nomeDisciplina = cmd[2];
                        if (cmd.length == 4) {
                            if (discFunc.equals("status")) {
                                alunos.disciplinaToString(aluno, nomeDisciplina);
                            } else if (discFunc.equals("aprovado")) {
                                alunos.aprovado(aluno, nomeDisciplina);
                            } else {
                                feedback += "Argumento invalido!\n";
                            }
                        } else if (cmd.length == 5) {
                            int horas = Integer.parseInt(cmd[4]);
                            if (discFunc.equals("cadastrarHoras")) {
                                alunos.cadastraHoras(aluno, nomeDisciplina, horas);
                            } else {
                                feedback += "Argumento invalido!\n";
                            }
                        } else if (cmd.length == 6) {
                            int nota = Integer.parseInt(cmd[4]), valorNota = Integer.parseInt(cmd[5]);
                            if (discFunc.equals("cadastrarNota")) {
                                alunos.cadastraNota(aluno, nomeDisciplina, nota, valorNota);
                            } else {
                                feedback += "Argumento invalido!\n";
                            }
                        }
                    } else if (funcao.equals("cantina")) {
                        String nomeCantina = cmd[2], cantinaFunc = cmd[3];
                        if (cmd.length == 4) {
                            if (cantinaFunc.equals("status")) {
                                alunos.cadastraCantina(aluno, nomeCantina);
                            } else if (cantinaFunc.equals("faltaPagar")) {
                                alunos.getFaltaPagar(aluno, nomeCantina);
                            } else {
                                feedback += "Argumento invalido!\n";
                            }
                        } else if (cmd.length == 5) {
                            int valor = Integer.parseInt(cmd[4]);
                            if (cantinaFunc.equals("pagarConta")) {
                                alunos.pagarConta(aluno, nomeCantina, valor);
                            } else {
                                feedback += "Argumento invalido!\n";
                            }
                        } else if (cmd.length == 6) {
                            int quantItens = Integer.parseInt(cmd[4]), valor = Integer.parseInt(cmd[5]);
                            if (cantinaFunc.equals("lanche")) {
                                alunos.cadastraLanche(aluno, nomeCantina, quantItens, valor);
                            } else {
                                feedback += "Argumento invalido!\n";
                            }
                        }
                    } else if (funcao.equals("saude")) {
                        String saudeFunc = cmd[2];
                        if (saudeFunc.equals("status")) {
                            alunos.getStatusGeral(nomeAluno);
                        } else if (cmd.length == 4) {
                            String saudeValue = cmd[3];
                            if (saudeFunc.equals("defineSaudeMental")) {
                                alunos.defineSaudeMental(aluno, saudeValue);
                            } else if (saudeFunc.equals("defineSaudeFisica")) {
                                alunos.defineSaudeFisica(aluno, saudeValue);
                            } else if (saudeFunc.equals("defineSaudeEmoji")) {
                                alunos.defineSaudeEmoji(aluno, saudeValue);
                            } else {
                                feedback += "Argumento invalido!\n";
                            }
                        } else {
                            feedback += "Argumento invalido!\n";
                        }
                    } else {
                        feedback += "Argumento invalido!\n";
                    }
                }
            } else if (cmd.length == 1) {
                if (funcao.equals("sair")) {
                    input.close();
                    break menu;
                }
            }
            System.out.print(feedback);
            feedback = "";
        }
    }
}
