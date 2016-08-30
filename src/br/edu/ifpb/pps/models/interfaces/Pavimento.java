package br.edu.ifpb.pps.models.interfaces;
/**
 * @author João Paulo
 */
public abstract class Pavimento {
	String id;

	
	public Pavimento(String id){
		this.id=id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void adicionar(Pavimento novoPavimento) throws Exception {
        throw new Exception("Não pode inserir sala em: "
                + this.id + " - Não é um bloco");
    }
 
    public void remover(Pavimento pavimento) throws Exception {
        throw new Exception("Não pode remover sala em: "
                + this.id + " -Não é um bloco");
    }
 
    public Pavimento getPavimento(String id) throws Exception {
        throw new Exception("Não pode pesquisar sala em: "
        		+ this.id + " -Não é um bloco");
    }
}
