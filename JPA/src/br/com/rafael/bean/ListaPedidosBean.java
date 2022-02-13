package br.com.rafael.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.rafael.ejb.PedidoBean;
import br.com.rafael.model.Pedido;

@Named
@RequestScoped
public class ListaPedidosBean implements Serializable {

	@EJB
	private PedidoBean pedido;
	
	private List<Pedido> pedidos;

	@PostConstruct
	public void init() {
		this.pedidos = this.pedido.listar();
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public String pagar(Integer id, String tipoPagamento) {
		this.pedido.pagar(id, tipoPagamento);
		return "pedidos?faces-redirect=true";
	}
	
	public String excluir(Integer id) {
		this.pedido.excluir(id);
		return "pedidos?faces-redirect=true";
	}

}
