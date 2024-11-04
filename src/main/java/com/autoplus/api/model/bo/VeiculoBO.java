package com.autoplus.api.model.bo;

import java.sql.SQLException;

import com.autoplus.api.model.dao.VeiculoDAO;
import com.autoplus.api.model.vo.Veiculo;





public class VeiculoBO {

	VeiculoDAO veiculoDAO = null;
	
	public void inserirBO(Veiculo veiculo) throws ClassNotFoundException, SQLException{
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		if(veiculo.getIdPlaca().isEmpty() || veiculo.getIdPlaca().length() > 8) {
			System.out.println("ERROR");
		}else {
			veiculoDAO.inserir(veiculo);
		}
		
	}
	
	public void deletarBO(String id_placa) throws ClassNotFoundException, SQLException{
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		if(id_placa.length() > 8 || id_placa.isEmpty() ) {
			System.out.println("ERROR");
		}
		
		veiculoDAO.deletar(id_placa);
	}
	
	public void atualizarBO(Veiculo veiculo) throws ClassNotFoundException, SQLException{
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		if(veiculo.getIdPlaca().length() > 8) {
			System.out.println("ERROR");
		}
		
		veiculoDAO.atualizar(veiculo);
	}
	
	public Veiculo buscarBO(String id_placa) throws ClassNotFoundException, SQLException{
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();

		return veiculoDAO.buscar(id_placa);
	}
}
