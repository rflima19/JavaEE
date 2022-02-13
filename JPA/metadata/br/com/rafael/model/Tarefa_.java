package br.com.rafael.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-06-13T11:06:08.111-0300")
@StaticMetamodel(Tarefa.class)
public class Tarefa_ {
	public static volatile SingularAttribute<Tarefa, Integer> id;
	public static volatile SingularAttribute<Tarefa, String> descricao;
	public static volatile SingularAttribute<Tarefa, Integer> prioridade;
	public static volatile SingularAttribute<Tarefa, Boolean> concluida;
}
