package br.edu.ifpb.pps.controllers;

public abstract class ControladorSala {
	/**
	 * O usuário pode adicionar salas ao sistema. Existem
	diferentes tipos de sala: aula normal, laboratório,
	conferência e videoconferência. Cada sala tem uma
	capacidade física. Cada sala possui uma identificação
	única: abreviação do prédio seguido de um número
	(Exemplo: UAI04). Algumas salas possuem apelidos
	(Exemplo: Auditório Fulando de Tal).
	 */
	public void adicionarSala(){
		//TODO ver o bridge
	}
	
	/**
 	O usuário pode remover salas do sistema. A remoçao
	de uma sala também remove as possíveis alocações
	que referem a mesma, mas não exclui os respectivos
	eventos da base de dados.
 */
 public void removerSala(){
	 
 }
 
 public String listarSalas(){
	 return null;
 }
}
