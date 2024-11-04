package com.autoplus.api.model.bo;

import java.sql.SQLException;

import com.autoplus.api.model.dao.ProblemaDAO;
import com.autoplus.api.model.vo.Problema;





public class ProblemaBO {

	ProblemaDAO problemaDAO = null;
	
	public void inserirBO(Problema problema) throws ClassNotFoundException, SQLException{
		
		ProblemaDAO problemaDAO = new ProblemaDAO();
		
		if(problema.getIdProbl().isEmpty() || problema.getIdProbl().length() > 5) {
			System.out.println("ERROR");
		}
		
		problemaDAO.inserir(problema);
	}
	
	public void deletarBO(String id_probl) throws ClassNotFoundException, SQLException{
		
		ProblemaDAO problemaDAO = new ProblemaDAO();
		
		if(id_probl.isEmpty()) {
			System.out.println("ERROR");
		}
		
		problemaDAO.deletar(id_probl);
	}
	
	public void atualizarBO(Problema problema) throws ClassNotFoundException, SQLException{
		
		ProblemaDAO problemaDAO = new ProblemaDAO();

		problemaDAO.atualizar(problema);
	}
	
	public Problema buscarBO(String id_probl) throws ClassNotFoundException, SQLException{
		
		ProblemaDAO problemaDAO = new ProblemaDAO();
		
		return problemaDAO.buscar(id_probl);

	}
}
