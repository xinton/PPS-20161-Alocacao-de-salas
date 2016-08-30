package br.edu.ifpb.pps.facade;

import java.util.ArrayList;
import java.util.Date;

import br.edu.ifpb.pps.controllers.ControladorEvento;
import br.edu.ifpb.pps.models.BuilderConcretoEvento;
import br.edu.ifpb.pps.models.Diretor;
import br.edu.ifpb.pps.models.Evento;
import br.edu.ifpb.pps.models.interfaces.IBuilderEvento;

public class EventoFacade 
{
	private ArrayList<Evento> eventos = new ArrayList<Evento>();
	private Diretor diretor = Diretor.getInstance();
	
	public EventoFacade(){}
	
	public void adicionarEventos(String nome, Date dataIni, Date dataFim, String contato, int repeticoes)
	{
		IBuilderEvento builderEvento = new BuilderConcretoEvento();
		this.diretor.setEvento(builderEvento);
		this.diretor.construirEvento(nome, dataIni, dataFim, contato, repeticoes);
		this.adicionarEventosNaLista(diretor.getEvento());
	}

	private void adicionarEventosNaLista(Evento evento){
		this.eventos.add(evento);
	}
	/**
	 * @author Matheus Mayer <matheusmayerduarte@gmail.com>
	 * Falta localizar por data!!
	 */
	public Evento localizarEvento(String nomeEvento, String contato, Date data) throws Exception {	
		if (!nomeEvento.isEmpty()) {
			return localizarEventoPorNome(nomeEvento);
		} else if (!contato.isEmpty()) {
			return localizarEventoPeloContato(contato);
		} else throw new Exception("Nao foi possivel localizar o evento pretendido");
	}
	
	/**
	 * Este metodo localizara um evento pelo nome
	 * @author Matheus Mayer
	 * @param String nomeEvento
	 * @return Evento evento || null
	 */
	public Evento localizarEventoPorNome(String nomeEvento){
		for (Evento evento: eventos)
			if (evento.getNome().contains(nomeEvento))
				return evento;
		return null;
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

	
}
