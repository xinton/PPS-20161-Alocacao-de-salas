package br.edu.ifpb.pps.models;

import java.util.Map;

import br.edu.ifpb.pps.models.interfaces.TipoSala;

public class Aula implements TipoSala{
	private Map<TipoMaterial,Integer> materiais;
	/**
	 * @author João Paulo
	 */
	public Aula(){
		materiais.put(TipoMaterial.CADEIRA, 20 );
		materiais.put(TipoMaterial.MESA, 1 );
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
		System.out.print("Codigo da sala de aula: " + tipo + ".");
		System.out.println("Descricao: "+ apelido + ".");
	}

	@Override
	public String getTipo() {
		return "Aula";
	}
	public void verFuncao() {
		System.out.println("A funcao dessa sala e dar aula");
		
	}
}