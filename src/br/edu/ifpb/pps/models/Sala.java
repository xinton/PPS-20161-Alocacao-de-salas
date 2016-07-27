package br.edu.ifpb.pps.models;

import br.edu.ifpb.pps.models.interfaces.IBridge;

public class Sala {
	private String id, apelido, tipo;
	private int capacidade;
	private IBridge sala;
	
	public Sala(String id, String apelido, String tipo, int capacidade, IBridge sala) {
		this.id = id;
		this.apelido = apelido;
		this.tipo = tipo;
		this.capacidade = capacidade;
		this.sala = sala;
	}
	/**
	 * @author Pedro Paiva
	 */
	public void salaFuncao(){
		sala.funcao(tipo, apelido);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
}
