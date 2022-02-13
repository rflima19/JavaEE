package br.com.rafael.exercicio1;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("pagamento")
@RequestScoped
public class PagamentoBean implements Serializable {

	@Inject
	private Compra compra;

	public PagamentoBean() {
		super();
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public String processar() {
		System.out.println("Bamdeira: " + this.compra.getCartaoCredito().getBandeira().toString());
		System.out.println("numero: " + this.compra.getCartaoCredito().getNumero());
		System.out.println("nome: " + this.compra.getCartaoCredito().getNome());
		System.out.println("Data validade: " + this.compra.getCartaoCredito().getDataValidade());
		System.out.println("Valor: " + this.compra.getValor());
		return "result";
	}
}
