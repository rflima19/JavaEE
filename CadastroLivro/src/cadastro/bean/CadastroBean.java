package cadastro.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import cadastro.model.Livro;

@Named("cadastro")
@SessionScoped
public class CadastroBean {

	private List<Livro> livros;
	private Boolean editar;

	public CadastroBean() {
		super();
		this.livros = new ArrayList<>();
		this.livros.add(new Livro("Java 1", "Maria", "Editora 1", 123));
		this.livros.add(new Livro("Java 2", "João", "Editora 2", 623));
		this.livros.add(new Livro("Java 3", "Vivi", "Editora 3", 423));
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}
}
