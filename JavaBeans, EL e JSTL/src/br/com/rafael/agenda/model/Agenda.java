package br.com.rafael.agenda.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Agenda {

	private class NomeComparator implements Comparator<Contato> {
		@Override
		public int compare(Contato c1, Contato c2) {
			return c1.getNome().compareTo(c2.getNome());
		}
	}
	
	private static Agenda instance = null;
	private HashMap<Integer, Contato> contatos;
	private NomeComparator nomeComparator;
	private Integer proximoID;
	
	private Agenda() {
		this.contatos = new HashMap<Integer, Contato>();
		this.nomeComparator = new NomeComparator();
		this.proximoID = 0;
		
		Contato c = null;
		
		c = new Contato();
		c.setNome("Maria");
		c.setTelefone("1111-1111");
		this.salvar(c);
		
		c = new Contato();
		c.setNome("João");
		c.setTelefone("2222-2222");
		this.salvar(c);
		
		c = new Contato();
		c.setNome("Carlos");
		c.setTelefone("3333-3333");
		this.salvar(c);
		
		c = new Contato();
		c.setNome("Bianca");
		c.setTelefone("4444-4444");
		this.salvar(c);
	}
	
	public static Agenda getIsntance( ) {
		if (Agenda.instance == null) {
			Agenda.instance = new Agenda();
		}
		
		return Agenda.instance;
	}
	
	public Set<Contato> getContatos() {
		TreeSet<Contato> set = new TreeSet<Contato>(this.nomeComparator);
		set.addAll(this.contatos.values());
		return set;
	}
	
	public void salvar(Contato contato) {
		if (contato.getId() == null) {
			contato.setId(this.gerarID());
		}
			
		this.contatos.put(contato.getId(), contato);
	}
	
	public Contato getContato(Integer id) {
		return this.contatos.get(id);
	}
	
	public void remover(Integer id) {
		this.contatos.remove(id);
	}

	private Integer gerarID() {
		return ++this.proximoID;
	}
}
