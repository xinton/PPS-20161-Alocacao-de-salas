package br.edu.ifpb.pps.models;

import java.util.ArrayList;

import br.edu.ifpb.pps.models.interfaces.IBridge;

public class Sala {
	private String id, apelido;
	private int capacidade, tipo;
	private IBridge sala;
	private ArrayList<Evento> eventos;
	
	public Sala(String id, String apelido, int capacidade, IBridge sala) {
		this.id = id;
		this.apelido = apelido;
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
		return sala.getTipo();
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public void registrarEvento(Evento evento){
		if(eventos == null)
			eventos = new ArrayList<Evento>();
		eventos.add(evento);
	}
	public IBridge getSala() {
		return sala;
	}
	public void setSala(IBridge sala) {
		this.sala = sala;
	}
	public ArrayList<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}
}