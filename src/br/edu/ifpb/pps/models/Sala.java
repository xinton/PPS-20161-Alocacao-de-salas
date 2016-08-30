package br.edu.ifpb.pps.models;

import java.util.ArrayList;


public class Sala {
	private String id, apelido;
	private int capacidade, tipo;
	private IBridge sala;
	private ArrayList<Evento> eventos;
	
	public Sala(String id, String apelido, int capacidade, IBridge sala) {
		this.id = id;
import br.edu.ifpb.pps.models.interfaces.Pavimento;
import br.edu.ifpb.pps.models.interfaces.TipoSala;

public class Sala extends Pavimento{
	private String id, apelido;
	private int capacidade;
	private TipoSala tipo;
	private ArrayList<Evento> eventos;
	
	public Sala(String id, String apelido, int capacidade, TipoSala tipo) {
		super(id);
		this.apelido = apelido;
		this.capacidade = capacidade;
		this.tipo=this.tipo;
		
	}
	/**
	 * @author Pedro Paiva
	 */
	
	
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

	public ArrayList<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}
	public TipoSala getTipo() {
		return tipo;
	}
	public void setTipo(TipoSala tipo) {
		this.tipo = tipo;
	}
}