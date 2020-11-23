package facade;

public class Facade {
	private ControlerCentral cc;

	public Facade() {
		this.cc = new ControlerCentral();
	}
	
	/**
	 * 
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param localizacao
	 * @return
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.cc.adicionaCliente(cpf, nome, email, localizacao);
	}

	/**
	 * 
	 * @param cpf
	 * @return
	 */
	public String exibeCliente(String cpf) {
		return this.cc.exibeCliente(cpf);
	}

	/**
	 * 
	 * @return
	 */
	public String exibeClientes() {
		return this.cc.exibeClientes();
	}

	/**
	 * 
	 * @param cpf
	 * @param atributo
	 * @param novoValor
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.cc.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * 
	 * @param cpf
	 */
	public void removeCliente(String cpf) {
		this.cc.removeCliente(cpf);
	}

	/**
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 * @return
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.cc.adicionaFornecedor(nome, email, telefone);
	}

	/**
	 * 
	 * @param nome
	 * @return
	 */
	public String exibeFornecedor(String nome) {
		return this.cc.exibeFornecedor(nome);
	}

	/**
	 * 
	 * @return
	 */
	public String exibeFornecedores() {
		return this.cc.exibeFornecedores();
	}

	/**
	 * 
	 * @param nome
	 * @param atributo
	 * @param novoValor
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.cc.editaFornecedor(nome, atributo, novoValor);
	}

	/**
	 * 
	 * @param nome
	 */
	public void removeFornecedor(String nome) {
		this.cc.removeFornecedor(nome);
	}

	/**
	 * 
	 * @param fornecedor
	 * @param nome
	 * @param descricao
	 * @param preco
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		this.cc.adicionaProduto(fornecedor, nome, descricao, preco);
	}

	/**
	 * 
	 * @param fornecedor
	 * @param nome
	 * @param descricao
	 * @return
	 */
	public String exibeProduto(String fornecedor, String nome, String descricao) {
		return this.cc.exibeProduto(fornecedor, nome, descricao);
	}

	/**
	 * 
	 * @param fornecedor
	 * @return
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		return this.cc.exibeProdutosFornecedor(fornecedor);
	}

	/**
	 * 
	 * @return
	 */
	public String exibeProdutos() {
		return this.cc.exibeProdutos();
	}

	/**
	 * 
	 * @param fornecedor
	 * @param nome
	 * @param descricao
	 * @param novoPreco
	 */
	public void editaProduto(String fornecedor, String nome, String descricao, double novoPreco) {
		this.cc.editaProduto(fornecedor, nome, descricao, novoPreco);
	}

	/**
	 * 
	 * @param fornecedor
	 * @param nome
	 * @param descricao
	 */
	public void removeProduto(String fornecedor, String nome, String descricao) {
		this.cc.removeProduto(fornecedor, nome, descricao);
	}

	/**
	 * 
	 * @param cpf
	 * @param fornecedor
	 * @param data
	 * @param nomeProduto
	 * @param descricaoProduto
	 */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProduto,
			String descricaoProduto) {
		this.cc.adicionaCompra(cpf, fornecedor, data, nomeProduto, descricaoProduto);
	}

	/**
	 * 
	 * @param cpf
	 * @param fornecedor
	 * @return
	 */
	public double getDebito(String cpf, String fornecedor) {
		return this.cc.getDebito(cpf, fornecedor);
	}

	/**
	 * 
	 * @param cpf
	 * @param fornecedor
	 * @return
	 */
	public String exibeContas(String cpf, String fornecedor) {
		return this.cc.exibeContas(cpf, fornecedor);
	}

	/**
	 * 
	 * @param cpf
	 * @return
	 */
	public String exibeContasClientes(String cpf) {
		return this.cc.exibeContasClientes(cpf);
	}

	/**
	 * 
	 * @param criterio
	 */
	public void ordenaPor(String criterio) {
		this.cc.ordenaPor(criterio);
	}

	/**
	 * 
	 * @return
	 */
	public String listarCompras() {
		return this.cc.listarCompras();
	}
	
	/**
	 * Cadastra um Combo com os produtos de um determinado Fornecedor
	 * O Combo também é um produto do fornecedor, mas não pode fazer parte de um outro combo.
	 * @param fornecedor Nome do Fornecedor.
	 * @param nome Nome do Combo.
	 * @param descricao Descrição do Combo.
	 * @param fator Fator de desconto do Combo.
	 * @param produtos Produtos que pertencem ao Combo.
	 */
	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		this.cc.adicionaCombo(fornecedor, nome, descricao, fator, produtos);	
	}
	
	/**
	 * Altera o Fator de desconto do Combo.
	 * @param nomeCombo Nome do Combo.
	 * @param descricao Descrição do Combo.
	 * @param fornecedor Nome do Fornecedor.
	 * @param novoFator Novo Fator de Desconto.
	 */
	public void editaCombo(String nomeCombo, String descricao, String fornecedor, double novoFator) {
		this.cc.editaCombo(nomeCombo, descricao, fornecedor, novoFator);
	}
}
