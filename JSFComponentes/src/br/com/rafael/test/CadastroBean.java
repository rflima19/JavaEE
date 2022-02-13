package br.com.rafael.test;

import java.io.Serializable;
import java.util.Arrays;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("cadastro")
@RequestScoped
public class CadastroBean implements Serializable {

	private String nome;
	private String email;
	private String senha1;
	private String senha2;
	private String sexo;
	private Boolean receberEmails;
	private String observacoes;
	private Integer[] linguagens;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha1() {
		return senha1;
	}

	public void setSenha1(String senha1) {
		this.senha1 = senha1;
	}

	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Boolean getReceberEmails() {
		return receberEmails;
	}

	public void setReceberEmails(Boolean receberEmails) {
		this.receberEmails = receberEmails;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer[] getLinguagens() {
		return linguagens;
	}

	public void setLinguagens(Integer[] linguagens) {
		this.linguagens = linguagens;
	}

	public Linguagem[] getListaLinguagens() {
		return Linguagem.LINGUAGENS;
	}

	public String exibirCadastro() {
		System.out.println("Nome: " + this.nome);
		System.out.println("Email: " + this.email);
		System.out.println("Senha1: " + this.senha1);
		System.out.println("Senha2: " + this.senha2);
		System.out.println("Sexo: " + this.sexo);
		System.out.println("Receber Email: " + this.receberEmails);
		System.out.println("Observações: " + this.observacoes);
		System.out.println("Linguagens: " + Arrays.toString(this.linguagens));

		return null;
	}

	public String getLinguagensComoString() {
		StringBuilder strb = new StringBuilder();
		int colocarVirgula = this.linguagens.length;
		for (Integer integer : linguagens) {
			strb.append(integer.intValue());
			if (colocarVirgula > 1) {
				strb.append(", ");
			}
			--colocarVirgula;
		}
		return strb.toString();
	}
}
