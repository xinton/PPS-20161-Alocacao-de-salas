package br.edu.ifpb.pps.models;

import br.edu.ifpb.pps.models.interfaces.IBridge;

public class Aula implements IBridge{
	@Override
	public void funcao(int tipo, String apelido) {
		System.out.print("C�digo da sala de aula: " + tipo + ".");
		System.out.println("Descri��o: "+ apelido + ".");
	}

	@Override
	public String getTipo() {
		return "Aula";
	}
}