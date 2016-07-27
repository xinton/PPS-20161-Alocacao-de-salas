package br.edu.ifpb.pps.controllers;

import java.util.ArrayList;

import br.edu.ifpb.pps.models.Sala;



public abstract class ControladorSala {
	
	private static ArrayList<Sala> salas = new ArrayList<Sala>();
	
	/**
	 * O usu�rio pode adicionar salas ao sistema. Existem
	diferentes tipos de sala: aula normal, laborat�rio,
	confer�ncia e videoconfer�ncia. Cada sala tem uma
	capacidade f�sica. Cada sala possui uma identifica��o
	�nica: abrevia��o do pr�dio seguido de um n�mero
	(Exemplo: UAI04). Algumas salas possuem apelidos
	(Exemplo: Audit�rio Fulando de Tal).
	 */
	public static void adicionarSala(String salaId, String salaApelido, int salaCapacidade, int tipoSala){
		//TODO ver o bridge
		
		//debug -- apagar depois
		System.out.println("ide: "+salaId);
		System.out.println("ape: "+salaApelido);
		System.out.println("cap: "+salaCapacidade);
		System.out.println("tip: "+tipoSala);
		//debug -- apagar depois
		
		
		
		//criar switch case com enum dos tipos de sala (se eh q vai ser feito assim!!!)
		//adicionar no arraylist
		
	}
	
	/**
 	O usu�rio pode remover salas do sistema. A remo�ao
	de uma sala tamb�m remove as poss�veis aloca��es
	que referem a mesma, mas n�o exclui os respectivos
	eventos da base de dados.
 */
 public static void removerSala(){
	 
 }
 
 public static String listarSalas(){
	 return null;
 }
}
