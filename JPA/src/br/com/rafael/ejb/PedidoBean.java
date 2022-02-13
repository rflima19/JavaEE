package br.com.rafael.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafael.model.Cliente2;
import br.com.rafael.model.Pagamento;
import br.com.rafael.model.Pedido;
import br.com.rafael.model.Produto;
import br.com.rafael.model.TipoPagamento;

@Stateless
public class PedidoBean {

	@PersistenceContext
	private EntityManager em;

	public List<Pedido> listar() {
		return this.em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
	}

	public void pagar(Integer id, String tipo) {
		TipoPagamento tipoPagamento = TipoPagamento.valueOf(tipo);
		Pedido pedido = this.em.find(Pedido.class, id);
		
		Pagamento pagamento = new Pagamento();
		pagamento.setTipoPagto(tipoPagamento);
		
		em.persist(pagamento);
		
		pedido.setPagamento(pagamento);
	}

	public void excluir(Integer id) {
		Pedido p = this.em.find(Pedido.class, id);
		this.em.remove(p);
		this.em.flush();
	}

	public void cadastrar(Integer clienteId, Integer[] produtosIds) throws Exception {
		Cliente2 cliente = this.em.find(Cliente2.class, clienteId);
		
		Pedido pedido = new Pedido();
		pedido.setData(new Date());
		pedido.setCliente(cliente);
		
		this.em.persist(pedido);
		
		double valorTotal = 0;
		for (int i = 0; i < produtosIds.length; i++) {
			Produto produto = this.em.find(Produto.class, produtosIds[i]);
			pedido.getProdutos().add(produto);
			valorTotal += produto.getValor();
		}
		
		pedido.setValorTotal(valorTotal);
	}
}
