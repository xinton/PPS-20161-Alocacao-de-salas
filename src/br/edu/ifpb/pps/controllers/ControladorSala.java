package br.edu.ifpb.pps.controllers;

public abstract class ControladorSala {
	/**
	 * O usu�rio pode adicionar salas ao sistema. Existem
	diferentes tipos de sala: aula normal, laborat�rio,
	confer�ncia e videoconfer�ncia. Cada sala tem uma
	capacidade f�sica. Cada sala possui uma identifica��o
	�nica: abrevia��o do pr�dio seguido de um n�mero
	(Exemplo: UAI04). Algumas salas possuem apelidos
	(Exemplo: Audit�rio Fulando de Tal).
	 */
	public void adicionarSala(){
		//TODO ver o bridge
	}
	
	/**
 	O usu�rio pode remover salas do sistema. A remo�ao
	de uma sala tamb�m remove as poss�veis aloca��es
	que referem a mesma, mas n�o exclui os respectivos
	eventos da base de dados.
 */
 public void removerSala(){
	 
 }
 
 public String listarSalas(){
	 return null;
 }
}
