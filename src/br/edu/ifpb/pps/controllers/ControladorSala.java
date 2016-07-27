package br.edu.ifpb.pps.controllers;

import java.util.ArrayList;

import br.edu.ifpb.pps.models.Aula;
import br.edu.ifpb.pps.models.Conferencia;
import br.edu.ifpb.pps.models.Laboratorio;
import br.edu.ifpb.pps.models.Sala;
import br.edu.ifpb.pps.models.VideoConferencia;
import br.edu.ifpb.pps.models.interfaces.IBridge;

public abstract class ControladorSala {
	private static ArrayList<Sala> salas = new ArrayList<Sala>();
	private static int idSala = 1;
	
	public static ArrayList<Sala> getSalas(){
		return salas;
	}

	public static void setSalas(ArrayList<Sala> salas) {
		ControladorSala.salas = salas;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	
	public static void adicionarSala(String apelido, String tipo, int capacidade, int IDsala){
		IBridge sala;	
		
		if(IDsala == 1){
			sala = new Aula();
		}else if(IDsala == 2){
			sala = new Laboratorio();
		}else if(IDsala == 3){
			sala = new Conferencia(); 
		}else{
			sala = new VideoConferencia();
		}
		
		salas.add(new Sala(Integer.toString(idSala), apelido, tipo, capacidade, sala));
		idSala += 1;
	}
	
	/**
 	O usuário pode remover salas do sistema. A remoçao
	de uma sala também remove as possíveis alocações
	que referem a mesma, mas não exclui os respectivos
	eventos da base de dados.
 */
 public void removerSala(String idSala){
	 for(Sala objeto : salas){
		 if(objeto.getId().equals(idSala)){
			 salas.remove(objeto);
		 }
	 }
 }
 
 public String listarSalas(){
	 String result = "";
	 
	 for(Sala sala : salas){
		 result += "";
	 }
	 
	 return null;
 } 
 
}
