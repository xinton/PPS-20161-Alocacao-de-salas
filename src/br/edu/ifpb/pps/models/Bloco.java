package br.edu.ifpb.pps.models;

import java.util.List;


import br.edu.ifpb.pps.models.interfaces.Pavimento;

/**
 * @author João Paulo
 */
public class Bloco extends Pavimento{
 List<Pavimento> pavimentos;
 
 public Bloco(String id){
	 super(id);
 }
 
 public void adicionar(Pavimento novoPavimento) throws Exception {
     pavimentos.add(novoPavimento);
 }

 public void remover(Pavimento pavimento) throws Exception {
     this.pavimentos.remove(pavimento);
 }

 public Pavimento getArquivo(String id) throws Exception {
	 for (Pavimento pav : pavimentos) {
         if (pav.getId() == id) {
             return pav;
         }
     }
     throw new Exception("Não existe este pavimento");
 }
}
