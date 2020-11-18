package saga;

import controllers.ClienteController;
import controllers.FornecedorController;
import easyaccept.EasyAccept;

/**
 * Facade do Sistema para Auto-Gestão de comércio de Alimentos - SAGA.
 * @author Paulo Hernane Fontes e Silva
 *
 */
public class Facade {
	
	/**
	 * Controller de Cliente.
	 */
	private ClienteController clientes;
	
	/**
	 * Controller de Fornecedor.
	 */
	private FornecedorController fornecedores;
	
	/**
	 * Constrói a Facade do sistema.
	 */
	public Facade() {
		this.clientes = new ClienteController();
		this.fornecedores = new FornecedorController();
	}
	
	/**
	 * Adiciona um novo Cliente ao sistema.
	 * @param cpf CPF do Cliente.
	 * @param nome Nome do Cliente.
	 * @param email Email do Cliente.
	 * @param localizacao Localização do Cliente.
	 * @return CPF do Cliente.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.clientes.cadastraCliente(cpf, nome, localizacao, email);
	}
	
	/**
	 * Adiciona um novo Fornecedor ao sistema.
	 * @param nome Nome do Fornecedor.
	 * @param email Email do Fornecedor.
	 * @param telefone Telefone do Fornecedor.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.fornecedores.cadastraFornecedor(nome, email, telefone);
	}
	
	/**
	 * Adiciona um novo Produto ao um Fornecedor no sistema.
	 * @param fornecedor Nome do fornecedor.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @param preco Preço do Produto.
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, Double preco) {
		this.fornecedores.cadastraProduto(fornecedor, nome, descricao, preco);
	}
	
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String desc_prod) {
		if (!this.validaAtributo(fornecedor)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		} else if (!this.fornecedores.temFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		} else if (!this.validaAtributo(nome_prod)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(desc_prod)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		} else if (!this.fornecedores.temProduto(fornecedor, nome_prod, desc_prod)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
		}
		this.clientes.adicionaConta(cpf, fornecedor, nome_prod, data, this.fornecedores.getPrecoProduto(fornecedor, nome_prod, desc_prod));
	}
	
	/**
	 * Retorna as informações do Cliente desejado.
	 * @param cpf CPF do Cliente.
	 * @return A representação em String do Cliente.
	 */
	public String exibeCliente(String cpf) {
		return this.clientes.getInfoCliente(cpf);
	}
	
	/**
	 * Retorna as informações do Fornecedor desejado.
	 * @param nome Nome do Fornecedor.
	 * @return A representação em String do Fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		return this.fornecedores.getInfoFornecedor(nome);
	}
	
	/**
	 * Exibe a representação em String do Produto cadastrado em um determinado Fornecedor.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @param fornecedor Fornecedor que possui o Produto.
	 * @return A representação em String do Produto.
	 */
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return this.fornecedores.getInfoProduto(fornecedor, nome, descricao);
	}
	
	/**
	 * Exibe a representação em String de todos os Clientes cadastrados no sistema.
	 * @return A representação em String.
	 */
	public String exibeClientes() {
		return this.clientes.getInfoAllClientes();
	}
	
	/**
	 * Retorna as informações de todos os Fornecedores cadastrados no sistema.
	 * @return A representação em String de todos os Fornecedores.
	 */
	public String exibeFornecedores() {
		return this.fornecedores.getInfoAllFornecedores();
	}
	
	/**
	 * Exibe a representação em String dos produtos de um determinado Fornecedor.
	 * @param fornecedor Nome do Fornecedor.
	 * @return A representação em String dos produtos.
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		return this.fornecedores.getAllProdutos(fornecedor);
	}
	
	/**
	 * Retorna a representação em String de todos os Produtos do sistema.
	 * @return A presentação em String de todos os Produtos.
	 */
	public String exibeProdutos() {
		return this.fornecedores.getInfoAllProdutosOfAllFornecedores();
	}
	
	public String exibeContas(String cpf, String fornecedor) {
		return this.clientes.getInfoContaOfFornecedor(cpf, fornecedor);
	}
	
	public String exibeContasClientes(String cpf) {
		return this.clientes.getInfoAllContasOfAllFornecedores(cpf);
	}
	
	public Double getDebito(String cpf, String fornecedor) {
		if (!this.validaAtributo(fornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(cpf)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		} else if (!this.fornecedores.temFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		}
		return this.clientes.getDebito(cpf, fornecedor);
	}
	
	/**
	 * Edita Cliente com base no CPF.
	 * @param cpf CPF do Cliente.
	 * @param atributo Atributo a ser editado.
	 * @param novoValor Novo Valor do Atributo.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.clientes.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * Altera um determinado atributo de um Fornecedor.
	 * @param nome Nome do Fornecedor.
	 * @param atributo Atributo a ser alterado.
	 * @param novoValor Novo valor do atributo.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.fornecedores.editaFornecedor(nome, atributo, novoValor);
	}
	
	/**
	 * Altera o preço de um produto cadastrado em um Fornecedor.
	 * @param nome Nome do produto.
	 * @param descricao Descrição do produto.
	 * @param fornecedor Nome do Fornecedor.
	 * @param novoPreco Novo Preço do Produto.
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, Double novoPreco) {
		this.fornecedores.editaProduto(fornecedor, nome, descricao, novoPreco);
	}
	
	/**
	 * Remove um cliente com base no CPF do sistema.
	 * @param cpf CPF do Cliente.
	 */
	public void removeCliente(String cpf) {
		this.clientes.removeCliente(cpf);
	}
	
	/**
	 * Remove um fornecedor do sistema.
	 * @param nome Nome do Fornecedor.
	 */
	public void removeFornecedor(String nome) {
		this.fornecedores.removeFornecedor(nome);
	}
	
	/**
	 * Remove um produto do sistema.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @param fornecedor Nome do Fornecedor.
	 */
	public void removeProduto(String nome, String descricao, String fornecedor) {
		this.fornecedores.removeProduto(fornecedor, nome, descricao);
	}
	
	public void listarCompras() {
		
	}
	
	public void ordenarPor(String criterio) {
		
	}
	
	public static void main(String[] args) {
		args = new String[] {
				"saga.Facade", 
				"acceptance_test/use_case_1.txt", 
				"acceptance_test/use_case_2.txt",
				"acceptance_test/use_case_3.txt",
				"acceptance_test/use_case_4.txt",
				"acceptance_test/use_case_5.txt",
				"acceptance_test/use_case_6.txt"};
		EasyAccept.main(args);
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
