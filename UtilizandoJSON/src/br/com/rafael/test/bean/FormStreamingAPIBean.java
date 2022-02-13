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
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import br.com.rafael.test.model.Cadastro;

@Named("form2")
@RequestScoped
public class FormStreamingAPIBean implements Serializable {

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
		StringWriter sw = new StringWriter();
		//try (JsonGenerator jg = Json.createGenerator(sw)) {
		Map<String, Boolean> config = Map.of(JsonGenerator.PRETTY_PRINTING, true);
		JsonGeneratorFactory jgf = Json.createGeneratorFactory(config);
		try (JsonGenerator jg = jgf.createGenerator(sw)) {
			jg.writeStartObject()
				.write("nome", this.cadastro.getNome())
				.write("idade", this.cadastro.getIdade())
				.write("dataNascimento", FORMATTER.format(this.cadastro.getDataNascimento()))
				.write("casado", this.cadastro.getCasado())
				.writeStartObject("endereco")
					.write("rua", this.cadastro.getEndereco().getRua())
					.write("numero", this.cadastro.getEndereco().getNumero())
				.writeEnd()
				.writeStartArray("interesses");
			
					this.cadastro.getInteresses().forEach((String i) -> {
						jg.write(i);
					});
			
				jg.writeEnd();
			jg.writeEnd();
		}
		
		this.jsonStr = sw.toString();
		
		return null;
	}
	
	public String parseJson() {
		StringReader in = new StringReader(this.jsonStr);
		try (JsonParser jp = Json.createParser(in)) {
			String key = null;
			boolean isArray = false;
			while (jp.hasNext()) {
				Event event = jp.next();
				
				switch (event) {
					case KEY_NAME:
						key = jp.getString();
						break;
					case VALUE_STRING:
						String valueStr = jp.getString();
						if (!isArray) {
							if (key.equals("nome")) {
								this.cadastro.setNome(valueStr);
							} else if (key.equals("dataNascimento")) {
								this.cadastro.setDataNascimento(LocalDate.parse(valueStr, FORMATTER));
							} else if (key.equals("rua")) {
								this.cadastro.getEndereco().setRua(valueStr);
							}
						} else {
							this.cadastro.getInteresses().add(valueStr);
						}
						break;
					case VALUE_NUMBER:
						Integer valueInt = jp.getInt();
						if (key.equals("idade")) {
							this.cadastro.setIdade(valueInt);
						} else if (key.equals("numero")) {
							this.cadastro.getEndereco().setNumero(valueInt);
						}
						break;
					case VALUE_FALSE:
						this.cadastro.setCasado(false);
						break;
					case VALUE_TRUE:
						this.cadastro.setCasado(true);
						break;
					case START_ARRAY:
						isArray = true;
						break;
					case END_ARRAY:
						isArray = false;
						break;
					default:
						break;
					}
			}
		}
		
		return null;
	}

}
