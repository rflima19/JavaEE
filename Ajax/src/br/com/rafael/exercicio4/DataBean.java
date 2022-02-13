package br.com.rafael.exercicio4;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

@Named("data")
@RequestScoped
public class DataBean implements Serializable {

	private LocalDateTime dataHora;

	public DataBean() {
		super();
		this.dataHora = LocalDateTime.now();
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
//	public void agora(AjaxBehaviorEvent event) {
//		this.dataHora = LocalDateTime.now();
//	}
	
//	public String dataHoraFormatada() {
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//		return this.dataHora.format(dtf);
//	}
}
