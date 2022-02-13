 package br.com.rafael.test;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named("formRegiaoEstado")
@SessionScoped
public class CadastroRegiaoEstadoBean implements Serializable {

	private Collection<Regiao> regioes;
	private Collection<Estado> estados;
	private String siglaRegiao;
	private String siglaEstado;
	private String cidade;
	
	@PostConstruct
	protected void init() {
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
