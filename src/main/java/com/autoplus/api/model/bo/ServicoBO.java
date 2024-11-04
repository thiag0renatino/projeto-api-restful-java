package com.autoplus.api.model.bo;

import java.sql.SQLException;

import com.autoplus.api.model.dao.ServicoDAO;
import com.autoplus.api.model.vo.Servico;





public class ServicoBO {

	ServicoDAO servicoDAO = null;
	
	public void inserirBO(Servico servico) throws ClassNotFoundException, SQLException{
		
		ServicoDAO servicoDAO = new ServicoDAO();
		
		if(servico.getIdServico().isEmpty()) {
			System.out.println("ERROR");
		}
		
		servicoDAO.inserir(servico);
	}
	
	public void deletarBO(String id_servico) throws ClassNotFoundException, SQLException{
		
		ServicoDAO servicoDAO = new ServicoDAO();

		if(id_servico.isEmpty()) {
			System.out.println("ERROR");
		}
		
		servicoDAO.deletar(id_servico);
	}
	
	public void atualizarBO(Servico servico) throws ClassNotFoundException, SQLException{
		
		ServicoDAO servicoDAO = new ServicoDAO();

		servicoDAO.atualizar(servico);
		
	}
	
	public Servico buscarBO(String id_servico) throws ClassNotFoundException, SQLException{
		
		ServicoDAO servicoDAO = new ServicoDAO();
		
		return servicoDAO.buscar(id_servico);

	}
}
