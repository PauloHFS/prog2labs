package repositorys;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;
import models.Cliente;


/**
 * Repositório de Clientes.
 * 
 * @author Paulo Hernane Fontes e Silva.
 *
 */
public class ClienteRepository {
	/**
	 * Mapa de CPF e seu respectivo Cliente.
	 */
	private Map<String, Cliente> clientes;
	
	/**
	 * Contrói um repositorio de Clientes.
	 */
	public ClienteRepository() {
		this.clientes = new HashMap<String, Cliente>();
	}
	
	//Create
	/**
	 * Cadastra um novo Cliente.
	 * @param cpf CPF do Cliente;
	 * @param nome Nome do Cliente.
	 * @param localizacao Localizacao do Cliente.
	 * @param email Email do Cliente.
	 * @return CPF se o cadastro for bem sucedido.
	 */
	public String cadastraCliente(String cpf, String nome, String localizacao, String email) throws NullPointerException, IllegalArgumentException {	
		if (!this.validaAtributo(cpf)) {
			throw new NullPointerException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		} else if (!this.validaCPF(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido."); 
		} else if (!this.validaAtributo(nome)) {
			throw new NullPointerException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(localizacao)) {
			throw new NullPointerException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		} else if (!this.validaAtributo(email)) {
			throw new NullPointerException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		} else if (this.clientes.containsKey(cpf)) {
				throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		} else {
				this.clientes.put(cpf, new Cliente(cpf, nome, localizacao, email));					
		}
		return cpf;
	}
	
	//Read
	/**
	 * Retorna o Cliente com o CPF desejado.
	 * @param cpf CPF do Cliente.
	 * @return O cliente com o CPF desejado.
	 * @throws IllegalArgumentException Se o cpf for vazio ou nulo.
	 * @throws NullPointerException Se o Cliente não exite.
	 */
	public Cliente getCliente(String cpf) throws IllegalArgumentException, NullPointerException {
		if (!this.validaAtributo(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		} else if (!this.clientes.containsKey(cpf)) {			
			throw new NullPointerException("Erro na exibicao do cliente: cliente nao existe.");
		} else {
			return this.clientes.get(cpf);								
		}
	}
	
	/**
	 * Retorna uma coleção com todos os Clientes.
	 * @return Coleção com todos os Clientes.
	 */
	public Collection<Cliente> getAllClientes() {
		return this.clientes.values();
	}
	
	/**
	 * Verifica se o Cliente está cadastrado no sistema dado seu CPF.
	 * @param cpf CPF do Cliente.
	 * @return true se existir, false se não.
	 */
	public boolean temCliente(String cpf) {
		if (!this.validaCPF(cpf)) {
			throw new IllegalArgumentException("Erro na verificacao da existencia do cliente: cpf nao pode ser vazio ou nulo.");
		} else if (this.clientes.containsKey(cpf)) {
			return true;
		}
		return false;
	}
	
	//Update
	/**
	 * Edita o Cliente com base no seu CPF.
	 * @param cpf CPF do Cliente.
	 * @param atributo Atributo a ser alterado.
	 * @param novoValor Novo Valor do Atributo.
	 * @throws IllegalArgumentException Se, ou cpf, atributo e novoValor forem vazios ou nulo, ou atributo for igual a 'cpf' ou atributo não exite.
	 * @throws NullPointerException Se o Cliente não exite.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) throws IllegalArgumentException, NullPointerException {
		if (!this.validaCPF(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		} else if (!this.clientes.containsKey(cpf)) {
			throw new NullPointerException("Erro na edicao do cliente: cliente nao existe.");
		} else if (!this.validaAtributo(atributo)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(novoValor)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		} else {
			Cliente clienteEditavel = this.clientes.get(cpf);
			switch (atributo) {
			case "cpf":
				throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
			case "nome":
				clienteEditavel.setNome(novoValor);
				break;
			case "localizacao":
				clienteEditavel.setLocalizacao(novoValor);
				break;
			case "email":
				clienteEditavel.setEmail(novoValor);
				break;
			default:
				throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
			}
		}
	}
	
	//Delete
	/**
	 * Remove Cliente com o CPF desejado. 
	 * @param cpf CPF do Cliente a ser removido.
	 * @throws IllegalArgumentException Se o cpf for vazio ou nulo.
	 * @throws NullPointerException Se o Cliente não exite.
	 */
	public void removeCliente(String cpf) throws IllegalArgumentException, NullPointerException {		
		if (!this.validaAtributo(cpf)) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		} else if (!this.clientes.containsKey(cpf)) {
			throw new NullPointerException("Erro na remocao do cliente: cliente nao existe.");
		} else {
			this.clientes.remove(cpf);
		}
	}
	
	//ContaController
	public void adicionaConta(String cpf, String fornecedor, String nome_prod, String data, Double preco) {
		if (!this.validaAtributo(cpf)){
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		}else if (!this.validaCPF(cpf)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		} else if (!this.clientes.containsKey(cpf)) {
			throw new NullPointerException("Erro ao cadastrar compra: cliente nao existe.");
		} 
		this.clientes.get(cpf).adicionaConta(fornecedor, nome_prod, data, preco);
	}
	
	public Double getDebito(String cpf, String fornecedor) {
		if (!this.validaAtributo(cpf)) {
			throw new NullPointerException("Erro ao recuperar debito: cliente nao existe.");
		} else if (!this.validaCPF(cpf)) {
			throw new NullPointerException("Erro ao recuperar debito: cpf invalido.");
		} else if (!this.clientes.containsKey(cpf)) {
			throw new NullPointerException("Erro ao recuperar debito: cliente nao existe.");
		}
		return this.clientes.get(cpf).getDebito(fornecedor);
	}
	
	public String getInfoContaOfFornecedor(String cpf, String fornecedor) {
		return this.clientes.get(cpf).getInfoContaOfFornecedor(fornecedor);
	}
	
	public String getInfoAllContasOfAllFornecedores(String cpf) {
		return this.clientes.get(cpf).getInfoAllContasOfAllFornecedores();
	}
	
	//Auxiliar
	/**
	 * Valida o CPF.
	 * Um CPF valido não é nulo e possui 11 caracteres.
	 * @param cpf CPF a ser validado.
	 * @return true se for Valido, false se não.
	 */
	private boolean validaCPF(String cpf) {
		return cpf != null && cpf.length() == 11; 
	}
	
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
