package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Produto;
import repositorys.ProdutoRepository;

public class ProdutoController {
	
	private ProdutoRepository produtosRepo;
	
	public ProdutoController() {
		this.produtosRepo = new ProdutoRepository();
	}
	
	//Create
	public void cadastraProduto(String nome, String descricao, Double preco) {
		this.produtosRepo.cadastraProduto(nome, descricao, preco);
	}
	
	//Read
	public String getInfoProduto(String nome, String descricao) {
		return this.produtosRepo.getInfoProduto(nome, descricao);
	}

	public List<Produto> getAllProdutos() {
		List<Produto> produtos = new ArrayList<Produto>(this.produtosRepo.getAllProdutos());
		Collections.sort(produtos);
		return produtos;
	}
	
	//Update
	public void editaProduto(String nome, String descricao, Double novoPreco) {
		this.produtosRepo.editaProduto(nome, descricao, novoPreco);
	}
	
	//Delete
	public void removeProduto(String nome, String descricao) {
		this.produtosRepo.removeProduto(nome, descricao);
	}
}
