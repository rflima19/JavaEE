package cadastro.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import cadastro.dao.IntereseDAO;
import cadastro.entidades.Endereco;
import cadastro.entidades.Estado;
import cadastro.entidades.Interese;
import cadastro.entidades.Pessoa;
import cadastro.entidades.Telefone;
import cadastro.servicos.EstadoServico;
import cadastro.servicos.IntereseServico;
import cadastro.servicos.Servico;

@Named("cadastro")
@SessionScoped
public class CadastroBean implements Serializable {

	private Pessoa pessoa;
	private EstadoServico estadoServico;
	private IntereseServico interesseService;

	public CadastroBean() {
		super();
		this.pessoa = new Pessoa();
		this.estadoServico = new EstadoServico();
		this.interesseService = new IntereseServico();
		
		this.pessoa.setEnderecoResidencial(new Endereco());
		this.pessoa.setEnderecoComercial(new Endereco());
		this.pessoa.setTelefoneResidencial(new Telefone());
		this.pessoa.setTelefoneCelular(new Telefone());
		this.pessoa.setTelefoneComercial(new Telefone());
		this.pessoa.setInteresses(this.getInteresses());
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Estado> getEstados() {
		return this.estadoServico.carregar();
	}

	private Interese[] getInteresses() {
		List<Interese> list = this.interesseService.carregar();
		return (Interese[]) list.toArray();
	}
}
