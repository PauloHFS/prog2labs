package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	
	public void cadastrarProduto(String fornecedor, String nome, String descricao, Double preco) {
		this.fornecedores.cadastraProduto(fornecedor, nome, descricao, preco);
	}
	
	//Read
	/**
	 * Retorna as informações de Fornecedor com o nome desejado.
	 * @param nome Nome do Fornecedor.
	 * @return A representação em String do Fornecedor.
	 * @see repositorys.FornecedorRepository#getFornecedor(String)
	 * @see models.Fornecedor#toString()
	 */
	public String getInfoFornecedor(String nome) {
		return this.fornecedores.getFornecedor(nome).toString();
	}
	
	/**
	 * Retorna as informações de todos os Fornecedores cadastrados.
	 * @return A representação em String de todos os fornecedores.
	 */
	public String getInfoAllFornecedores() {
		String infoAllFornecedores = "";
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>(this.fornecedores.getAllFornecedores());
		Collections.sort(fornecedores);
		for (int i = 0; i < fornecedores.size(); i++) {
			infoAllFornecedores += fornecedores.get(i);
			if (i != fornecedores.size()-1) {
				infoAllFornecedores += " | ";
			}
		}
		return infoAllFornecedores;
	}
	
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return this.fornecedores.getInfoProduto(nome, descricao, fornecedor);
	}
	
	public String exibeProdutosFornecedor(String fornecedor) {
		return this.fornecedores.getAllInfoProduto(fornecedor);
	}
	
	public String exibeProdutos() {
		return this.fornecedores.getAllInfoProdutosAllFornecedores();
	}
	
	//Update
	/**
	 * Altera algum atributo do Fornecedor com o Nome passado por parametro.
	 * @param nome Nome do Fornecedor
	 * @param atributo Atributo que deseja ser alterado.
	 * @param novoValor Novo valor para o atributo.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.fornecedores.editaFornecedor(nome, atributo, novoValor);
	}
	
	public void editaProduto(String nome, String descricao, String fornecedor, Double novoPreco) {
		this.fornecedores.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	//Detele
	/**
	 * Remove o Fornecedor do Sistema.
	 * @param nome Nome do Fornecedor.
	 */
	public void removeFornecedor(String nome) {
		this.fornecedores.removeFornecedor(nome);
	}
	
	public void removeProduto(String nome, String descricao, String fornecedor) {
		this.fornecedores.removeProduto(nome, descricao, fornecedor);
	}
}
