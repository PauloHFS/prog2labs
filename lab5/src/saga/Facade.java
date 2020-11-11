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
	 * Adicionar um novo Cliente ao sistema.
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
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.fornecedores.cadastraFornecedor(nome, email, telefone);
	}
	
	public void adicionaProduto(String fornecedor, String nome, String descricao, Double preco) {
		
	}
	
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String desc_prod) {
		
	}
	
	/**
	 * Retorna a informação do Cliente desejado.
	 * @param cpf CPF do Cliente.
	 * @return A representação em String do Cliente.
	 */
	public String exibeCliente(String cpf) {
		return this.clientes.getInfoCliente(cpf);
	}
	
	/**
	 * 
	 * @param nome
	 */
	public String exibeFornecedor(String nome) {
		return this.fornecedores.getInfoFornecedor(nome);
	}
	
	public void exibeProduto(String nome, String descricao, String fornecedor) {
		
	}
	
	public void exibeClientes() {
		
	}
	
	/**
	 * 
	 */
	public void exibeFornecedores() {
		this.fornecedores.getInfoAllFornecedores();
	}
	
	public void exibeProdutosFornecedor(String fornecedor) {
		
	}
	
	public void exibeProdutos() {
		
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
	
	public void editaProduto(String nome, String descricao, String fornecedor, String novoPreco) {
		
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
