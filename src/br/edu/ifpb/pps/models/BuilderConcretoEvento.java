package br.edu.ifpb.pps.models;

import java.util.Date;

import br.edu.ifpb.pps.interfaces.IBuilderEvento;

public class BuilderConcretoEvento implements IBuilderEvento
{
	private Evento evento;
	
	@Override
	public Evento getEvento() 
	{
		return this.evento;
	}

	@Override
	public void criarNovoEvento() 
	{
		this.evento = new Evento();
	}

	@Override
	public void definirNome(String nome)
	{
		//this.evento.setNome(nome);
	}

	@Override
	public void definirDataInicio(Date dataIni) 
	{
		//this.evento.setDataInicio(dataIni);
	}

	@Override
	public void definirDataFim(Date dataFim) 
	{
		//this.evento.setDataFim(dataFim);		
	}

	@Override
	public void definirContato(String contato)
	{
		//this.evento.setContato(contato);	
	}

	@Override
	public void definirRepeticoes(int repeticoes) 
	{
		//this.evento.setRepeticoes(repeticoes);	
	}

	@Override
	public void definirRepete(boolean repete) 
	{
		//this.evento.setRepete(repete);	
	}
}
