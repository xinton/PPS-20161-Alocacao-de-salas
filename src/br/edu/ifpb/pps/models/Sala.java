package br.edu.ifpb.pps.models;

import br.edu.ifpb.pps.models.interfaces.Pavimento;
import br.edu.ifpb.pps.models.interfaces.TipoSala;

public class Sala extends Pavimento{
	private String apelido;
	private int capacidade;
	private TipoSala tipo;
	private Evento evento;
	
	public Sala(String id, String apelido, int capacidade, TipoSala tipo) {
		super(id);
		this.apelido = apelido;
		this.capacidade = capacidade;
		this.tipo = tipo;	
	}
	
	/**
	 * @author Pedro Paiva
	 */
	
	public String getApelido() {
		return this.apelido;
	}
	
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public int getCapacidade() {
		return this.capacidade;
	}
	
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getTipo() {
		return tipo.getTipo();
	}
	
	public void setTipo(TipoSala tipo) {
		this.tipo = tipo;
	}
	
}