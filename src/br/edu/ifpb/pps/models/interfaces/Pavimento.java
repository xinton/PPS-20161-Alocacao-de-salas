package br.edu.ifpb.pps.models.interfaces;
/**
 * @author Jo�o Paulo
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
        throw new Exception("N�o pode inserir sala em: "
                + this.id + " - N�o � um bloco");
    }
 
    public void remover(Pavimento pavimento) throws Exception {
        throw new Exception("N�o pode remover sala em: "
                + this.id + " -N�o � um bloco");
    }
 
    public Pavimento getPavimento(String id) throws Exception {
        throw new Exception("N�o pode pesquisar sala em: "
        		+ this.id + " -N�o � um bloco");
    }
}
