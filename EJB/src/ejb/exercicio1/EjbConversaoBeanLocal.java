package ejb.exercicio1;

import javax.ejb.Local;

@Local
public interface EjbConversaoBeanLocal {

	public Double converterQuilometrosParaMilhas(Double valorQuilometros);
	
	public Double converterMilhasParaQuilometros(Double valorMilhas);
}
