package repositorys;

import java.util.HashMap;
import models.Grupo;
import models.Aluno;

/**
 * Repositório de Grupos
 * @author paulo
 *
 */
public class GrupoRepository {
	
	/**
	 * Mapa de (Nome do Grupo*)/Grupo.
	 * * em HashCode.
	 */
	private HashMap<Integer, Grupo> grupos;
	
	/**
	 * Constrói um novo Repositório.
	 */
	public GrupoRepository() {
		this.grupos = new HashMap<Integer, Grupo>();
	}
	
	/**
	 * Cadastra um novo grupo no Repositório.
	 * @param nome Nome do Grupo.
	 */
	public void cadastrarGrupo(String nome) {
		if (nome == null) {
			throw new NullPointerException("Nome não pode ser nulo.");
		} else {
			if (this.grupos.containsKey(nome.toUpperCase().hashCode())) {
				System.out.println("GRUPO JÁ CADASTRADO!");
			} else {
				this.grupos.put(nome.toUpperCase().hashCode(), new Grupo(nome));
				System.out.println("CADASTRO REALIZADO!");
			}			
		}
	}
	
	/**
	 * Aloca um Aluno no grupo desejado.
	 * @param nomeGrupo Nome do Grupo a receber o aluno.
	 * @param matricula Matricula do Aluno a ser alocado.
	 * @param alunoAlocado Aluno a ser alocado.
	 */
	public void alocarAluno(String nomeGrupo, int matricula, Aluno alunoAlocado) {
		if (nomeGrupo == null) {
			throw new NullPointerException("Nome do Grupo não pode ser nulo.");
		} else if (alunoAlocado == null) {
			throw new NullPointerException("Aluno não pode ser nulo.");
		} else {
			if (this.grupos.containsKey(nomeGrupo.toUpperCase().hashCode())) {
				this.grupos.get(nomeGrupo.toUpperCase().hashCode()).alocarAluno(matricula, alunoAlocado);
				System.out.println("ALUNO ALOCADO!");
			} else {
				System.out.println("Grupo não cadastrado.");
			}			
		}
	}
	
	/**
	 * Retorna a representação em String de um grupo desejado.
	 * @param nomeGrupo Nome do Grupo desejado.
	 * @return a representação em String do grupo.
	 */
	public String grupoToString(String nomeGrupo) {
		if (nomeGrupo == null) {
			throw new NullPointerException("Nome do Grupo não pode ser nulo.");
		}
		return this.grupos.get(nomeGrupo.toUpperCase().hashCode()).toString();			
		
	}
}
