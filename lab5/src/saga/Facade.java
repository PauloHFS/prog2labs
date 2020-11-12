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
	
	public void adicionaProduto(String fornecedor, String nome, String descricao, Double preco) {
		this.fornecedores.cadastrarProduto(fornecedor, nome, descricao, preco);
	}
	
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String desc_prod) {
		
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
	
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return this.fornecedores.exibeProduto(nome, descricao, fornecedor);
	}
	
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
	
	public String exibeProdutosFornecedor(String fornecedor) {
		return this.fornecedores.exibeProdutosFornecedor(fornecedor);
	}
	
	public String exibeProdutos() {
		return this.fornecedores.exibeProdutos();
	}
	
	public void exibeContas(String cpf, String fornecedor) {
		
	}
	
	public void exibeContasClientes(String cpf) {
		
	}
	
	public void getDebito(String cpf, String fornecedor) {
		
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
	 * 
	 * @param nome
	 * @param atributo
	 * @param novoValor
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.fornecedores.editaFornecedor(nome, atributo, novoValor);
	}
	
	public void editaProduto(String nome, String descricao, String fornecedor, Double novoPreco) {
		this.fornecedores.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	/**
	 * Remove um cliente com base no CPF do sistema.
	 * @param cpf CPF do Cliente.
	 */
	public void removeCliente(String cpf) {
		this.clientes.removeCliente(cpf);
	}
	
	public void removeFornecedor(String nome) {
		this.fornecedores.removeFornecedor(nome);
	}
	
	public void removeProduto(String nome, String descricao, String fornecedor) {
		this.fornecedores.removeProduto(nome, descricao, fornecedor);
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
}
