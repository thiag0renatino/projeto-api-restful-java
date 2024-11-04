package com.autoplus.api.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.autoplus.api.model.dao.oracle_Connection.OracleConnection;
import com.autoplus.api.model.vo.Veiculo;

import java.sql.PreparedStatement;



public class VeiculoDAO {
	//Atributos
	
	private OracleConnection instance;
	
	private Connection conn;
	
	//Construtor
	
	public VeiculoDAO() {
		
		this.instance = OracleConnection.getInstance();

		
	}
	
	
	//Métodos
	
	public boolean inserir(Veiculo veiculo) {
		
		String sql = "INSERT INTO veiculo VALUES (?,?,?,?,?)";
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, veiculo.getIdPlaca());
			ps.setString(2, veiculo.getVeicMarca());
			ps.setString(3, veiculo.getVeicModelo());
			ps.setInt(4, veiculo.getAnoVeic());
			ps.setString(5, veiculo.getCpfClie());

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
	
	public boolean deletar(String placa) {
		
		String sql = "DELETE FROM veiculo WHERE id_placa = ?";
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, placa);
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
	
	public boolean atualizar(Veiculo veiculo) {
		
		String sql = "UPDATE veiculo "
				+ "SET marca_veic = ?, modelo_veic = ?, ano_veic = ? "
				+ "WHERE id_placa = ?";
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, veiculo.getVeicMarca());	
			ps.setString(2, veiculo.getVeicModelo());	
			ps.setInt(3, veiculo.getAnoVeic());	
			ps.setString(4, veiculo.getIdPlaca());
			

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
	
	public Veiculo buscar(String placa) {
		
		String sql = "SELECT * FROM veiculo WHERE id_placa = ?";
		
		Veiculo VeiculoP = new Veiculo();
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, placa);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			VeiculoP.setIdPlaca(rs.getString("id_placa"));
			VeiculoP.setVeicMarca(rs.getString("marca_veic"));
			VeiculoP.setVeicModelo(rs.getString("modelo_veic"));
			VeiculoP.setAnoVeic(rs.getInt("ano_veic"));
			VeiculoP.setCpfClie(rs.getString("fk_cliente_cpf"));
			
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
		
		return VeiculoP;

	}

}
