package br.com.rafael.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-06-13T11:06:07.161-0300")
@StaticMetamodel(Curso.class)
public class Curso_ {
	public static volatile SingularAttribute<Curso, Integer> id;
	public static volatile SingularAttribute<Curso, String> nome;
	public static volatile ListAttribute<Curso, Modulo> modulos;
}
