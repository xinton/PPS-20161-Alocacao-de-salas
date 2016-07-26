package br.edu.ifpb.pps.models;

import br.edu.ifpb.pps.models.interfaces.*;

public class Aula implements IBridge{
	@Override
	public void funcao(String tipo, String apelido) {
		System.out.print("Código da sala de aula: " + tipo + ".");
		System.out.println("Descrição: "+ apelido + ".");
	}
}
