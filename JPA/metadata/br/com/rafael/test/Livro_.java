package br.com.rafael.test;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-06-13T11:06:08.232-0300")
@StaticMetamodel(Livro.class)
public class Livro_ {
	public static volatile SingularAttribute<Livro, Integer> id;
	public static volatile SingularAttribute<Livro, String> nome;
	public static volatile SingularAttribute<Livro, String> autor;
	public static volatile SingularAttribute<Livro, Integer> numeroPaginas;
}
