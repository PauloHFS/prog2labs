package controllers;

import repositorys.ContaRepository;

/**
 * Controller de Conta.
 * @author pauloh
 *
 */
public class ContaController {
	
	/**
	 * Repositorio de Contas.
	 */
	private ContaRepository contas;
	
	/**
	 * 
	 */
	public ContaController() {
		this.contas = new ContaRepository();
	}

	public void adicionaConta(String fornecedor, String nome_prod, String data, Double preco) {
		this.contas.adicionaConta(fornecedor, nome_prod, data, preco);
	}
	
	public Double getDebito(String fornecedor) {
		return this.contas.getDebito(fornecedor);	
	}
	
	public String getInfoContaOfFornecedor(String fornecedor) {
		return this.contas.getInfoContaOfFornecedor(fornecedor);
	}
	
	public String getInfoAllContasOfAllFornecedores() {
		return this.contas.getInfoAllContasOfAllFornecedores();
	}
}
