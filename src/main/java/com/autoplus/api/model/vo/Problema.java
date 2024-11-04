package com.autoplus.api.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Problema {
	
	private String idProbl;
	private String problDesc;
	private String problTp;
	private String problSoluc;
	private String veiculo;
	
	public Problema() {
		
	}

	public Problema(String idProbl, String problDesc, String problTp, String problSoluc, String veiculo) {
		super();
		this.idProbl = idProbl;
		this.problDesc = problDesc;
		this.problTp = problTp;
		this.problSoluc = problSoluc;
		this.veiculo = veiculo;
	}

	public String getIdProbl() {
		return idProbl;
	}

	public void setIdProbl(String idProbl) {
		this.idProbl = idProbl;
	}

	public String getProblDesc() {
		return problDesc;
	}

	public void setProblDesc(String problDesc) {
		this.problDesc = problDesc;
	}

	public String getProblTp() {
		return problTp;
	}

	public void setProblTp(String problTp) {
		this.problTp = problTp;
	}

	public String getProblSoluc() {
		return problSoluc;
	}

	public void setProblSoluc(String problSoluc) {
		this.problSoluc = problSoluc;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	


	
	
	
	
}
