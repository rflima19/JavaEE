package br.com.rafael.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafael.ejb.ClienteBean;
import br.com.rafael.ejb.PedidoBean;
import br.com.rafael.ejb.ProdutoBean;
import br.com.rafael.model.Cliente2;
import br.com.rafael.model.Produto;

@Named
@RequestScoped
public class EditPedidoBean implements Serializable {

	@EJB
	private PedidoBean pedido;
	
	@EJB
	private ClienteBean cliente;
	
	@EJB
	private ProdutoBean produto;
	
	private Integer selectedClienteId;

	private List<Cliente2> clientes;

	private Integer[] selectedProdutoId;

	private List<Produto> produtos;
	
	public EditPedidoBean() {
		super();
	}
	
	@PostConstruct
	public void init() {
		this.clientes = this.cliente.listar();
		this.produtos = this.produto.listar();
	}

	public Integer getSelectedClienteId() {
		return selectedClienteId;
	}

	public void setSelectedClienteId(Integer selectedClienteId) {
		this.selectedClienteId = selectedClienteId;
	}

	public List<Cliente2> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente2> clientes) {
		this.clientes = clientes;
	}

	public Integer[] getSelectedProdutoId() {
		return selectedProdutoId;
	}

	public void setSelectedProdutoId(Integer[] selectedProdutoId) {
		this.selectedProdutoId = selectedProdutoId;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public String cadastrarPedido() throws Exception {
		this.pedido.cadastrar(this.selectedClienteId, this.selectedProdutoId);
		return "pedidos?faces-redirect=true";
	}

}
