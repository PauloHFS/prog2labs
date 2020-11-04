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
	 * Conjunto dos Clientes.
	 */
	private Map<Integer, Cliente> clientes;
	
	/**
	 * Contrói um repositorio de Clientes.
	 */
	public ClienteRepository() {
		this.clientes = new HashMap<Integer, Cliente>();
	}
	
	/**
	 * Cadastra um novo Cliente.
	 * @param cpf CPF do Cliente;
	 * @param nome Nome do Cliente.
	 * @param localDeTrabalho Local de Trabalho do Cliente.
	 * @param email Email do Cliente.
	 * @return CPF se o cadastro for bem sucedido.
	 */
	public int cadastrarCliente(int cpf, String nome, String localDeTrabalho, String email) {
		try {
			this.clientes.put(cpf, new Cliente(cpf, nome, localDeTrabalho, email));	
		} catch (Exception e) {
			System.err.println(e);
		}
		return cpf;
	}
	
	/**
	 * Retorna o Cliente com o CPF desejado.
	 * @param cpf CPF do Cliente.
	 * @return O cliente com o CPF desejado.
	 */
	public Cliente getCliente(int cpf) {
		return this.clientes.get(cpf);
	}
	
	/**
	 * Retorna uma coleção com todos os Clientes.
	 * @return Coleção com todos os Clientes.
	 */
	public Collection<Cliente> getAllClientes() {
		return this.clientes.values();
	}
	
	/**
	 * Remove Cliente com o CPF desejado. 
	 * @param cpf CPF do Cliente a ser removido.
	 */
	public void removeCliente(int cpf) {
		this.clientes.remove(cpf);
	}
}
