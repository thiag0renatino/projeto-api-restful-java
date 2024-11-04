package com.autoplus.api.model.bo;

import java.sql.SQLException;

import com.autoplus.api.model.dao.ClienteDAO;
import com.autoplus.api.model.vo.Cliente;





public class ClienteBO {

	ClienteDAO clienteDAO = null;
	
	
	public boolean inserirBO(Cliente cliente) throws ClassNotFoundException, SQLException{
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		if(cliente.getCpfClie().isEmpty() || cliente.getCpfClie().length() != 11) {
			System.out.println("ERRO");
			return false;
		}else {
			return clienteDAO.inserir(cliente);
		}
		
	}
	
	public boolean deletarBO(String cpf) throws ClassNotFoundException, SQLException {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		if(cpf.isEmpty() || cpf.length()>11) {
			System.out.println("ERRO");
			return false;
		}else {
			return clienteDAO.deletar(cpf);
		}
		
	}
	
	public void atualizarBO(Cliente cliente) throws ClassNotFoundException, SQLException{
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		clienteDAO.atualizar(cliente);
	}
	
	
	public Cliente buscarBO(String cpf) {
		
		ClienteDAO clienteDAO = new ClienteDAO();	
		
		return clienteDAO.buscar(cpf);
		
	}
	
	
}
