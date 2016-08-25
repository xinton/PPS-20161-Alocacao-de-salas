package br.edu.ifpb.pps.models;

import br.edu.ifpb.pps.models.interfaces.IBridge;

public class Conferencia implements IBridge{

	@Override
	public void funcao(int tipo, String apelido) {
		System.out.print("C�digo da confer�ncia: " + tipo + ".");
		System.out.println("Descri��o: "+ apelido + ".");
		
	}

	@Override
	public String getTipo() {
		return "Conferencia";
	}

}