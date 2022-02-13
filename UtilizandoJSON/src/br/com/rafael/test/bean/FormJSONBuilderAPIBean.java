package br.com.rafael.test.bean;

import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import br.com.rafael.test.model.Cadastro;

@Named("form3")
@RequestScoped
public class FormJSONBuilderAPIBean implements Serializable {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private Cadastro cadastro = new Cadastro();

	private String jsonStr;

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

	public String convertToJson() {
		
		JsonbConfig config = new JsonbConfig();
		config.withFormatting(true);
		
		//Jsonb jsonb = JsonbBuilder.create();
		Jsonb jsonb = JsonbBuilder.create(config);
		this.jsonStr = jsonb.toJson(this.cadastro);
		return null;
	}
	
	public String parseJson() {
		
		Jsonb jsonb = JsonbBuilder.create();
		this.cadastro = jsonb.fromJson(this.jsonStr, Cadastro.class);
		
		return null;
	}

}
