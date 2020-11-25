package lab4;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import models.Aluno;
import repositorys.GrupoRepository;

/**
 * 
 * @author paulo
 *
 */
public class Main {
	
	
	public static void main(String[] args) {
		HashMap<Integer, Aluno> alunosSemGrupo = new HashMap<Integer, Aluno>();
		ArrayList<String> alunosQueResponderam = new ArrayList<String>();
		
		GrupoRepository grupos = new GrupoRepository();
		
		Scanner input = new Scanner(System.in);
		
		String escolha = "";
		
		while (true) {
			escolha = menuPrincipal(input);
			try {
				comando(escolha, input, alunosSemGrupo, alunosQueResponderam, grupos);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	private static String menuPrincipal(Scanner input) {
		System.out.print(
				"\n\n(C)adastrar Aluno\n" + 
				"(E)xibir Aluno\n" + 
				"(N)ovo Grupo\n" + 
				"(A)locar Aluno no Grupo e Imprimir Grupos\n" + 
				"(R)egistrar Aluno que Respondeu\n" + 
				"(I)mprimir Alunos que Responderam\n" + 
				"(O)ra, vamos fechar o programa!\n" + 
				"\n" + 
				"Opção> ");
		return input.nextLine().toUpperCase();
	}
	
	private static void comando(String opcao, Scanner input, HashMap<Integer, Aluno> alunosSemGrupo, ArrayList<String> alunosQueResponderam, GrupoRepository grupos) {
		switch (opcao) {
		case "C":
			cadastrarAluno(input, alunosSemGrupo);
			break;
		case "E":
			consultarAluno(input, alunosSemGrupo);
			break;
		case "N":
			cadastrarGrupo(input, grupos);
			break;
		case "A":
			System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
			String escolha = input.nextLine().toUpperCase();
			switch (escolha) {
			case "A":
				alocarAluno(input, alunosSemGrupo, grupos);
				break;
			case "I":
				imprimirGrupo(input, grupos);
				break;
			}
			break;
		case "R":
			cadastrarAlunosResponderam(input, alunosSemGrupo, alunosQueResponderam);
			break;
		case "I":
			imprimirAlunosResponderam(alunosQueResponderam);
			break;
		case "O":
			sair();
			break;
		}
	}
	
	private static void cadastrarAluno(Scanner input, HashMap<Integer, Aluno> alunosSemGrupo) {
		System.out.print("\nMatrícula: ");
		int matricula = Integer.parseInt(input.nextLine());
		System.out.print("Nome: ");
		String nomeAluno = input.nextLine();
		System.out.print("Curso: ");
		String curso = input.nextLine();
		
		if (alunosSemGrupo.containsKey(matricula)) {
			System.out.println("\nMATRÍCULA JÁ CADASTRADA!");
		} else {
			alunosSemGrupo.put(matricula, new Aluno(nomeAluno, curso));
			System.out.println("\nCADASTRO REALIZADO!");
		}
	}
	
	private static void consultarAluno(Scanner input, HashMap<Integer, Aluno> alunosSemGrupo) {
		System.out.print("\nMatrícula: ");
		int matricula = Integer.parseInt(input.nextLine());
		
		if (alunosSemGrupo.containsKey(matricula)) {
			Aluno alunoConsultado = alunosSemGrupo.get(matricula);
			System.out.println("\nAluno: " + matricula + " - " + alunoConsultado.toString());
		} else {
			System.out.println("\nAluno não cadastrado.");			
		}
		
	}
	
	private static void cadastrarGrupo(Scanner input, GrupoRepository grupos) {
		System.out.print("\nGrupo: ");
		String nomeGrupo = input.nextLine();
		
		grupos.cadastrarGrupo(nomeGrupo);		
	}
	
	private static void alocarAluno(Scanner input, HashMap<Integer, Aluno> alunosSemGrupo, GrupoRepository grupos) {
		System.out.print("Matricula: ");
		int matricula = Integer.parseInt(input.nextLine());
		System.out.print("Grupo: ");
		String nomeGrupo = input.nextLine();
		grupos.alocarAluno(nomeGrupo, matricula, alunosSemGrupo.get(matricula));
	}
	
	private static void imprimirGrupo(Scanner input, GrupoRepository grupos) {
		System.out.print("\nGrupo: ");
		String nomeGrupo = input.nextLine();
		
		System.out.println("\n" + grupos.grupoToString(nomeGrupo));
	}
	
	private static void cadastrarAlunosResponderam(Scanner input, HashMap<Integer, Aluno> alunosSemGrupo, ArrayList<String> alunosQueResponderam) {
		System.out.print("Matricula: ");
		int matricula = Integer.parseInt(input.nextLine());
		if (alunosSemGrupo.containsKey(matricula)) {
			alunosQueResponderam.add(matricula + " - " + alunosSemGrupo.get(matricula).toString());	
			System.out.println("\nALUNO REGISTRADO!");
		}
	}
	
	private static void imprimirAlunosResponderam(ArrayList<String> alunosQueResponderam) {
		int i = 1;
		String lista = "Alunos:\n";
		for (String aluno : alunosQueResponderam) {
			lista += i + ". " + aluno + "\n";
			i += 1;
		}
		System.out.println(lista);
	}
	
	private static void sair() {
		System.exit(0);
	}
}
