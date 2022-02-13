package br.com.rafael.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-06-13T11:06:06.771-0300")
@StaticMetamodel(Cliente2.class)
public class Cliente2_ {
	public static volatile SingularAttribute<Cliente2, Integer> id;
	public static volatile SingularAttribute<Cliente2, String> nome;
	public static volatile SingularAttribute<Cliente2, String> email;
	public static volatile ListAttribute<Cliente2, Pedido> pedidos;
}
