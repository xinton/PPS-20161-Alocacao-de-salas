package br.edu.ifpb.pps.controllers;

import java.util.ArrayList;

import br.edu.ifpb.pps.facade.SalaFacade;
import br.edu.ifpb.pps.models.Aula;
import br.edu.ifpb.pps.models.Conferencia;
import br.edu.ifpb.pps.models.Laboratorio;
import br.edu.ifpb.pps.models.Sala;
import br.edu.ifpb.pps.models.VideoConferencia;

import br.edu.ifpb.pps.models.interfaces.TipoSala;

public abstract class ControladorSala {
	
	private static SalaFacade salaFacade = new SalaFacade();
		
	public static void adicionarSala(String id, String apelido, int capacidade, int IDsala){
		salaFacade.adicionarSala(id, apelido, capacidade, IDsala);
	}

	public static void removerSala(String nomeSala){
		salaFacade.removerSala(nomeSala);
	}
	
	public static ArrayList<Sala> getSalas()
	{
		return salaFacade.getSalas();
	}
}