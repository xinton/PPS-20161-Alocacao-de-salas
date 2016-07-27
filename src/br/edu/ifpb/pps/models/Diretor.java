package br.edu.ifpb.pps.models;

import java.util.Date;

import br.edu.ifpb.pps.models.interfaces.IBuilderEvento;

/**
 * Esta classe fará com que seja instaciado apenas um diretor.
 * @author Matheus Mayer
 * @since 25/07/2016
 */
public class Diretor 
{
	private static Diretor unicoDiretor;
	private IBuilderEvento builderEvento;
	/**
	 * Este metodo será privado para que não haja mais de uma instancia.
	 * @author Matheus Mayer
	 * @since 25/07/2016
	 */
	private Diretor(){}
	
	/**
	 * Este metodo realiza o retorno do unico diretor existente.
	 * @author Matheus Mayer
	 * @since 25/07/2016
	 * @return Diretor unicoDiretor
	 */
	public static synchronized Diretor getInstance()
	{
		if (unicoDiretor == null) {
			unicoDiretor = new Diretor(){};
		}
		
		return unicoDiretor;
	}
	
	/**
	 * Este metodo recupera o evento
	 * @author Matheus Mayer
	 * @return Evento builderEvento
	 */
	public Evento getEvento()
	{
		return this.builderEvento.getEvento();
	}
	
	public void setEvento(IBuilderEvento builderEvento)
	{
		this.builderEvento = builderEvento;
	}
	
	public void construirEvento(String nome, Date dataIni, Date dataFim, String contato, int repeticoes)
	{
		this.builderEvento.criarNovoEvento();
		this.builderEvento.definirNome(nome);
		this.builderEvento.definirDataInicio(dataIni);
		this.builderEvento.definirDataFim(dataFim);
		this.builderEvento.definirContato(contato);
		this.builderEvento.definirRepeticoes(repeticoes);
	}
