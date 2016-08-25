package br.edu.ifpb.pps.models;

import br.edu.ifpb.pps.models.interfaces.IBridge;

public class Laboratorio implements IBridge{

	@Override
	public void funcao(int tipo, String apelido) {
		System.out.print("C�digo do laborat�rio: " + tipo + ".");
		System.out.println("Descri��o: "+ apelido + ".");
	}

	@Override
	public String getTipo() {
		return "Laboratorio";
	}
	
}