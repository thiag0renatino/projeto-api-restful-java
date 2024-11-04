package com.autoplus.api.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.autoplus.api.model.dao.OficinaDAO;
import com.autoplus.api.model.vo.Oficina;





public class OficinaBO {

	OficinaDAO oficinaDAO = null;
	
	public void inserirBO(Oficina oficina) throws ClassNotFoundException, SQLException{
		
		OficinaDAO oficinaDAO = new OficinaDAO();
		
		if(oficina.getIdCredencial().isEmpty()) {
			System.out.println("ERROR");
		}
		
		oficinaDAO.inserir(oficina);
	}
	
	
	public void deletarBO(String credencial) throws ClassNotFoundException, SQLException{
		
		OficinaDAO oficinaDAO = new OficinaDAO();
		
		if(credencial.isEmpty()) {
			System.out.println("ERROR");
		}
		
		oficinaDAO.deletar(credencial);
	}
	
	public void atualizarBO(Oficina oficina) {
		
		OficinaDAO oficinaDAO = new OficinaDAO();

		oficinaDAO.atualizar(oficina);
		
	}
	
	public ArrayList<Oficina> buscarBO() throws ClassNotFoundException, SQLException{
		
		OficinaDAO oficinaDAO = new OficinaDAO();
		
		return(ArrayList<Oficina>) oficinaDAO.buscar();
	}
}
