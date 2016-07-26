package br.edu.ifpb.pps.models;

/**
 * Esta classe fará com que seja instaciado apenas um diretor.
 * @author Matheus Mayer
 * @since 25/07/2016
 */
public class Diretor 
{
	private static Diretor unicoDiretor;

	/**
	 * Este metodo será privado para que não haja mais de uma instancia.
	 * @author Matheus Mayer
	 * @since 25/07/2016
	 */
	private Diretor(){}
	
	/**
	 * Este metodo realiza o retorno do unico diretor existente.
	 * @author Matheus Mayer
	 * @since 25/07/2016
	 * @return Diretor unicoDiretor
	 */
	public static synchronized Diretor getInstance()
	{
		if (unicoDiretor == null) {
			unicoDiretor = new Diretor(){};
		}
		
		return unicoDiretor;
	}
}
