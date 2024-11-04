package com.autoplus.api.model.bo;

import java.sql.SQLException;

import com.autoplus.api.model.dao.OrcamentoDAO;
import com.autoplus.api.model.vo.Orcamento;




public class OrcamentoBO {

	OrcamentoDAO orcamentoDAO = null;
	
	public void inserirBO(Orcamento orcamento) throws ClassNotFoundException, SQLException{
		
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		
		if(orcamento.getIdOrcamento().isEmpty()) {
			System.out.println("ERROR");
		}
	
		
		orcamentoDAO.inserir(orcamento);
		
	}
	
	public void deletarBO(String id_orcamento) throws ClassNotFoundException, SQLException{
		
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		
		if(id_orcamento.isEmpty()) {
			System.out.println("ERROR");
		}
		
		orcamentoDAO.deletar(id_orcamento);
	}
	
	public void atualizarBO(Orcamento orcamento) throws ClassNotFoundException, SQLException{
		
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		
		orcamentoDAO.atualizar(orcamento);
	}
	
	public Orcamento buscarBO(String id_orcamento) throws ClassNotFoundException, SQLException{
		
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		
		return orcamentoDAO.buscar(id_orcamento);
	}
	
	
}
