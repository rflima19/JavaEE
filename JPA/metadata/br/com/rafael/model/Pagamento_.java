package br.com.rafael.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-06-13T11:06:07.721-0300")
@StaticMetamodel(Pagamento.class)
public class Pagamento_ {
	public static volatile SingularAttribute<Pagamento, Integer> id;
	public static volatile SingularAttribute<Pagamento, TipoPagamento> tipoPagto;
	public static volatile SingularAttribute<Pagamento, Pedido> pedido;
}
