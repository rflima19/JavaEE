package br.com.rafael.exercicio1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	private static final InputStream IN = 
			ReadProperties.class.getClassLoader().getResourceAsStream("/br/com/rafael/exercicio1/application.properties");
	private static Properties props = new Properties();
	
	static {		
		try (ReadProperties.IN) {
			
			ReadProperties.props.load(ReadProperties.IN);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return ReadProperties.props.getProperty(key);
	}
}
