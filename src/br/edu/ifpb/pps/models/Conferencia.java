package br.edu.ifpb.pps.models;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifpb.pps.models.interfaces.TipoSala;

/**
 * @author Jo�o Paulo
 */

public class Conferencia implements TipoSala{

	private Map<TipoMaterial,Integer> materiais = new HashMap<>();
	
	public Conferencia(){
		materiais.put(TipoMaterial.CADEIRA, 10 );
		materiais.put(TipoMaterial.MESA, 1 );
		materiais.put(TipoMaterial.PROJETOR, 1 );
	}

	@Override
	public void verMaterais() {
		for(TipoMaterial mat: materiais.keySet()){
			Integer quantidade=materiais.get(mat);
			System.out.println("A sala possui "+quantidade+ " do equipamento "+ mat);
		}
	}

	@Override
	public void adcionarMateriais(TipoMaterial material, int quantidade) {
		materiais.put(material, materiais.get(material)+quantidade);
		
	}

	@Override
	public void removerMaterial(TipoMaterial material, int quantidade) {
		materiais.put(material, materiais.get(material)-quantidade);
		if(materiais.get(material)<=0){
			materiais.remove(material);
		}
	}

	@Override
	public void funcao(int tipo, String apelido) {
		System.out.print("Codigo da conferencia: " + tipo + ".");
		System.out.println("Descricao: "+ apelido + ".");
		
	}

	@Override
	public String getTipo() {
		return "Conferencia";
	}

	public void verFuncao() {
		System.out.println("A funcao dessa sala � fazer reunioes");
		
	}

}