package br.com.rafael.ejb;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafael.model.Bicicleta;
import br.com.rafael.model.Carro;

@Stateless
public class VeiculoBean implements Serializable {

	@PersistenceContext
	private EntityManager em;
	
	public void processar() {
		
		Bicicleta b1 = new Bicicleta();
		b1.setFabricante("caloi");
		b1.setQuantidadeDePessoas(2);
		b1.setTamanhoAro(29);
		this.em.persist(b1);
		
		Bicicleta b2 = new Bicicleta();
		b2.setFabricante("caloi");
		b2.setQuantidadeDePessoas(1);
		b2.setTamanhoAro(20);
		this.em.persist(b2);
		
		Carro c1 = new Carro();
		c1.setFabricante("renault");
		c1.setQuantidadeDePessoas(5);
		c1.setQuantidadeDePortas(2);
		this.em.persist(c1);
		
		Carro c2 = new Carro();
		c2.setFabricante("fiat");
		c2.setQuantidadeDePessoas(7);
		c2.setQuantidadeDePortas(4);
		this.em.persist(c2);
	}
	
}
