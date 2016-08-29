package br.edu.ifpb.pps.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.edu.ifpb.pps.facade.EventoFacade;
import br.edu.ifpb.pps.models.BuilderConcretoEvento;
import br.edu.ifpb.pps.models.Diretor;
import br.edu.ifpb.pps.models.Evento;
import br.edu.ifpb.pps.models.Sala;
import br.edu.ifpb.pps.models.interfaces.IBuilderEvento;

public abstract class ControladorEvento {

	private static ArrayList<Evento> eventos= new ArrayList<Evento>();
	private static Diretor diretor = Diretor.getInstance();
	private static EventoFacade eventoFacade = new EventoFacade();
	/**
	 * @author Matheus Mayer
	 * @param String nome
	 * @param Date dataIni
	 * @param Date dataFim
	 * @param String contato
	 * @param repeticoes
	 */
	public static void adicionarEvento(String nome, Date dataIni, Date dataFim, String contato, int repeticoes){
		eventoFacade.adicionarEventos(nome, dataIni, dataFim, contato, repeticoes);
	}

	/**
	 * Deve-se alocar uma sala para um evento (repetitivo
	ou nao). O sistema deve informar as salas disponiveis
	que satisfacam as restricoes do evento.
	 */
	public static void alocarEvento(Sala sala, Evento evento){
		evento.alocarSala(sala);
		sala.registrarEvento(evento);
				
		for(Sala opcao : salas){
			if(opcao.getSala() == sala.getSala() && opcao.getEventos().isEmpty()){
				salasDisponiveis.add(opcao);
			}
		}
	}
	
	public static List<Sala> verificarSalasDisponiveis()
	{
		// ISSO AQUI É GAMBIS, VER UM JEITO MELHOR!! 
		// FACHADA SERIA A MELHOR OPCAO!!
		ArrayList<Sala> salas = ControladorSala.getSalas();
		ArrayList<Sala> salasDisponiveis = new ArrayList<Sala>();

		for (Sala sala: salas) {
			if (sala.getEventos().isEmpty()){
				salasDisponiveis.add(sala);
			}
		}
	}
	
	/**
	 * @author Diego Carvalho
	 */
	public static void desalocarEvento(Evento evento) throws Exception{
		if (evento != null) {
			evento.desalocarSalas();
		} else {
			throw new Exception("Evento nao encontrado!");
			}
	}

	/**
	 * O usuario pode cancelar um evento. Neste caso, o
	cancelamento remove o evento da base de dados e
	desvincula as possiveis alocacoes previamente
	computadas.
	 * @throws Exception 
	 */
	public static void cancelarEvento(String nomeEvento) throws Exception{
		Evento evento = localizarEventoPorNome(nomeEvento);
		
		if (evento == null) {
			throw new Exception ("Evento não existente");
		}
		desalocarEvento(evento);
		removerEvento(evento);
	}
	
	public static ArrayList<Evento> getEventos(){
		return eventos;
		}	
	
	/**
	 * Este metodo localizar um evento pela data inicial
	 * @author Washington
	 * @param String data
	 * @return Evento evento || null
	 */
	public static Evento localizarEventoDataInicial(String data) throws ParseException {			
		// usuario tem que digitar assim -> dd/mm/aaaa
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(data);
		for (Evento evento: eventos)
			if (evento.getDataInicio().equals(date)  )
				return evento;
		return null;
	}
	
	public static Evento localizarEventoDataFim(String data) throws ParseException {			
		// usuario tem que digitar assim -> dd/mm/aaaa
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(data);
		for (Evento evento: eventos)
			if (evento.getDataFim().equals(date))
				return evento;
		return null;
	}
	
	/**
	 * Este metodo fara com que o evento seja removido da base de dados
	 * @author Matheus Mayer
	 * @param Evento evento
	 * @since 26/07/2016
	 */
	private static void removerEvento(Evento evento){
		eventos.remove(evento);
	}
}