package br.edu.ifpb.pps.models;

import java.util.Map;

import br.edu.ifpb.pps.models.interfaces.TipoSala;

/**
 * @author João Paulo
 */
public class Laboratorio implements TipoSala{

	private Map<TipoMaterial,Integer> materiais;
	public Laboratorio(){
		materiais.put(TipoMaterial.CADEIRA, 10 );
		materiais.put(TipoMaterial.MESA, 1 );
		materiais.put(TipoMaterial.EQUIPAMENTO, 10 );
		materiais.put(TipoMaterial.COMPUTADOR, 5 );
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
		System.out.print("Codigo do laboratorio: " + tipo + ".");
		System.out.println("Descrivso: "+ apelido + ".");
	public void verFuncao() {
		System.out.println("A funcao dessa sala e fazer experirncias");
		
	}

	@Override
	public String getTipo() {
		return "Laboratorio";
	}
	
}