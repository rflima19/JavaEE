package br.com.rafael.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "pagamento_id", nullable = false)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pagto", length = 20, nullable = false)
	private TipoPagamento tipoPagto;

	@OneToOne(mappedBy = "pagamento")
	private Pedido pedido;

	public Pagamento() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoPagamento getTipoPagto() {
		return tipoPagto;
	}

	public void setTipoPagto(TipoPagamento tipoPagto) {
		this.tipoPagto = tipoPagto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
