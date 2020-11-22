package produto;

public class Combo extends Produto {
	
	private double fator;

	public Combo(String nome, String descricao, Double preco, Double fator) {
		super(nome, descricao, preco);
		this.fator = fator;
	}

	public double getFator() {
		return fator;
	}
	
	public void setFator(double fator) {
		this.fator = fator;
	}
}
