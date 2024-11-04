package com.autoplus.api.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente {
	
	private String cpfClie;
	private String ctClie;
	private String nmClie;
	private String cepClie;
	private String senhaClie;
	
	public Cliente() {}
	
	public Cliente(String cpfClie, String ctClie, String cepClie,String nmClie, String senhaClie) {
		
		this.cpfClie = cpfClie;
		this.ctClie = ctClie;
		this.nmClie = nmClie;
		this.cepClie = cepClie;
		this.senhaClie = senhaClie;
	}



	public String getCpfClie() {
		return cpfClie;
	}



	public void setCpfClie(String cpfClie) {
		this.cpfClie = cpfClie;
	}



	public String getCtClie() {
		return ctClie;
	}



	public void setCtClie(String ctClie) {
		this.ctClie = ctClie;
	}



	public String getNmClie() {
		return nmClie;
	}



	public void setNmClie(String nmClie) {
		this.nmClie = nmClie;
	}



	public String getCepClie() {
		return cepClie;
	}



	public void setCepClie(String cepClie) {
		this.cepClie = cepClie;
	}



	public String getSenhaClie() {
		return senhaClie;
	}



	public void setSenhaClie(String senhaClie) {
		this.senhaClie = senhaClie;
	}



	




	
	
	
	
}
