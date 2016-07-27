package br.edu.ifpb.pps.views;

import java.awt.Event;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import br.edu.ifpb.pps.controllers.ControladorEvento;
import br.edu.ifpb.pps.controllers.ControladorSala;
import br.edu.ifpb.pps.models.Evento;
import br.edu.ifpb.pps.models.Sala;


public class AplicacaoConsole {

	private static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) throws ParseException {
		AplicacaoConsole app = new AplicacaoConsole();
		app.startVariables();
		app.printaMenu();
	}
	
	private void startVariables(){
		
	}

	private void printaMenu() throws ParseException{
		System.out.println("");
		System.out.println("###############################################################################");
		System.out.println("#                               SALAS DE EVENTOS                              #");
		System.out.println("###############################################################################");
		System.out.println("#                                    MENU                                     #");
		System.out.println("#-----------------------------------------------------------------------------#");
		System.out.println("#      1. Adicionar Sala               |      2. Adicionar Evento             #");
		System.out.println("#                                      |                                      #");
		System.out.println("#      3. Alocar Evento                |      4. Localizar Evento             #");
		System.out.println("#                                      |                                      #");
		System.out.println("#      5. Desalocar Evento             |      6. Cancelar Evento              #");
		System.out.println("#                                      |                                      #");
		System.out.println("#      7. Remover Sala                 |      8. Sair                         #");
		System.out.println("#                                      |                                      #");
		System.out.println("###############################################################################");
		System.out.println("");
		selecionaItemDoMenu();
	}
	
	private void printaSubMenuLocalizar() throws ParseException{
		System.out.println("");		
		System.out.println("########################################");
		System.out.println("#            Localizar por:            #");
		System.out.println("#--------------------------------------#");
		System.out.println("#      1. Nome			               #");
		System.out.println("#                                      #");
		System.out.println("#      2. Contado            		   #");
		System.out.println("#                                      #");
		System.out.println("#      3. Data Inicial       	       #");
		System.out.println("#                                      #");
		System.out.println("#      4. Data Final			       #");
		System.out.println("#                                      #");
		System.out.println("#      0. Voltar                       #");
		System.out.println("#                                      #");
		System.out.println("########################################");
		System.out.println("");
	}
	
	private void selecionaItemDoMenu() throws ParseException{
		System.out.print("Digite uma Op��o: ");
		int selecao = scanner.nextInt();
		scanner.nextLine();
		switch (selecao) {
			case 1: { adicionarSala();   break; }
			case 2: { adicionaEvento();  break; }
			case 3: { alocarEvento();    break; }
			case 4: { localizarEvento(); break; }
			case 5: { desalocarEvento(); break; }
			case 6: { cancelarEvento();  break; }
			case 7: { removerSala();     break; }
			case 8: { System.out.println("Fechando a Aplica��o!"); System.exit(0); }
			default:{ System.out.println("Sele��o inv�lida, tente novamente!"); selecionaItemDoMenu(); break; }
		}
		printaMenu();
	}
	
	private void adicionarSala(){
		System.out.println("----------------------------- Adicionar Sala ----------------------------------");
		System.out.print  ("Identificador da sala: ");
		String salaId = scanner.nextLine();
		System.out.print  ("Apelido da sala: ");
		String salaApelido = scanner.nextLine();
		System.out.print  ("Capacidade da sala: ");
		int salaCapacidade = scanner.nextInt();
		System.out.println  ("Tipos de sala: 1.AULA | 2.LABORAT�RIO | 3.CONFER�NCIA | 4.VIDEOCONF�RENCIA");
		int tipoSala = tipoDeSala();
		
		ControladorSala.adicionarSala(salaId, salaApelido, salaCapacidade, tipoSala);
	}
	
	private int tipoDeSala(){
		int tipo = 0;
		do{
			System.out.print  ("Escolha um tipo da sala: ");
			tipo = scanner.nextInt();
			scanner.nextLine();
		}while(tipo<1 || tipo>4);
		return tipo;
	}
	
	private void adicionaEvento(){
		System.out.println("---------------------------- Adicionar Evento ---------------------------------");
		System.out.print  ("Nome do evento: ");
		String nomeEvento = scanner.nextLine();
		System.out.print  ("Data de INICIO do evento (Aperte Enter se a data for hoje): ");
		String dataAux = scanner.nextLine();
		Date dataInicio = null;
		if(dataAux.equals(""))
			dataInicio = new Date();
		System.out.print  ("Data de FIM do evento (Aperte Enter se a data for hoje): ");
		dataAux = scanner.nextLine();
		Date dataFim = null;
		if(dataAux.equals(""))
			dataFim = new Date();
		System.out.print  ("Nome do contato para o evento: ");
		String contato = scanner.nextLine();
		System.out.print  ("Repeti��es semanias do evento: ");
		int repeticoes = scanner.nextInt();
		scanner.nextLine();
		
		ControladorEvento.adicionarEvento(nomeEvento, dataInicio, dataFim, contato, repeticoes, false);
	}
	
	private void alocarEvento(){
		ArrayList<Evento> eventos = ControladorEvento.getEventos();
		ArrayList<Sala> salas = ControladorSala.getSalas();
		System.out.println("------------------------------ Alocar Evento ----------------------------------");
		System.out.println("Lista de Eventos sem sala...");
		int count = 1;
		for(Evento evento: eventos){
			if(evento.getNumeroDeSalas()==0)
				continue;
			System.out.println("Id: "+count+" | Nome: "+evento.getNome()+" | Data Inicio: "+evento.getDataInicio()+" |");
			count++;
		}
		System.out.println("Escolha o Evento para alocar uma sala: ");
		int idEvento = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Evento "+eventos.get(idEvento).getNome()+" escolhido para alocar uma Sala.");
		System.out.println("Lista de Salas para alocar...");
		count = 1;
	}
	
	private void localizarEvento() throws ParseException{
		System.out.println("---------------------------- Localizar Evento ---------------------------------");
		printaSubMenuLocalizar();

		System.out.print("Digite uma Op��o de busca: ");
		int opLocalizar = scanner.nextInt();
		scanner.nextLine();
		Evento evento;
		switch (opLocalizar) {
        case 1:
            System.out.println("Digite o nome");
            String nome = scanner.nextLine();
            evento = ControladorEvento.localizarEventoPorNome(nome);
            if ( evento != null ) {
            	System.out.println(evento);
            } else {
            	System.out.println("Evento n�o encontrado.");
            }            
            break;
        case 2:
            System.out.println("Digite o contato");
            String contato = scanner.nextLine();
            evento = ControladorEvento.localizarEventoPeloContato(contato);
            if ( evento != null ) {
            	System.out.println(evento);
            } else {
            	System.out.println("Evento n�o encontrado.");
            }           
            break;
        case 3:
            System.out.println("Digite a data inicial");
            String dataIni = scanner.nextLine();
            evento = ControladorEvento.localizarEventoDataInicial(dataIni);
            if ( evento != null ) {
            	System.out.println(evento);
            } else {
            	System.out.println("Evento n�o encontrado.");
            }            
            break;
        case 4:
            System.out.println("Digite a data final");
            String dataFim = scanner.nextLine();
            evento = ControladorEvento.localizarEventoDataFim(dataFim);
            if ( evento != null ) {
            	System.out.println(evento);
            } else {
            	System.out.println("Evento n�o encontrado.");
            }            
            break;
        case 0:   
        	printaMenu();
            break;
        default:
             System.out.println("Este n�o � uma op��o v�lida!");
     }

	}
	
	private void desalocarEvento(){
		System.out.println("---------------------------- Desalocar Evento ---------------------------------");
		
	}
	
	private void cancelarEvento(){
		System.out.println("---------------------------- Cancelar Evento ----------------------------------");
		
	}
	
	private void removerSala(){
		System.out.println("------------------------------ Remover Sala -----------------------------------");
		
	}
}





