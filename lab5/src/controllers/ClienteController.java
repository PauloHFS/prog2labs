package controllers;

import repositorys.ClienteRepository;
import models.Cliente;
import java.util.Collection;

/**
 * Controller de Cliente.
 * @author Paulo Hernane Fontes e Silva
 *
 */
public class ClienteController {

	/**
	 * Repositório dos Clientes.
	 * @see repositorys.ClienteRepository
	 */
	private ClienteRepository clientes;
	
	/**
	 * Constrói um Controller de Cliente.
	 */
	public ClienteController() {
		this.clientes = new ClienteRepository();
	}
	
	//Create
	/**
	 * Cadastra um novo Cliente no Sistema.
	 * @param cpf CPF do Cliente.
	 * @param nome Nome do Cliente.
	 * @param localizacao Localização do Cliente.
	 * @param email Email do Cliente.
	 * @return CPF do Cliente cadastrado.
	 * @see repositorys.ClienteRepository#cadastraCliente(int, String, String, String)
	 */
	public String cadastraCliente(String cpf, String nome, String localizacao, String email) {
		return this.clientes.cadastraCliente(cpf, nome, localizacao, email);
	}
	
	//Read
	/**
	 * Retorna as informações do Cliente com o CPF desejado.
	 * @param cpf CPF do Cliente buscado.
	 * @return A representação em String do Cliente.
	 * @see repositorys.ClienteRepository#getCliente(String)
	 * @see models.Cliente#toString()
	 */
	public String getInfoCliente(String cpf) {
		return this.clientes.getCliente(cpf).toString();
	}
	
	/**
	 * Retorna as informações de todos os Clientes cadastrados no sistema.
	 * @return Todas as representações em String dos Clientes separados por '|'.
	 */
	public String getInfoAllClientes() {
		String infoAllClientes = "";
		Collection<Cliente> clientes = this.clientes.getAllClientes();
		for (Cliente cliente : clientes) {
			infoAllClientes += cliente.toString() + " | ";
		}
		return infoAllClientes;
	}
	
	//Update
	/**
	 * Altera algum atributo do Cliente com o CPF passado por parametro.
	 * @param cpf CPF do Cliente a ser alterado
	 * @param atributo Atributo que deseja ser alterado.
	 * @param novoValor Novo valor para o atributo.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.clientes.editaCliente(cpf, atributo, novoValor);
	}

	//Delete
	/**
	 * Remove o Cliente do Sistema.
	 * @param cpf CPF do Cliente a ser removido.
	 */
	public void removeCliente(String cpf) {
		this.clientes.removeCliente(cpf);
	}
}
