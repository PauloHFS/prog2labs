package models;

import java.util.ArrayList;
import java.util.List;

public class Conta {

	private String fornecedor;
	
	private List<String> compras;
	
	private Double debito;
	
	public Conta(String fornecedor) {
		this.fornecedor = fornecedor;
		this.compras = new ArrayList<String>();
		this.debito = 0.0;
	}
	
	public void adicionaCompra(String nome_prod, String data, Double preco) {
		this.compras.add(nome_prod + " - " + data.replace("/", "-"));
		this.debito += preco;
	}
	
	public Double getDebito() {
		return debito;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true; 
		}
		
		if (!(obj instanceof Conta)) {
			return false;
		}
		
		Conta other = (Conta) obj;
		
		return this.fornecedor.equals(other.fornecedor);
	}
	
	@Override
	public int hashCode() {
		return this.fornecedor.hashCode();
	}
	
	@Override
	public String toString() {
		String contaString = this.fornecedor + " | ";
		for (int i = 0; i < this.compras.size(); i++) {
			contaString += this.compras.get(i);
			if (i != this.compras.size()-1) {
				contaString += " | ";
			}
		}
		return contaString;
	}
}
