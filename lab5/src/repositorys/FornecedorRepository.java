package repositorys;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import models.Fornecedor;

public class FornecedorRepository {
	
	/**
	 * Mapa de Nome e seu respectivo Fornecedor. 
	 */
	private Map<String, Fornecedor> fornecedores;
	
	/**
	 * Constrói um repositorio de Fornecedor.
	 */
	public FornecedorRepository() {
		this.fornecedores = new HashMap<String, Fornecedor>();
	}
	
	//Create
	/**
	 * Cadastra um novo Fornecedor.
	 * @param nome Nome do Fornecedor.
	 * @param email Email do Fornecedor.
	 * @param telefone Telefone do Fornecedor.
	 * @return Nome do Fornecedor se o cadastro for bem sucedido.
	 * @throws IllegalArgumentException
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) throws IllegalArgumentException {
		if (!this.validaAtributo(nome)) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(email)) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(telefone)) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		} else if (this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		} else {
			this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));		
		}
		return nome;
	}
	
	//Read
	/**
	 * Retorna o Fornecedor com o Nome expecificado.
	 * @param nome Nome do Forncedor desejado.
	 * @return Fornecedor que possui o nome passado por parametro.
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	public Fornecedor getFornecedor(String nome) throws IllegalArgumentException, NullPointerException {
		if (this.fornecedores.containsKey(nome)) {			
			return this.fornecedores.get(nome);
		} else {
			throw new NullPointerException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
	}
	
	/**
	 * Retorna uma coleção com todos os Fornecedores.
	 * @return Coleção com todos os Fornecedores.
	 */
	public Collection<Fornecedor> getAllFornecedores() {
		return this.fornecedores.values();
	}
	
	//Update
	public void editaFornecedor(String nome, String atributo, String novoValor) throws IllegalArgumentException {
		if (!this.validaAtributo(nome)) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		} else if (!this.fornecedores.containsKey(nome)) {
			throw new NullPointerException("Erro na edicao do fornecedor: fornecedor nao existe.");
		} else if (!this.validaAtributo(atributo)) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(novoValor)) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		} else {
			Fornecedor fornecedorEditavel = this.fornecedores.get(nome);
			switch (atributo) {
			case "nome":
				throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
			case "email":
				fornecedorEditavel.setEmail(novoValor);
				break;
			case "telefone":
				fornecedorEditavel.setTelefone(novoValor);
				break;
			default:
				throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
			}
		}
	}
	
	//Delete
	public void removeFornecedor(String nome) {
		if (!this.validaAtributo(nome)) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		} else if (!this.fornecedores.containsKey(nome)) {
			throw new NullPointerException("Erro na remocao do fornecedor: fornecedor nao existe.");
		} else {
			this.fornecedores.remove(nome);		
		}
	}

	//Auxiliar
	/**
	 * Valida o um Atributo.
	 * Um Atributo é valido se não for nulo ou vazio.
	 * @param atributo Atributo a ser validado.
	 * @return true se for valido, false se não.
	 */
	private boolean validaAtributo(String atributo) {
		return !(atributo == null || atributo.isBlank() || atributo.isEmpty());
	}
}
