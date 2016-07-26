package br.edu.ifpb.pps.models.interfaces;

import java.util.Date;

import br.edu.ifpb.pps.models.Evento;

public interface IBuilderEvento {
	public Evento getEvento();
	
	public void criarNovoEvento();
	
	public void definirNome(String nome);
	
	public void definirDataInicio(Date dataIni);
	
	public void definirDataFim(Date dataFim);
	
	public void definirContato(String contato);

	public void definirRepeticoes(int repeticoes);

	public void definirRepete(boolean repete);
}
