package br.com.rafael.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue
	@Column(name = "pedido_id", nullable = false)
	private Integer id;

	@Column(name = "valor_total")
	private Double valorTotal;

	@Temporal(TemporalType.DATE)
	@Column(name = "data", nullable = false)
	private Date data;

	@OneToOne
	@JoinColumn(name = "pagamento_id")
	private Pagamento pagamento;

	@ManyToOne
	@JoinColumn(name = "cliente2_id")
	private Cliente2 cliente;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "pedido_produto", 
		joinColumns = @JoinColumn(name = "pedido_id"), 
		inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produto> produtos;

	public Pedido() {
		super();
		this.produtos = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date date) {
		this.data = date;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente2 getCliente() {
		return cliente;
	}

	public void setCliente(Cliente2 cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
