package br.edu.ifpb.pps.models;

import br.edu.ifpb.pps.models.interfaces.IBridge;

public class VideoConferencia implements IBridge{

	@Override
	public void funcao(int tipo, String apelido) {
		System.out.print("C�digo do local da v�deo confer�ncia: " + tipo + ".");
		System.out.println("Descri��o: "+ apelido + ".");
	}

	@Override
	public String getTipo() {
		return "Video Conferencia";
	}
	
}