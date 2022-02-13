package br.com.rafael.exemplo1.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Properties {

	private static final String PATH_FILE = "C:/Users/Rafa/Desktop/props.txt";
	
	private static java.util.Properties props;
	
	static {
		//carrega o arquivo de propriedades na memória
		Path path = Paths.get(Properties.PATH_FILE);
		if (!(Files.exists(path))) {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Properties.props = new java.util.Properties();
		try (FileInputStream in = new FileInputStream(Properties.PATH_FILE)) {
			Properties.props.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Properties() {
		
	}
	
	public static Map<String, String> getProperties() {
		Map<String, String> map = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
		
		Set<Object> set = Properties.props.keySet();
		
		for (Object object : set) {
			String key = (String) object;
			map.put(key, Properties.props.getProperty(key));
		}
		
		return map;
	}
	
	public static String getValue(String key) {
		return Properties.props.getProperty(key);
	}
	
	public static void save(String key, String value) {
		Properties.props.setProperty(key, value);
		Properties.stock();
	}
	
	public static void delete(String key) {
		Properties.props.remove(key);
		Properties.stock();
	}
	
	private static void stock() {
		try (FileOutputStream out = new FileOutputStream(Properties.PATH_FILE)) {
			Properties.props.store(out, "Modificado em: " + LocalDateTime.now().toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
