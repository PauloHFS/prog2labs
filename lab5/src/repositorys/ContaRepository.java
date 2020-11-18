package repositorys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Conta;

public class ContaRepository {
	
	private Map<String, Conta> contas;
	
	public ContaRepository() {
		this.contas = new HashMap<>();
	}
	
	public void adicionaConta(String fornecedor, String nome_prod, String data, Double preco) {
		if (!this.contas.containsKey(fornecedor)) {
			this.contas.put(fornecedor, new Conta(fornecedor));
		} else if (!this.validaAtributo(data)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		}
		this.contas.get(fornecedor).adicionaCompra(nome_prod, data, preco);
	}
	
	public Double getDebito(String fornecedor) {
		return this.contas.get(fornecedor).getDebito();
	}
	
	public String getInfoContaOfFornecedor(String fornecedor) {
		return this.contas.get(fornecedor).toString();
	}
	
	public String getInfoAllContasOfAllFornecedores() {
		List<Conta> contas = new ArrayList<Conta>(this.contas.values());
		String infoAllContasOfAllFornecedores = "";
		for (int i = 0; i < contas.size(); i++) {
			infoAllContasOfAllFornecedores += contas.get(i).toString();
			if (i != contas.size()-1) {
				infoAllContasOfAllFornecedores += " | ";
			}
		}
		return infoAllContasOfAllFornecedores;
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
