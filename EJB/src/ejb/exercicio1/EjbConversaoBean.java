package ejb.exercicio1;

import javax.ejb.Stateless;

@Stateless
public class EjbConversaoBean implements EjbConversaoBeanLocal {

	@Override
	public Double converterQuilometrosParaMilhas(Double valorQuilometros) {
		return valorQuilometros * 0.62;
	}

	@Override
	public Double converterMilhasParaQuilometros(Double valorMilhas) {
		return valorMilhas / 0.62;
	}
}
