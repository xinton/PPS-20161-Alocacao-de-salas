package br.edu.ifpb.pps.models;

import br.edu.ifpb.pps.controllers.IBridge;

public class Laboratorio implements IBridge{

	@Override
	public void funcao(String tipo, String apelido) {
		System.out.print("Código do laboratório: " + tipo + ".");
		System.out.println("Descrição: "+ apelido + ".");
	}
	
}
