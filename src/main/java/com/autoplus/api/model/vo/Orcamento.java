package com.autoplus.api.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Orcamento {

	private String idOrcamento;
	private double precoOrcamento;
	private String idCredOfic;
	private String status;
	private String servicoId;
	
	public Orcamento() {
		
	}


	public Orcamento(String idOrcamento, double precoOrcamento, String idCredOfic, String status, String servicoId) {
		super();
		this.idOrcamento = idOrcamento;
		this.precoOrcamento = precoOrcamento;
		this.idCredOfic = idCredOfic;
		this.status = status;
		this.servicoId = servicoId;
	}


	public String getIdOrcamento() {
		return idOrcamento;
	}

	public void setIdOrcamento(String idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	public double getPrecoOrcamento() {
		return precoOrcamento;
	}

	public void setPrecoOrcamento(double precoOrcamento) {
		this.precoOrcamento = precoOrcamento;
	}

	public String getIdCredOfic() {
		return idCredOfic;
	}

	public void setIdCredOfic(String idCredOfic) {
		this.idCredOfic = idCredOfic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getServicoId() {
		return servicoId;
	}


	public void setServicoId(String servicoId) {
		this.servicoId = servicoId;
	}

	
	
	
}
