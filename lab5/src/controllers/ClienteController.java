package controllers;

import repositorys.ClienteRepository;
import models.Cliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		List<Cliente> clientes = new ArrayList<Cliente>(this.clientes.getAllClientes());
		Collections.sort(clientes);
		for (int i = 0; i < clientes.size(); i++) {
			infoAllClientes += clientes.get(i).toString();
			if (i != clientes.size()-1) {
				infoAllClientes += " | ";
			}
		}
		return infoAllClientes;
	}
	
	/**
	 * Verifica se um Cliente esta cadastrado no Sistema dado um CPF.
	 * @param cpf CPF do Cliente.
	 * @return true se existir, false se não.
	 */
	public boolean temCliente(String cpf) { 
		return this.clientes.temCliente(cpf);
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

	public void adicionaConta(String cpf, String fornecedor, String nome_prod, String data, Double preco) {
		this.clientes.adicionaConta(cpf, fornecedor, nome_prod, data, preco);
	}
	
	public Double getDebito(String cpf, String fornecedor) {
		return this.clientes.getDebito(cpf, fornecedor);
	}
	
	public String getInfoContaOfFornecedor(String cpf, String fornecedor) {
		return this.clientes.getInfoContaOfFornecedor(cpf, fornecedor);
	}
	
	public String getInfoAllContasOfAllFornecedores(String cpf) {
		return this.clientes.getInfoAllContasOfAllFornecedores(cpf);
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
