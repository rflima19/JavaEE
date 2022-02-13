package br.com.rafael.ejb;

import javax.ejb.Local;

import br.com.rafael.model.Voo;

@Local
public interface VooBeanLocal {

	public void inserir(Voo voo);
	
	public Voo carregar(Integer numero, String empresa);
}
