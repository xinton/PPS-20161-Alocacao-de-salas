package br.edu.ifpb.pps.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifpb.pps.facade.EventoFacade;
import br.edu.ifpb.pps.models.BuilderConcretoEvento;
import br.edu.ifpb.pps.models.Diretor;
import br.edu.ifpb.pps.models.Evento;
import br.edu.ifpb.pps.models.Sala;
import br.edu.ifpb.pps.models.interfaces.IBuilderEvento;

public abstract class ControladorEvento {

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
		eventoFacade.alocarEvento(sala, evento);
	}
	
	/**
	 * @author Diego Carvalho
	 */
	public static void desalocarEvento(Evento evento) throws Exception{
		eventoFacade.desalocarEvento(evento);
	}
	
	public static void cancelarEvento(String nomeEvento) throws Exception{
		eventoFacade.cancelarEvento(nomeEvento);
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
}