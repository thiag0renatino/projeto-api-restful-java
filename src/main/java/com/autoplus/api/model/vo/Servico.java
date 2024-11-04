package com.autoplus.api.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Servico {

	private String idServico;
	private String ntFiscal;
	private double valorServico;
	private String tipoServico;
	private String problema;
	private String oficina;
	
	public Servico() {
		
	}

	public Servico(String idServico, String ntFiscal, double valorServico, String tipoServico, String problema,
			String oficina) {
		super();
		this.idServico = idServico;
		this.ntFiscal = ntFiscal;
		this.valorServico = valorServico;
		this.tipoServico = tipoServico;
		this.problema = problema;
		this.oficina = oficina;
	}

	public String getIdServico() {
		return idServico;
	}

	public void setIdServico(String idServico) {
		this.idServico = idServico;
	}

	public String getNtFiscal() {
		return ntFiscal;
	}

	public void setNtFiscal(String ntFiscal) {
		this.ntFiscal = ntFiscal;
	}

	public double getValorServico() {
		return valorServico;
	}

	public void setValorServico(double valorServico) {
		this.valorServico = valorServico;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	
	
	
	
	
	
}
