package br.edu.ifpb.pps.models;

import java.util.Date;

/**
 * 
 * @author home
 *
 */
public class Evento {
	private String nome, contato;
	private Date dataIni, dataFim;
	private int repeticao;
	private boolean repete;
	
	public Evento(){}
	
	/**
	 * 
	 * @param sala
	 */
	public void alocarSala(Sala sala){
		return;
	}
}
