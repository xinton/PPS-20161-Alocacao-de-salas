package br.edu.ifpb.pps.controllers;

import java.util.ArrayList;
import br.edu.ifpb.pps.models.Aula;
import br.edu.ifpb.pps.models.Conferencia;
import br.edu.ifpb.pps.models.Laboratorio;
import br.edu.ifpb.pps.models.Sala;
import br.edu.ifpb.pps.models.VideoConferencia;

import br.edu.ifpb.pps.models.interfaces.TipoSala;

public abstract class ControladorSala {
	
	private static ArrayList<Sala> salas = new ArrayList<Sala>();
	
	public static ArrayList<Sala> getSalas() {
		return salas;
	}

	public static void setSalas(ArrayList<Sala> salas) {
		ControladorSala.salas = salas;
	}

	
	public static void adicionarSala(String id, String apelido, int capacidade, int IDsala){
		IBridge sala;	
		TipoSala sala;	
		
		if (IDsala == 1) {
			sala = new Aula();
		} else if(IDsala == 2) {
			sala = new Laboratorio();
		} else if(IDsala == 3) {
			sala = new Conferencia(); 
		} else {
			sala = new VideoConferencia();
		}
		salas.add(new Sala(id, apelido, capacidade, sala));
		IDsala += 1;
	}
	
	/**
 	O usuario pode remover salas do sistema. A remocao
	de uma sala tambem remove as possiveis alocacoes
	que referem a mesma, mas nao exclui os respectivos
	eventos da base de dados.
 */
	public static void removerSala(String idSala){
		Sala sala = getSalaPeloId(idSala);
		salas.remove(sala);
	}
	
	public static Sala getSalaPeloId(String id){
		for(Sala sala: salas)
			if(sala.getApelido().equals(id))
				return sala;
		return null;
	}

}