package com.autoplus.api.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Oficina {
	
	private String idCredencial;
	private String nmOfic;
	private String ctOfic;
	private String cepOfic;
	
	public Oficina() {}
	
	public Oficina(String idCredencial, String nmOfic, String ctOfic, String cepOfic) {
		this.idCredencial = idCredencial;
		this.nmOfic = nmOfic;
		this.ctOfic = ctOfic;
		this.cepOfic = cepOfic;
	}

	public String getIdCredencial() {
		return idCredencial;
	}

	public void setIdCredencial(String idCredencial) {
		this.idCredencial = idCredencial;
	}

	public String getNmOfic() {
		return nmOfic;
	}

	public void setNmOfic(String nmOfic) {
		this.nmOfic = nmOfic;
	}

	public String getCtOfic() {
		return ctOfic;
	}

	public void setCtOfic(String ctOfic) {
		this.ctOfic = ctOfic;
	}

	public String getCepOfic() {
		return cepOfic;
	}

	public void setCepOfic(String cepOfic) {
		this.cepOfic = cepOfic;
	}
	
	
	
}

