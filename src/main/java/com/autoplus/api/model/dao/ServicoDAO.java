package com.autoplus.api.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.autoplus.api.model.dao.oracle_Connection.OracleConnection;
import com.autoplus.api.model.vo.Servico;




public class ServicoDAO {
	
	private Connection conn;
	private OracleConnection instance;
	
	public ServicoDAO() {
		
		this.instance = OracleConnection.getInstance();

		
	}
	
	
	public boolean inserir(Servico servico) {
		
		String sql = "INSERT INTO servico VALUES(?, ?, ?, ?, ?, ?)";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, servico.getIdServico());
			ps.setString(2, servico.getNtFiscal());
			ps.setDouble(3, servico.getValorServico());
			ps.setString(4, servico.getTipoServico());
			ps.setString(5, servico.getProblema());
			ps.setString(6, servico.getOficina());
			
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
	
	
	public boolean deletar(String id_servico) {
		
		String sql = "DELETE FROM servico WHERE id_servico = ?";
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id_servico);
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
	
	public boolean atualizar(Servico servico) {
		
		String sql = "UPDATE servico SET nt_fiscal = ?,valor_servico = ?, tipo_servico = ? WHERE id_servico = ?";
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, servico.getNtFiscal());
			ps.setDouble(2, servico.getValorServico());
			ps.setString(3, servico.getTipoServico());
			ps.setString(4, servico.getIdServico());
			
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
	
	public Servico buscar(String id_servico) {
		
		String sql = "SELECT * FROM servico WHERE id_servico = ?";
		
		Servico servicoP = new Servico();
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, id_servico);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			servicoP.setIdServico(rs.getString("id_servico"));
			servicoP.setNtFiscal(rs.getString("nt_fiscal"));
			servicoP.setValorServico(rs.getDouble("valor_servico"));
			servicoP.setTipoServico(rs.getString("tipo_servico"));
			servicoP.setProblema(rs.getString("fk_problema_id_probl"));
			servicoP.setOficina(rs.getString("fk_oficina_id_credencial"));
			
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
		return servicoP;
	}
	
	
	
	
	
}
