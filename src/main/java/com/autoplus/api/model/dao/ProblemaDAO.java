package com.autoplus.api.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.autoplus.api.model.dao.oracle_Connection.OracleConnection;
import com.autoplus.api.model.vo.Problema;





public class ProblemaDAO {
	
	//Atributos
	
	private OracleConnection instance;
		
	private Connection conn;
	
	public ProblemaDAO() {
		
		this.instance = OracleConnection.getInstance();

		
	}

	
	
	public boolean inserir(Problema problema) {
		
		String sql = "INSERT INTO problema VALUES(? ,?, ?, ?, ?)";
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, problema.getIdProbl());
			ps.setString(2, problema.getProblDesc());
			ps.setString(3, problema.getProblTp());
			ps.setString(4, problema.getProblSoluc());
			ps.setString(5, problema.getVeiculo());
			
			ps.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	
	public boolean deletar(String id_probl) {
		
		String sql = "DELETE FROM problema WHERE id_probl = ?";
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id_probl);
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	
	public boolean atualizar(Problema problema) {
		
		String sql = "UPDATE problema SET probl_desc = ?, probl_tp = ?, probl_soluc = ?"
				+ "WHERE id_probl = ?";
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, problema.getProblDesc());
			ps.setString(2, problema.getProblTp());
			ps.setString(3, problema.getProblSoluc());
			ps.setString(4, problema.getIdProbl());
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public Problema buscar(String id_probl) {
		
		String sql = "SELECT * FROM problema WHERE id_probl = ?";
		
		Problema problemaP = new Problema();
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id_probl);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			problemaP.setIdProbl(rs.getString("id_probl"));
			problemaP.setProblDesc(rs.getString("probl_desc"));
			problemaP.setProblTp(rs.getString("probl_tp"));
			problemaP.setProblSoluc(rs.getString("probl_soluc"));
			problemaP.setVeiculo(rs.getString("fk_veiculo_id_placa"));
			
			
			
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
		return problemaP;
	}
	

}
