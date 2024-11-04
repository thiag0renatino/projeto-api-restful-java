package com.autoplus.api.model.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import com.autoplus.api.model.dao.oracle_Connection.OracleConnection;
import com.autoplus.api.model.vo.Cliente;

import java.sql.PreparedStatement;



public class ClienteDAO {
	
	private Connection conn;
	private OracleConnection instance;
	
	
	public ClienteDAO() {
		
		this.instance = OracleConnection.getInstance();
	}
	
	
	public boolean inserir(Cliente cliente) {
		
		String sql = "INSERT INTO cliente VALUES (?,?,?,?,?)";
		
		//Abertura da connection
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getCpfClie());
			ps.setString(2, cliente.getCtClie());
			ps.setString(4, cliente.getNmClie());
			ps.setString(3, cliente.getCepClie());
			ps.setString(5, cliente.getSenhaClie());
			
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
	
	public boolean deletar(String cpf)  {
		
		String sql = "DELETE FROM cliente WHERE cpf_clie = ?";
		
		//Abertura da connection
		conn = instance.getConnection();
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cpf);
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
	
	public boolean atualizar(Cliente cliente) {
		
		String sql = "UPDATE cliente " +
					 "SET nm_clie = ?, ct_clie = ?, cep_clie = ?" +
					 "WHERE cpf_clie = ?";
		
		conn = instance.getConnection();
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getNmClie());
			ps.setString(2, cliente.getCtClie());
			ps.setString(3, cliente.getCepClie());
			ps.setString(4, cliente.getCpfClie());
			
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
	
	public Cliente buscar(String cpf_clie) {
		
		String sql = "SELECT * FROM cliente WHERE cpf_clie = ?";
		
		PreparedStatement ps;
		
		conn = instance.getConnection();
		
		Cliente clienteP = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, cpf_clie);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			clienteP = new Cliente();
			
			clienteP.setCpfClie(rs.getString("cpf_clie"));
			clienteP.setCtClie(rs.getString("ct_clie"));
			clienteP.setCepClie(rs.getString("cep_clie"));
			clienteP.setNmClie(rs.getString("nm_clie"));
			clienteP.setSenhaClie(rs.getString("senha_clie"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return clienteP;

	}
}

