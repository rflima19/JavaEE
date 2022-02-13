package br.com.rafael.test;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named("formRegiaoEstado2")
@javax.enterprise.context.RequestScoped
public class CadastroRegiaoEstadoBean2 implements Serializable {

	private Collection<Regiao> regioes;
	private Collection<Estado> estados;
	private String siglaRegiao;
	private String siglaEstado;
	private String cidade;
	
	public void carregarRegioes(ComponentSystemEvent event) {
		this.regioes = RegioesProvider.getRegioes();
	}
	
	public Collection<Regiao> getRegioes() {
		return regioes;
	}
	
	public Collection<Estado> getEstados() {
		return estados;
	}

	public String getSiglaRegiao() {
		return siglaRegiao;
	}

	public void setSiglaRegiao(String siglaRegiao) {
		this.siglaRegiao = siglaRegiao;
	}

	public String getSiglaEstado() {
		return siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setRegioes(Collection<Regiao> regioes) {
		this.regioes = regioes;
	}

	public void setEstados(Collection<Estado> estados) {
		this.estados = estados;
	}

	public void carregarEstados(ActionEvent event) {
		this.estados = RegioesProvider.getEstadosByRegiao(siglaRegiao);
	}
	
	public void carregarEstados2(ValueChangeEvent event) {
		this.estados = RegioesProvider.getEstadosByRegiao(event.getNewValue().toString());
	}
	
	public void carregarEstados3(ValueChangeEvent event) {
		this.estados = RegioesProvider.getEstadosByRegiao(event.getNewValue().toString());
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.renderResponse();
	}
}
