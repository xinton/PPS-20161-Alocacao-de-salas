package br.edu.ifpb.pps.facade;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.pps.models.Aula;
import br.edu.ifpb.pps.models.Conferencia;
import br.edu.ifpb.pps.models.Laboratorio;
import br.edu.ifpb.pps.models.Sala;
import br.edu.ifpb.pps.models.VideoConferencia;
import br.edu.ifpb.pps.models.interfaces.IBridge;
import br.edu.ifpb.pps.models.interfaces.TipoSala;

/*
 * Esta classe tem o objetivo de simular a base de dados e 
 * ser responsável pelas ações da sala.
 * @author Matheus Mayer <matheusmayerduarte@gmail.com>
 */
public class SalaFacade
{
	private ArrayList<Sala> salas = new ArrayList<Sala>();
	
	public SalaFacade(){}
	// ALGUÉM PEGA ESSE METODO!!
	public void adicionarSala(String id, String apelido, int capacidade, int IDsala){
		//O que � que esse IBridge ta fazendo aqui?
		//IBridge sala;	
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
	
	public void removerSala(String nomeSala){
		Sala sala = getSalaId(nomeSala);
		salas.remove(sala);
	}
	
	public ArrayList<Sala> getSalas()
	{
		return this.salas;
	}
	
	public void setSalas(ArrayList<Sala> salas)
	{
		this.salas = salas;
	}
	/*
	 * Este metodo servirá para resgatar a primeira sala disponivel
	 * @author Matheus Mayer <matheusmayerduarte@gmail.com> 
	 */
	public Sala procurarSalaDisponivel(){
		for (Sala sala : salas) {
			if (sala.getEvento() == null) {
				return sala;
			}
		}
		return null;
	}
	/*
	 * @author Diego Carvalho
	 */
	public Sala getSalaId(String nomeSala){
		for(Sala sala: salas){
			if(sala.getId().equals(nomeSala)){
				return sala;
			}
		}
		return null;
	}
}
