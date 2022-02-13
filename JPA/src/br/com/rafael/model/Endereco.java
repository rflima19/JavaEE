//package br.com.rafael.model;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//@Entity
//@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
//public class Endereco implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@EmbeddedId
//	private EnderecoPK id;
//
//	private String complemento;
//
//	private Integer numero;
//
//	//bi-directional many-to-one association to Cliente
//	@ManyToOne
//	private Cliente cliente;
//
//	public Endereco() {
//	}
//
//	public EnderecoPK getId() {
//		return this.id;
//	}
//
//	public void setId(EnderecoPK id) {
//		this.id = id;
//	}
//
//	public String getComplemento() {
//		return this.complemento;
//	}
//
//	public void setComplemento(String complemento) {
//		this.complemento = complemento;
//	}
//
//	public Integer getNumero() {
//		return this.numero;
//	}
//
//	public void setNumero(Integer numero) {
//		this.numero = numero;
//	}
//
//	public Cliente getCliente() {
//		return this.cliente;
//	}
//
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}
//
//}