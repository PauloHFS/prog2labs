package repositorys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.Fornecedor;

/**
 * Repositório de Fornecedores.
 * @author Paulo Hernane Fontes e Silva
 *
 */
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
	
	/**
	 * Verifica se um Fornecedor está cadastrado no Sistema dado um nome.
	 * @param nome Nome do Fornecedor.
	 * @return true se existir, false se não.
	 */
	public boolean temFornecedor(String nome) {
		if (!this.validaAtributo(nome)) {
			throw new IllegalArgumentException("Erro na verificacao de existencia de Fornecedor: nome não pode ser vazio ou nulo.");
		} else if (this.fornecedores.containsKey(nome)) {
			return true;
		}
		return false;
	}
	
	//Update
	/**
	 * Edita um atributo de um Fornecedor.
	 * @param nome Nome do Fornecedor;
	 * @param atributo Atributo do Fornecedor.
	 * @param novoValor Novo valor para o atributo.
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) throws IllegalArgumentException, NullPointerException {
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
	/**
	 * Remove um Fornecedor do sistema.
	 * @param nome Nome do Fornecedor a ser removido.
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	public void removeFornecedor(String nome) throws IllegalArgumentException, NullPointerException {
		if (!this.validaAtributo(nome)) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		} else if (!this.fornecedores.containsKey(nome)) {
			throw new NullPointerException("Erro na remocao do fornecedor: fornecedor nao existe.");
		} else {
			this.fornecedores.remove(nome);		
		}
	}
	
	//ProdutoController
	/**
	 * Cadastra um novo Produto ao sistema.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @param preco Preço do Produto.
	 */
	public void cadastraProduto(String fornecedor, String nome, String descricao, Double preco) {
		if (!this.validaAtributo(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		} else if (!this.fornecedores.containsKey(fornecedor)) {
			throw new NullPointerException("Erro no cadastro de produto: fornecedor nao existe.");
		} else {
			this.fornecedores.get(fornecedor).cadastraProduto(nome, descricao, preco);
		}
	}
	
	/**
	 * Retorna as Informações do Produto.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @return A representação em String do Produto.
	 */
	public String getInfoProduto(String fornecedor, String nome, String descricao) {
		if (!this.validaAtributo(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(nome)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(descricao)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		} else if (!this.fornecedores.containsKey(fornecedor)) {
			throw new NullPointerException("Erro na exibicao de produto: fornecedor nao existe.");
		} else {
			return this.fornecedores.get(fornecedor).getInfoProduto(nome, descricao);
		}
	}
	
	/**
	 * Retorna uma lista ordenada de todos os Produtos cadastrados.
	 * @return Lista com os Produtos cadastrados.
	 */
	public String getAllProdutos(String fornecedor) {
		if (!this.validaAtributo(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (!this.fornecedores.containsKey(fornecedor)) {
			throw new NullPointerException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		return this.fornecedores.get(fornecedor).getInfoAllProdutos();
	}
	
	/**
	 * Retorna todas as informações de todos os Produtos de todos os Fornecedores.
	 * @return A representação em String de todos os produtos de todos os fornecedores.
	 */
	public String getInfoAllProdutosOfAllFornecedores() {
		String infoAllProdutosOfAllFornecedores = "";
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>(this.fornecedores.values());
		Collections.sort(fornecedores);
		for (int i = 0; i < fornecedores.size(); i++) {
			infoAllProdutosOfAllFornecedores += fornecedores.get(i).getInfoAllProdutos();
			if (i != fornecedores.size()-1) {
				infoAllProdutosOfAllFornecedores += " | ";
			}	
		}
		return infoAllProdutosOfAllFornecedores;
	}
	
	/**
	 * Verifica se exite um Produto no Sistema com dado Nome e Descricao.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @return true se existir, false se não.
	 */
	public boolean temProduto(String fornecedor, String nome, String descricao) {
		return this.fornecedores.get(fornecedor).temProduto(nome, descricao);
	}
	
	/**
	 * Altera o preço de um Produto.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @param novoPreco Novo Preço do Produto.
	 */
	public void editaProduto(String fornecedor, String nome, String descricao, Double novoPreco) {
		if (!this.validaAtributo(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(nome)) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(descricao)) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		} else if (!this.fornecedores.containsKey(fornecedor)) {
			throw new NullPointerException("Erro na edicao de produto: fornecedor nao existe.");
		} else {
			this.fornecedores.get(fornecedor).editaProduto(nome, descricao, novoPreco);
		}
	}
	
	/**
	 * Remove um produto do Sistema.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 */
	public void removeProduto(String fornecedor, String nome, String descricao) {
		if (!this.validaAtributo(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(nome)) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		} else if (!this.fornecedores.containsKey(fornecedor)) {
			throw new NullPointerException("Erro na remocao de produto: fornecedor nao existe.");
		} else {
			this.fornecedores.get(fornecedor).removeProduto(nome, descricao);
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
