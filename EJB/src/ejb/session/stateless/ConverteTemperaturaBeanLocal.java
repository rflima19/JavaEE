package ejb.session.stateless;

import javax.ejb.Local;
import javax.ejb.Remote;

@Local
//@Remote
public interface ConverteTemperaturaBeanLocal {

	public double converterCelsiusParaFahrenheit(Double tempCelsius);
}
