package br.com.rafael.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-06-13T11:06:07.451-0300")
@StaticMetamodel(Modulo.class)
public class Modulo_ {
	public static volatile SingularAttribute<Modulo, Integer> id;
	public static volatile SingularAttribute<Modulo, String> nome;
	public static volatile SingularAttribute<Modulo, Integer> posicao;
	public static volatile SingularAttribute<Modulo, Curso> curso;
	public static volatile ListAttribute<Modulo, Aula> aulas;
}
