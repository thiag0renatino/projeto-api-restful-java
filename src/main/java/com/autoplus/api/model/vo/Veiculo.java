package com.autoplus.api.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Veiculo {

	private String idPlaca;
	private String veicMarca;
	private String veicModelo;
	private int anoVeic;
	private String cpfClie;
	
	public Veiculo() {
		
	}
	
	public Veiculo(String idPlaca, String veicMarca, String veicModelo, int anoVeic, String cpfClie) {
		this.idPlaca = idPlaca;
		this.veicMarca = veicMarca;
		this.veicModelo = veicModelo;
		this.anoVeic = anoVeic;
		this.cpfClie = cpfClie;
	}

	public String getIdPlaca() {
		return idPlaca;
	}

	public void setIdPlaca(String idPlaca) {
		this.idPlaca = idPlaca;
	}

	public String getVeicMarca() {
		return veicMarca;
	}

	public void setVeicMarca(String veicMarca) {
		this.veicMarca = veicMarca;
	}

	public String getVeicModelo() {
		return veicModelo;
	}

	public void setVeicModelo(String veicModelo) {
		this.veicModelo = veicModelo;
	}

	public int getAnoVeic() {
		return anoVeic;
	}

	public void setAnoVeic(int anoVeic) {
		this.anoVeic = anoVeic;
	}

	
	public String getCpfClie() {
		return cpfClie;
	}

	public void setCpfClie(String cpfClie) {
		this.cpfClie = cpfClie;
	}

	
}
