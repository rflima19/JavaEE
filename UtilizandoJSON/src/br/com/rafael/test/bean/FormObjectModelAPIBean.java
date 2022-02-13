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
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;

import br.com.rafael.test.model.Cadastro;

@Named("form1")
@RequestScoped
public class FormObjectModelAPIBean implements Serializable {

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
		JsonObjectBuilder builder =  Json.createObjectBuilder();
		JsonObject rootObj = builder.add("nome", this.cadastro.getNome())
			.add("idade", this.cadastro.getIdade())
			.add("dataNascimento", FORMATTER.format(this.cadastro.getDataNascimento()))
			.add("casado", this.cadastro.getCasado())
			.add("endereco", Json.createObjectBuilder()
								.add("rua", this.cadastro.getEndereco().getRua())
								.add("numero", this.cadastro.getEndereco().getNumero())
								.build())
			.add("interesses", Json.createArrayBuilder(this.cadastro.getInteresses()))
			.build();
		
		StringWriter out = new StringWriter();
//		try (JsonWriter jw = Json.createWriter(out)) {
//			jw.write(rootObj);;
//		}
		Map<String, Boolean> config = Map.of(JsonGenerator.PRETTY_PRINTING, true);
		JsonWriterFactory jwf = Json.createWriterFactory(config);
		try (JsonWriter jw = jwf.createWriter(out)) {
			jw.write(rootObj);;
		}
		
		this.jsonStr = out.toString();
		
		return null;
	}
	
	public String parseJson() {
		JsonObject rootObj = null;
		
		StringReader in = new StringReader(this.jsonStr);
		try(JsonReader reader = Json.createReader(in)) {
			rootObj = reader.readObject();
		}
		
		this.cadastro.setNome(rootObj.getString("nome"));
		this.cadastro.setIdade(rootObj.getInt("idade"));
		this.cadastro.setDataNascimento(LocalDate.parse(rootObj.getString("dataNascimento"), FORMATTER));
		this.cadastro.setCasado(rootObj.getBoolean("casado"));
		
		JsonObject enderecoJson = rootObj.getJsonObject("endereco");
		this.cadastro.getEndereco().setRua(enderecoJson.getString("rua"));
		this.cadastro.getEndereco().setNumero(enderecoJson.getInt("numero"));
		
		JsonArray interessesJson = rootObj.getJsonArray("interesses");
		for (int i = 0; i < interessesJson.size(); i++) {
			String interesse = interessesJson.getString(i);
			this.cadastro.getInteresses().add(interesse);
		}
		
		return null;
	}

}
