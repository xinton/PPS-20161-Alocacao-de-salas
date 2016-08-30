package br.edu.ifpb.pps.models;
/**
 * @author João Paulo
 */
public enum TipoMaterial {
	CADEIRA("Cadeira"),
	EQUIPAMENTO("Equipamento"),
	COMPUTADOR("Computador"),
	MESA("Mesa"),
	PROJETOR("Projetor");
	public String material;
	
	TipoMaterial(String material){
		this.material=material;
	}
}
