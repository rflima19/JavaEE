package ejb.session.stateless;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class ConverteTemperaturaBean
 */
@Stateless
public class ConverteTemperaturaBean implements ConverteTemperaturaBeanLocal {

    /**
     * Default constructor. 
     */
    public ConverteTemperaturaBean() {
        
    }

	@Override
	public double converterCelsiusParaFahrenheit(Double tempCelsius) {
		return 9 * (tempCelsius / 5) + 32;
	}

}
