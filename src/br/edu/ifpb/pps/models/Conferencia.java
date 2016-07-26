package br.edu.ifpb.pps.models;

import br.edu.ifpb.pps.interfaces.IBridge;

public class Conferencia implements IBridge{

	@Override
	public void funcao(String tipo, String apelido) {
		System.out.print("Código da conferência: " + tipo + ".");
		System.out.println("Descrição: "+ apelido + ".");
		
	}

}
