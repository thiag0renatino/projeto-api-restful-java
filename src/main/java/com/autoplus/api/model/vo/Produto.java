package com.autoplus.api.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produto {

	private String idProduto;
	private String tpProduto;
	private String nmProduto;
	private String descProduto;
	
	public Produto() {}

	public Produto(String idProduto, String tpProduto, String nmProduto, String descProduto) {
		this.idProduto = idProduto;
		this.tpProduto = tpProduto;
		this.nmProduto = nmProduto;
		this.descProduto = descProduto;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getTpProduto() {
		return tpProduto;
	}

	public void setTpProduto(String tpProduto) {
		this.tpProduto = tpProduto;
	}

	public String getNmProduto() {
		return nmProduto;
	}

	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}

	
}
