package br.edu.ifpb.pps.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.edu.ifpb.pps.models.BuilderConcretoEvento;
import br.edu.ifpb.pps.models.Diretor;
import br.edu.ifpb.pps.models.Evento;
import br.edu.ifpb.pps.models.Sala;
import br.edu.ifpb.pps.models.interfaces.IBuilderEvento;

public abstract class ControladorEvento {

	private static ArrayList<Evento> eventos= new ArrayList<Evento>();
	private static Diretor diretor;
	/**
	 *  O usu�rio pode adicionar eventos ao sistema. Cada
	evento possui um nome, datas de inicio e fim, um
	nome para contato e um numero de repeti�oes
	semanais. Pode ser repetitivo ou n�o.
	 */

	public void inicializarDiretor()
	{
		diretor = Diretor.getInstance();
	}
	public static void adicionarEvento(String nome, Date dataIni, Date dataFim, String contato, int repeticoes, boolean repete )
	{
		IBuilderEvento builderEvento = new BuilderConcretoEvento();
		diretor.setEvento(builderEvento);
		diretor.construirEvento(nome, dataIni, dataFim, contato, repeticoes);
		adicionarEventosNaLista(diretor.getEvento());
	}

	/**
	 * Deve-se alocar uma sala para um evento (repetitivo
	ou n�o). O sistema deve informar as salas dispon�veis
	que satisfa�am as restri��es do evento.
	 */
	public void alocarEvento(Sala sala, Evento evento)
	{
		evento.alocarSala(sala);
		sala.registrarEvento(evento);
				
		ArrayList<Sala> salas = ControladorSala.getSalas();
		ArrayList<Sala> salasDisponiveis = new ArrayList<Sala>();
		
		for(Sala opcao : salas){
			if(opcao.getSala() == sala.getSala() && opcao.getEventos().isEmpty()){
				salasDisponiveis.add(opcao);
			}
		}
		
		//return salasDisponiveis;
	}

	public static ArrayList<Evento> getEventos() {
		return eventos;
	}
	public static void setEventos(ArrayList<Evento> eventos) {
		ControladorEvento.eventos = eventos;
	}
	public static Diretor getDiretor() {
		return diretor;
	}
	public static void setDiretor(Diretor diretor) {
		ControladorEvento.diretor = diretor;
	}
	/**
	 *  O usu�rio pode localizar um evento escalonado
	atrav�s do nome, contato, data etc.
	 */
	public static Evento localizarEvento(String nomeEvento, String contato, Date data) throws Exception 
	{	
		if (!nomeEvento.isEmpty()) {
			return localizarEventoPorNome(nomeEvento);
		}else if (!contato.isEmpty()) {
			return localizarEventoPeloContato(contato);
		}else throw new Exception("Nao foi possivel localizar o evento pretendido");
		//return diretor.getEvento();
	}
	/**
	 * O usu�rio pode desalocar um evento previamente
	alocado.
	 */
	public void desalocarEvento(Evento evento){
		
	}

	/**
	 * O usu�rio pode cancelar um evento. Neste caso, o
	cancelamento remove o evento da base de dados e
	desvincula as poss�veis aloca��es previamente
	computadas.
	 */
	public void cancelarEvento(Evento evento)
	{
		eventos.remove(evento);
	}
	/**
	 * Este metodo adicionará cada evento na lista de eventos.
	 * @author Matheus Mayer
	 * @since 26/07/2016
	 */
	private static void adicionarEventosNaLista(Evento evento)
	{
		eventos.add(evento);
	}
	
	/**
	 * Este metodo localizará um evento pelo nome
	 * @author Matheus Mayer
	 * @param String nomeEvento
	 * @return Evento evento || null
	 */
	public static Evento localizarEventoPorNome(String nomeEvento)
	{
		for (Evento evento: eventos) {	
			if (evento.getNome().contains(nomeEvento)) {
				return evento;
			}
		}
		
		return null;
	}
	
	public static Evento localizarEventoPeloContato(String nomeContato)
	{
		for (Evento evento: eventos) {
			if (evento.getContato().contains(nomeContato)) {
				return evento;
			}
		}
		
		return null;
	}
	
	/**
	 * Este metodo localizar um evento pela data inicial
	 * @author Washington
	 * @param String data
	 * @return Evento evento || null
	 */
	public static Evento localizarEventoDataInicial(String data) throws ParseException 
	{			
		// usuario tem que digitar assim -> dd/mm/aaaa
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(data);
		for (Evento evento: eventos) {
			if (evento.getDataInicio().equals(date)  ) {
				return evento;
			}
		}
		
		return null;
	}
	
	public static Evento localizarEventoDataFim(String data) throws ParseException 
	{			
		// usuario tem que digitar assim -> dd/mm/aaaa
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(data);
		for (Evento evento: eventos) {
			if (evento.getDataFim().equals(date)  ) {
				return evento;
			}
		}
		
		return null;
	}

}
