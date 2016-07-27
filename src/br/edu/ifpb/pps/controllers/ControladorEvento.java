package br.edu.ifpb.pps.controllers;

import java.util.ArrayList;
import java.util.Date;

import br.edu.ifpb.pps.models.BuilderConcretoEvento;
import br.edu.ifpb.pps.models.Diretor;
import br.edu.ifpb.pps.models.Evento;
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
	public static void adicionarEvento(String nome, Date dataIni, Date dataFim, String contato, int repeticoes)
	{
		//debug -- apagar depois
		System.out.println("nom: "+nome);
		System.out.println("DIn: "+dataIni);
		System.out.println("DFi: "+dataFim);
		System.out.println("con: "+contato);
		System.out.println("rep: "+repeticoes);
		//debug -- apagar depois
		
		
		
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
	public void alocarEvento()
	{

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
	 * @throws Exception 
	 */
	public void cancelarEvento(String nomeEvento) throws Exception
	{
		Evento evento = localizarEventoPorNome(nomeEvento);
		if (evento == null) {
			throw new Exception ("Evento não existente");
		}
		desalocarEvento(evento);
		removerEvento(evento);
	}
	/**
	 * Este metodo adicionará cada evento na lista de eventos.
	 * @author Matheus Mayer
	 * @since 26/07/2016
	 * @param Evento evento
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
	private static Evento localizarEventoPorNome(String nomeEvento)
	{
		for (Evento evento: eventos) {	
			if (evento.getNome().contains(nomeEvento)) {
				return evento;
			}
		}
		
		return null;
	}
	/**
	 * Este metodo localizará o evento pelo contato do mesmo.
	 * @author Matheus Mayer
	 * @param String nomeContato
	 * @return Evento evento || null
	 */
	private static Evento localizarEventoPeloContato(String nomeContato)
	{
		for (Evento evento: eventos) {
			if (evento.getContato().contains(nomeContato)) {
				return evento;
			}
		}
		
		return null;
	}

	public static ArrayList<Evento> getEventos(){
		return eventos;
	}
	/**
	 * Este metodo fará com que o evento seja removido da base de dados
	 * @author Matheus Mayer
	 * @param Evento evento
	 * @since 26/07/2016
	 */
	private static void removerEvento(Evento evento)
	{
		eventos.remove(evento);
	}
	
	//private static void isEventoExistente(String nome){}

}
