package br.com.rafael.test;

import java.time.DateTimeException;
import java.time.LocalDate;

import javax.enterprise.context.Dependent;

@Dependent
public class Data {

	private LocalDate localDate = null;
	
	private Integer dia;
	private Integer mes;
	private Integer ano;

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public boolean validarData() {
		try {
			this.localDate = LocalDate.of(this.ano, this.mes, this.dia);
		} catch (DateTimeException e) {
			return false;
		}
		return true;
	}

}
