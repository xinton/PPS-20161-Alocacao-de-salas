package br.edu.ifpb.pps.models;

import java.util.ArrayList;
import java.util.Date;

public class Evento {

	private String nome, contato;
	private Date dataInicio, dataFim;
	private int repeticao;
	private boolean repete;
	private ArrayList<Sala> salas;
	
	public Evento(){}
	
	/**
	 * Construtor da Classe Evento, O construtor j� inicializa os atributos principais da classe.
	 * 
	 * @param nomeEvento, contato, dataInicio, dataFim, repete
	 * @author Diego Carvalho
	 * @since 25/07/2016
	 */
	public Evento(String nomeEvento,String contato, Date dataInicio, Date dataFim, int repeticao){
		this.nome = nomeEvento;
		this.contato = contato;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.repeticao = repeticao;
		checaRepeticao();
	}
	
	/**
	 * Metodo de aloca��o de uma sala a um Evento
	 * 
	 * @param sala
	 * @author Diego Carvalho
	 * @since 25/07/2016
	 */
	public void alocarSala(Sala sala){
		if(salas == null)
			salas = new ArrayList<Sala>();
		salas.add(sala);
	}
	
	/**
	 * M�todo que checa se o evento tem alguma repeti��o e altera a variavel repete (do tipo Boolean) para o estado atual.
	 * 
	 * @author Diego Carvalho
	 * @since 25/07/2016
	 */
	private void checaRepeticao(){
		if(repeticao > 0)
			repete = true;
		else
			repete = false;
	}

	// *******************************************************
	//                        GETs e SETs
	// *******************************************************

	// **************** GETs *********************
	public String getNome()     { return nome; }
	
	public String getContato()  { return contato; }
	
	public Date getDataInicio() { return dataInicio; }
	
	public Date getDataFim()    { return dataFim; }
	
	public int getRepeticao()   { return repeticao; }
	
	public boolean isRepete()   { return repete; }
	
	// **************** SETs *********************
	public void setNome(String nome)           { this.nome = nome; }

	public void setContato(String contato)     { this.contato = contato; }

	public void setDataInicio(Date dataInicio) { this.dataInicio = dataInicio; }

	public void setDataFim(Date dataFim)       { this.dataFim = dataFim; }
	
	public void setRepete(boolean repete)	   { this.repete = repete; }
	/**
	 * Metodo para setar o n�mero de repeti��es semanais do evento. Lan�a uma Exce��o caso seja menor do que ZERO.
	 * 
	 * @param repeticao
	 * @throws Exception
	 */
	public void setRepeticao(int repeticao) throws Exception{ 
		if(repeticao < 0)
			throw new Exception("O valor da repeti��o do evento N�O pode ser MENOR do que ZERO!");
		this.repeticao = repeticao;
		checaRepeticao();
	}
}
