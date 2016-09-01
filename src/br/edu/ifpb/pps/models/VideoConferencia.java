package br.edu.ifpb.pps.models;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifpb.pps.models.interfaces.TipoSala;
/**
 * @author João Paulo
 */
public class VideoConferencia implements TipoSala{
	private Map<TipoMaterial,Integer> materiais = new HashMap<>();
	
	public VideoConferencia(){
		materiais.put(TipoMaterial.CADEIRA, 10 );
		materiais.put(TipoMaterial.MESA, 1 );
		materiais.put(TipoMaterial.PROJETOR, 1 );
		materiais.put(TipoMaterial.COMPUTADOR, 5 );
	}
	
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
		System.out.print("Codigo do local da video conferencia: " + tipo + ".");
		System.out.println("Descricao: "+ apelido + ".");
	}

	@Override
	public String getTipo() {
		return "Video Conferencia";
	}
	
	@Override
	public void verFuncao() {
		System.out.println("A função dessa sala é fazer reuniões em grande distâncias");
		
	}
	
}