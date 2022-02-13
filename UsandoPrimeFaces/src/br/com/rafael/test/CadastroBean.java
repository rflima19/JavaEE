package br.com.rafael.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("cadastro")
@RequestScoped
public class CadastroBean implements Serializable {

	private Cliente cliente;
	private Transferencia transf;

	public CadastroBean() {
		super();
		this.cliente = new Cliente();
		this.transf = new Transferencia();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Transferencia getTransf() {
		return transf;
	}

	public void setTransf(Transferencia transf) {
		this.transf = transf;
	}

	public List<String> listarBancos(String text) {
		String[] bancos = new String[] {"Banco do Brasil", "Bradesco", "Caixa Econômica Federal", "Itaú"};
		List<String> listaBancos = Arrays.asList(bancos);
		
		List<String> listaBancosExibidos = new ArrayList<String>();
		
		for (String banco : listaBancos) {
			if (banco.toUpperCase().startsWith(text.toUpperCase())) {
				listaBancosExibidos.add(banco);
			}
		}
		
		return listaBancosExibidos;
	}
	
	public String cadastrar() {
		System.out.println("Cliente:");
		System.out.println("\t" + this.cliente);
		System.out.println("Transferência:");
		System.out.println("\t" + this.transf);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fim de operação", "Cadastro realiado com sucesso");
		fc.addMessage(null, fm);
		
		return null;
	}
}
