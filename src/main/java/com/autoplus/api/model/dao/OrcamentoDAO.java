package com.autoplus.api.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.autoplus.api.model.dao.oracle_Connection.OracleConnection;
import com.autoplus.api.model.vo.Orcamento;





public class OrcamentoDAO {

	private OracleConnection instance;
	
	private Connection conn;
	
	public OrcamentoDAO() {
		
		this.instance = OracleConnection.getInstance();

	}

	
	public boolean inserir(Orcamento orcamento) {
		
		String sql = "INSERT INTO orcamento VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, orcamento.getIdOrcamento());
			ps.setDouble(2, orcamento.getPrecoOrcamento());
			ps.setString(3, orcamento.getIdCredOfic());
			ps.setString(4, orcamento.getStatus());
			ps.setString(5, orcamento.getServicoId());
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	
	
	public boolean deletar(String id_orcamento) {
		
		String sql = "DELETE FROM orcamento WHERE id_orcamento = ?";
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id_orcamento);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public boolean atualizar(Orcamento orcamento) {
		
		String sql = "UPDATE orcamento SET preco_orcamento = ?,"
				+ " id_cred_ofic = ?, status = ?, fk_servico_id = ? WHERE id_orcamento = ?";
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, orcamento.getPrecoOrcamento());
			ps.setString(2, orcamento.getIdCredOfic());
			ps.setString(3, orcamento.getStatus());
			ps.setString(4, orcamento.getServicoId());
			ps.setString(5, orcamento.getIdOrcamento());
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
		
	}
	
	public Orcamento buscar(String id_orcamento) {
		
		String sql = "SELECT * FROM orcamento WHERE id_orcamento = ?";
		
		Orcamento orcamentoP = new Orcamento();
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id_orcamento);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			orcamentoP.setIdOrcamento(rs.getString("id_orcamento"));
			orcamentoP.setPrecoOrcamento(rs.getDouble("preco_orcamento"));
			orcamentoP.setIdCredOfic(rs.getString("id_cred_ofic"));
			orcamentoP.setStatus(rs.getString("status"));
			orcamentoP.setServicoId(rs.getString("fk_servico_id"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return orcamentoP;
	}
	
	
	
	
	
	
	
	
	
}
