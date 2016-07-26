package br.edu.ifpb.pps.controllers;

import java.util.ArrayList;
import java.util.Date;

import br.edu.ifpb.pps.models.Diretor;
import br.edu.ifpb.pps.models.Evento;

public abstract class ControladorEvento {
	
	private static ArrayList<Evento> eventos= new ArrayList<Evento>();
	
	/**
	 *  O usu�rio pode adicionar eventos ao sistema. Cada
	evento possui um nome, datas de inicio e fim, um
	nome para contato e um numero de repeti�oes
	semanais. Pode ser repetitivo ou n�o.
	 */
	public void adicionarEvento( String nome, Date dataIni,Date dataFim,String contato,int repeticoes,boolean repete ){
		Diretor diretor = Diretor.getInstance();
		diretor.construirEvento(nome, dataIni, dataFim, contato, repeticoes, repete);
	}
	
	/**
	 * Deve-se alocar uma sala para um evento (repetitivo
	ou n�o). O sistema deve informar as salas dispon�veis
	que satisfa�am as restri��es do evento.
	 */
	public void alocarEvento(){
		
	}
	
	/**
	 *  O usu�rio pode localizar um evento escalonado
	atrav�s do nome, contato, data etc.
	 */
	public Evento localizarEvento(){
		
		return null;
	}
	/**
	 * O usu�rio pode desalocar um evento previamente
	alocado.
	 */
	public void desalocarEvento(Evento evento){
		eventos.remove(evento);
	}
	
	/**
	 * O usu�rio pode cancelar um evento. Neste caso, o
	cancelamento remove o evento da base de dados e
	desvincula as poss�veis aloca��es previamente
	computadas.
	 */
	public void cancelarEvento(){
		
	}
	
	

}
