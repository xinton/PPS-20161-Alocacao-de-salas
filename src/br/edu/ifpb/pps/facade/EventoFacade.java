package br.edu.ifpb.pps.facade;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.edu.ifpb.pps.controllers.ControladorEvento;
import br.edu.ifpb.pps.models.BuilderConcretoEvento;
import br.edu.ifpb.pps.models.Diretor;
import br.edu.ifpb.pps.models.Evento;
import br.edu.ifpb.pps.models.Sala;
import br.edu.ifpb.pps.models.interfaces.IBuilderEvento;

/*
 * Esta classe foi criada com intenção de simular a base de dados
 * e ser a responsável por tratar das questões dos eventos.
 * @author Matheus Mayer <matheusmayerduarte@gmail.com>
 */
public class EventoFacade 
{
	private ArrayList<Evento> eventos = new ArrayList<Evento>();
	private Diretor diretor = Diretor.getInstance();
	SalaFacade salaFacade = new SalaFacade();
	
	public EventoFacade(){}
	
	public void adicionarEventos(String nome, Date dataIni, Date dataFim, String contato, int repeticoes)
	{
		IBuilderEvento builderEvento = new BuilderConcretoEvento();
		this.diretor.setEvento(builderEvento);
		this.diretor.construirEvento(nome, dataIni, dataFim, contato, repeticoes);
		this.adicionarEventosNaLista(diretor.getEvento());
	}

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	private void adicionarEventosNaLista(Evento evento)
	{
		this.eventos.add(evento);
	}
	/*
	 * @author Matheus Mayer <matheusmayerduarte@gmail.com>
	 * Este metodo alocará um evento na primeira sala vazia encontrada automaticamente
	 */
	//Alocar evento tendo j� uma sala como escolha
	public void alocarEvento(Sala sala, Evento evento)
	{
		evento.setSala(sala);
		sala.setEvento(evento);
	}
	
	//Alocar evento procurando uma sala disponivel
	public void alocarEvento(Evento evento)
	{
		Sala sala = salaFacade.procurarSalaDisponivel();
		evento.setSala(sala);
		sala.setEvento(evento);
	}
	
	/**
	 * @author Matheus Mayer <matheusmayerduarte@gmail.com>
	 * Falta localizar por data!!
	 */
	public Evento localizarEvento(String nomeEvento, String contato, Date data) throws Exception 
	{	
		if (!nomeEvento.isEmpty()) {
			return localizarEventoPorNome(nomeEvento);
		} else if (!contato.isEmpty()) {
			return localizarEventoPeloContato(contato);
		} else{ 

			throw new Exception("Nao foi possivel localizar o evento pretendido");
		}
	}
	
	public Evento localizarEvento(String nomeEvento) throws Exception 
	{	
		if (!nomeEvento.isEmpty()) {
			return localizarEventoPorNome(nomeEvento);
		} else{ 

			throw new Exception("Nao foi possivel localizar o evento pretendido");
		}
	}
	
	/**
	 * Este metodo localizara um evento pelo nome
	 * @author Matheus Mayer
	 * @param String nomeEvento
	 * @return Evento evento || null
	 */
	public Evento localizarEventoPorNome(String nomeEvento)
	{
		for (Evento evento: eventos) {

			if (evento.getNome().contains(nomeEvento))
				return evento;
		}

		return null;
	}
	
	/*
	 * Este metodo desaloca o evento de uma sala
	 * @author Matheus Mayer <matheusmayerduarte@gmail.com>
	 */
	public void desalocarEvento(Evento evento) throws Exception
	{
		if (evento != null) {
			evento.setSala(null);
		} else {
			
			throw new Exception("Evento nao encontrado!");
		}
	}
	
	/*
	 * Este metodo cancelará o evento.
	 * @author Matheus Mayer <matheusmayerduarte@gmail.com>
	 * @param String nomeEvento
	 */
	public void cancelarEvento(String nomeEvento) throws Exception
	{
		Evento evento = localizarEventoPorNome(nomeEvento);
		
		if (evento != null) {
			desalocarEvento(evento);
			this.removerEvento(evento);
		}
		
		throw new Exception ("Evento não existente");
	}
	
	/**
	 * Este metodo fara com que o evento seja removido da base de dados
	 * @author Matheus Mayer
	 * @param Evento evento
	 * @since 26/07/2016
	 */
	private void removerEvento(Evento evento){
		this.eventos.remove(evento);
	}

	/**
	 * Este metodo localizara o evento pelo contato do mesmo.
	 * @author Matheus Mayer
	 * @param String nomeContato
	 * @return Evento evento || null
	 */
	public Evento localizarEventoPeloContato(String nomeContato){
		for (Evento evento: eventos) 
			if (evento.getContato().contains(nomeContato)) 
				return evento;	
		return null;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}
	
	public Diretor getDiretor() {
		return diretor;
	}
	
	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}
	

	/**
	 * Este metodo localizar um evento pela data inicial
	 * @author Washington
	 * @param String data
	 * @return Evento evento || null
	 */
	public Evento localizarEventoDataInicial(String data) throws ParseException {			
		// usuario tem que digitar assim -> dd/mm/aaaa
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(data);

		for (Evento evento: eventos){
			if (evento.getDataInicio().equals(date)){

				return evento;
			}
		}

		return null;
	}
	/**
	 * Este metodo localizar um evento pela data fim
	 * @author Washington
	 * @param String data
	 * @return Evento evento || null
	 */
	public Evento localizarEventoDataFim(String data) throws ParseException {			
		// usuario tem que digitar assim -> dd/mm/aaaa
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(data);
		for (Evento evento: eventos){
			if (evento.getDataFim().equals(date)){

				return evento;
			}
		}

		return null;
	}
}
