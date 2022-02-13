package br.com.rafael.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-06-13T11:06:07.806-0300")
@StaticMetamodel(Pedido.class)
public class Pedido_ {
	public static volatile SingularAttribute<Pedido, Integer> id;
	public static volatile SingularAttribute<Pedido, Double> valorTotal;
	public static volatile SingularAttribute<Pedido, Date> data;
	public static volatile SingularAttribute<Pedido, Pagamento> pagamento;
	public static volatile SingularAttribute<Pedido, Cliente2> cliente;
	public static volatile ListAttribute<Pedido, Produto> produtos;
}
