package br.edu.ifpb.pps.controllers;

import java.util.ArrayList;

import br.edu.ifpb.pps.models.Sala;



public abstract class ControladorSala {
	
	private static ArrayList<Sala> salas = new ArrayList<Sala>();
	
	/**
	 * O usuário pode adicionar salas ao sistema. Existem
	diferentes tipos de sala: aula normal, laboratório,
	conferência e videoconferência. Cada sala tem uma
	capacidade física. Cada sala possui uma identificação
	única: abreviação do prédio seguido de um número
	(Exemplo: UAI04). Algumas salas possuem apelidos
	(Exemplo: Auditório Fulando de Tal).
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
 	O usuário pode remover salas do sistema. A remoçao
	de uma sala também remove as possíveis alocações
	que referem a mesma, mas não exclui os respectivos
	eventos da base de dados.
 */
 public static void removerSala(){
	 
 }
 
 public static String listarSalas(){
	 return null;
 }
}
