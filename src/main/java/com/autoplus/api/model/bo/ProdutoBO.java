package com.autoplus.api.model.bo;

import java.sql.SQLException;

import com.autoplus.api.model.dao.ProdutoDAO;
import com.autoplus.api.model.vo.Produto;





public class ProdutoBO {

	ProdutoDAO produtoDAO = null;
	
	public void inserirBO(Produto produto) throws ClassNotFoundException, SQLException{
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		if(produto.getIdProduto().isEmpty() || produto.getIdProduto().length() > 5) {
			System.out.println("ERROR");
		}
				
		produtoDAO.inserir(produto);
	}
	
	public void deletarBO(String codigo) throws ClassNotFoundException, SQLException{
		
		ProdutoDAO produtoDAO = new ProdutoDAO();

		if(codigo.isEmpty()) {
			System.out.println("ERROR");
		}
		
		produtoDAO.deletar(codigo);
	}
	
	public void atualizarBO(Produto produto) throws ClassNotFoundException, SQLException{
		
		ProdutoDAO produtoDAO = new ProdutoDAO();

		produtoDAO.atualizar(produto);
	}
	
	public Produto buscarBO(String codigo) throws ClassNotFoundException, SQLException{
		
		ProdutoDAO produtoDAO = new ProdutoDAO();

		if(codigo.isEmpty()) {
			System.out.println("ERROR");
		}
		
		return produtoDAO.buscar(codigo);
	}
}
