package br.edu.ifpb.pps.controllers;

import java.util.ArrayList;
import java.util.Date;

import br.edu.ifpb.pps.models.Diretor;
import br.edu.ifpb.pps.models.Evento;

public abstract class ControladorEvento {
	
	private static ArrayList<Evento> eventos= new ArrayList<Evento>();
	
	/**
	 *  O usuário pode adicionar eventos ao sistema. Cada
	evento possui um nome, datas de inicio e fim, um
	nome para contato e um numero de repetiçoes
	semanais. Pode ser repetitivo ou não.
	 */
	public void adicionarEvento( String nome, Date dataIni,Date dataFim,String contato,int repeticoes,boolean repete ){
		Diretor diretor = Diretor.getInstance();
		diretor.construirEvento(nome, dataIni, dataFim, contato, repeticoes, repete);
	}
	
	/**
	 * Deve-se alocar uma sala para um evento (repetitivo
	ou não). O sistema deve informar as salas disponíveis
	que satisfaçam as restrições do evento.
	 */
	public void alocarEvento(){
		
	}
	
	/**
	 *  O usuário pode localizar um evento escalonado
	através do nome, contato, data etc.
	 */
	public Evento localizarEvento(){
		
		return null;
	}
	/**
	 * O usuário pode desalocar um evento previamente
	alocado.
	 */
	public void desalocarEvento(Evento evento){
		eventos.remove(evento);
	}
	
	/**
	 * O usuário pode cancelar um evento. Neste caso, o
	cancelamento remove o evento da base de dados e
	desvincula as possíveis alocações previamente
	computadas.
	 */
	public void cancelarEvento(){
		
	}
	
	

}
