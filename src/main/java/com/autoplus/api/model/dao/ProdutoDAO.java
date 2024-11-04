package com.autoplus.api.model.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import com.autoplus.api.model.dao.oracle_Connection.OracleConnection;
import com.autoplus.api.model.vo.Produto;

import java.sql.PreparedStatement;



public class ProdutoDAO {
	
	private Connection conn;
	private OracleConnection instance;
	
	public ProdutoDAO() {
		
		this.instance = OracleConnection.getInstance();

	}
	
	
	public boolean inserir(Produto produto) {
		
		String sql = "INSERT INTO produto ("
				+ "id_produto,"
				+ "produto_tp,"
				+ "produto_nm,"
				+ "produto_desc"
				+ ") VALUES (?,?,?,?)";
		
		//Abertura da connection
		conn = instance.getConnection();
				
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, produto.getIdProduto());
			ps.setString(2, produto.getTpProduto());
			ps.setString(3, produto.getNmProduto());
			ps.setString(4, produto.getDescProduto());
			ps.execute(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
				
	}
	
	public boolean deletar(String codigo) {
		
		String sql = "DELETE FROM produto WHERE id_produto = ?";
		
		//Abertura da connection
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, codigo);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
		
	}
	
	public boolean atualizar(Produto produto) {
		
	String sql = "UPDATE produto " +
				 "SET produto_tp = ?, produto_nm = ?, produto_desc = ?" +
				 "WHERE id_produto = ?";
	
	conn = instance.getConnection();
	
	PreparedStatement ps;
	
	try {
		ps = conn.prepareStatement(sql);
		ps.setString(1, produto.getTpProduto());
		ps.setString(2, produto.getNmProduto());
		ps.setString(3, produto.getDescProduto());
		ps.setString(4, produto.getIdProduto());
		
		ps.execute();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	} finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	return true;
		
	}
	
	public Produto buscar(String idProduto) {
		
		String sql = "SELECT * FROM produto WHERE id_produto = ?";
		
		//Abertura da connection
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		Produto produto = new Produto();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProduto);
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			produto.setIdProduto(rs.getString("id_produto"));
			produto.setTpProduto(rs.getString("produto_tp"));
			produto.setNmProduto(rs.getString("produto_nm"));
			produto.setDescProduto(rs.getString("produto_desc"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return produto;
		
	}
	
}
