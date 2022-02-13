package br.com.rafael.exercicio1;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("operacao")
@RequestScoped
public class OperacaoMatematicaBean implements Serializable {

	private Integer operando1;
	private Integer operando2;
	private Integer operando3;
	private Integer result;

	public Integer getOperando1() {
		return operando1;
	}

	public void setOperando1(Integer operando1) {
		this.operando1 = operando1;
	}

	public Integer getOperando2() {
		return operando2;
	}

	public void setOperando2(Integer operando2) {
		this.operando2 = operando2;
	}

	public Integer getOperando3() {
		return operando3;
	}

	public void setOperando3(Integer operando3) {
		this.operando3 = operando3;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String somar() {
		this.result = this.operando1 + this.operando2 + this.operando3;
		return "result3";
	}
}
