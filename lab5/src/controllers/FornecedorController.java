package controllers;

import java.util.Collection;

import models.Fornecedor;
import repositorys.FornecedorRepository;

/**
 * Controller de Fornecedor.
 * @author Paulo Hernane Fontes e Silva
 *
 */
public class FornecedorController {

	/**
	 * Repositório dos Fornecedores.
	 * @see repositorys.FornecedorRepository
	 */
	private FornecedorRepository fornecedores;
	
	/**
	 * Constrói um Controller de Fornecedor.
	 */
	public FornecedorController() {
		this.fornecedores = new FornecedorRepository();
	}
	
	//Create
	/**
	 * Cadastra um novo Fornecedor no Sistema.
	 * @param nome Nome do Fornecedor.
	 * @param email Email do Fornecedor.
	 * @param telefone Telefone do Fornecedor.
	 * @return Nome do Fornecedor cadastrado.
	 * @see repositorys.FornecedorRepository#cadastraFornecedor(String, String, String)
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {
		return this.fornecedores.cadastraFornecedor(nome, email, telefone);
	}
	
	//Read
	/**
	 * Retirba as informações de Fornecedor com o nome desejado.
	 * @param nome Nome do Fornecedor.
	 * @return A representação em String do Fornecedor.
	 * @see repositorys.FornecedorRepository#getFornecedor(String)
	 * @see models.Fornecedor#toString()
	 */
	public String getInfoFornecedor(String nome) {
		return this.fornecedores.getFornecedor(nome).toString();
	}
	
	public String getInfoAllFornecedores() {
		String infoAllFornecedores = "";
		Collection<Fornecedor> fornecedores = this.fornecedores.getAllFornecedores();
		for (Fornecedor fornecedor : fornecedores) {
			infoAllFornecedores += fornecedor.toString() + " | ";
 		}
		return infoAllFornecedores;
	}
	//Update
	/**
	 * Aktera algum atributo do Fornecedor com o Nome passado por parametro.
	 * @param nome Nome do Fornecedor
	 * @param atributo Atributo que deseja ser alterado.
	 * @param novoValor Novo valor para o atributo.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.fornecedores.editaFornecedor(nome, atributo, novoValor);
	}
	
	//Detele
	/**
	 * Remove o Fornecedor do Sistema.
	 * @param nome Nome do Fornecedor.
	 */
	public void removeFornecedor(String nome) {
		this.fornecedores.removeFornecedor(nome);
	}
}
