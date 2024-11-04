package com.autoplus.api.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.autoplus.api.model.dao.oracle_Connection.OracleConnection;
import com.autoplus.api.model.vo.Oficina;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;





public class OficinaDAO {
	
	private Connection conn;
	private OracleConnection instance;
	
	
	public OficinaDAO() {
		
		this.instance = OracleConnection.getInstance();

	}
	
	
	public boolean inserir(Oficina oficina) {
		
		String sql = "INSERT INTO oficina VALUES(?,?,?,?)";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, oficina.getIdCredencial());
			 ps.setString(2, oficina.getNmOfic());
			 ps.setString(3, oficina.getCtOfic());
			 ps.setString(4, oficina.getCepOfic());
			 
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
	
	public boolean deletar(String credencial) {
		
		String sql = "DELETE FROM oficina WHERE id_credencial = ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, credencial);
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
	
	public boolean atualizar(Oficina oficina) {
		
		String sql = "UPDATE oficina SET" +
					 "nm_ofic = ?," + 
					 "ct_ofic = ?," + 
					 "cep_ofic = ?" +
					 "WHERE id_credencial = ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, oficina.getNmOfic());
			ps.setString(2, oficina.getCtOfic());
			ps.setString(3, oficina.getCepOfic());
			ps.setString(4, oficina.getIdCredencial());
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
	
	public List<Oficina> buscar() {
		
		List<Oficina> oficinas = new ArrayList<Oficina>();
		
		String sql = "SELECT * FROM oficina";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				oficinas.add(new Oficina(
						rs.getString("id_credencial"),
						rs.getString("nm_ofic"),
						rs.getString("ct_ofic"),
						rs.getString("cep_ofic")
						));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return oficinas;
	}
}

