package br.edu.ifpb.pps.models.interfaces;
/**
 * @author João Paulo
 */
import br.edu.ifpb.pps.models.TipoMaterial;

public interface TipoSala {
	public void verMaterais();
	public void adcionarMateriais(TipoMaterial material, int quantidade);
	public void removerMaterial(TipoMaterial material, int quantidade);
	public void verFuncao();
}
