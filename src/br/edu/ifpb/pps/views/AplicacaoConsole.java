package br.edu.ifpb.pps.views;

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
	
	//#######################################################################################################
	//                                        MAIN/INICIALIZACAO
	//#######################################################################################################
	public static void main(String[] args) throws ParseException {
		AplicacaoConsole app = new AplicacaoConsole();
		app.inicializacaoDeDebug();
		app.printaMenu();
	}
	
	/**
	 * Metodo que popula a aplicacao para testes.
	 * 
	 * @author Diego Carvalho
	 * @since 26/07/2016
	 */
	//VAI SER NECESSARIA PARA APRESENTACAO
	@SuppressWarnings("unused")
	private void inicializacaoDeDebug(){
		ControladorSala.adicionarSala("Sala 01","sl01", 1, 1);
		ControladorSala.adicionarSala("Laboratorio 01", "lb01", 2, 2);
		ControladorSala.adicionarSala("Laboratorio 02", "lb02", 3, 2);
		
		ControladorEvento.adicionarEvento("Evento 01 - A arte do Deboismo", new Date(), new Date(), "Pedro Paiva", 1);
		ControladorEvento.adicionarEvento("Evento 02 - Mito do POG", new Date(), new Date(), "Matheus Mayer", 2);
		ControladorEvento.adicionarEvento("Evento 03 - Mestre do Firebase", new Date(), new Date(), "Joao Paulo", 3);
		ControladorEvento.adicionarEvento("Evento 04 - Nao vai da nao", new Date(), new Date(), "Diego Carvalho", 4);
		ControladorEvento.adicionarEvento("Evento 05 - M. Varandas Business", new Date(), new Date(), "Washington Bruno", 5);
	}

	//#######################################################################################################
	//                                              MENUS
	//#######################################################################################################
	/**
	 * Metodo que printa o menu principal da aplicacao e chama o metodo de selecao de itens deste menu.
	 * 
	 * @author Diego Carvalho
	 * @since 25/07/2016
	 * @throws ParseException
	 */
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
	
	/**
	 * Metodo que printa o sub menu de localizacao de eventos.
	 * 
	 * @author Washington Bruno
	 * @since 26/07/2016
	 * @throws ParseException
	 */
	private void printaSubMenuLocalizar() throws ParseException{
		System.out.println("");		
		System.out.println("########################################");
		System.out.println("#            Localizar por:            #");
		System.out.println("#--------------------------------------#");
		System.out.println("#      1. Nome                         #");
		System.out.println("#                                      #");
		System.out.println("#      2. Contado            	       #");
		System.out.println("#                                      #");
		System.out.println("#      3. Data Inicial                 #");
		System.out.println("#                                      #");
		System.out.println("#      4. Data Final                   #");
		System.out.println("#                                      #");
		System.out.println("#      0. Voltar                       #");
		System.out.println("#                                      #");
		System.out.println("########################################");
		System.out.println("");
	}
	
	/**
	 * Metodo que chama uma funcao da aplicacao(metodo desta classe), de acordo com o input do usuario.
	 * 
	 * @author Diego Carvalho
	 * @since 25/07/2016
	 * @throws ParseException
	 */
	private void selecionaItemDoMenu() throws ParseException{
		System.out.print("Digite uma Opcao: ");
		//int selecao = scanner.nextInt();
		//scanner.nextLine();
		String selecao = scanner.nextLine();
		
		try {
			int numeroEscolhido = Integer.parseInt(selecao);
			
			switch (numeroEscolhido) {
				case 1: { adicionarSala();   break; }
				case 2: { adicionaEvento();  break; }
				case 3: { alocarEvento();    break; }
				case 4: { localizarEvento(); break; }
				case 5: { desalocarEvento(); break; }
				case 6: { cancelarEvento();  break; }
				case 7: { removerSala();     break; }
				case 8: { System.out.println("Fechando a Aplicacao!"); System.exit(0); }
				default:{ System.out.println("Selecao invalida, tente novamente!"); selecionaItemDoMenu(); break;}
			}
		}catch(NumberFormatException e){
			System.out.println("--> Digite um numero");
		}
		printaMenu();
	}
	
	//#######################################################################################################
    //                                        METODOS FUNCIONAIS
	//#######################################################################################################
	
	/**
	 * Metodo que adiciona salas no sistema. Este metodo passa input do usuario para o controlador de salas.
	 * 
	 *  @author Diego Carvalho
	 *  @since 25/07/2016
	 */
	private void adicionarSala(){
		System.out.println("----------------------------- Adicionar Sala ----------------------------------");
		System.out.print  ("Identificador da sala: ");
		String salaId = scanner.nextLine();
		System.out.print  ("Apelido da sala: ");
		String salaApelido = scanner.nextLine();
		System.out.print  ("Capacidade da sala: ");
		int salaCapacidade = scanner.nextInt();
		System.out.println  ("Tipos de sala: 1.AULA | 2.LABORATORIO | 3.CONFERENCIA | 4.VIDEOCONFERENCIA");
		int tipoSala = tipoDeSala();
		
		ControladorSala.adicionarSala(salaId, salaApelido, salaCapacidade, tipoSala);
		System.out.println("Sala "+salaId+" adicionada com sucesso!");
	}
	
	/**
	 * Metodo que impede a entrada no sistema de tipos de salas inexistentes.
	 * 
	 * @author Diego Carvalho
	 * @since 26/07/2016
	 * @return int: tipo
	 */
	private int tipoDeSala(){
		int tipo = 0;
		do{
			System.out.print  ("Escolha um tipo da sala: ");
			tipo = scanner.nextInt();
			scanner.nextLine();
		}while(tipo<1 || tipo>4);
		return tipo;
	}
	
	/**
	 * Metodo que adiciona eventos no sistema. Este metodo passa input do usuario para o controlador de eventos.
	 * 
	 *  @author Diego Carvalho
	 *  @since 25/07/2016
	 */
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
		System.out.print  ("Repeticoes semanias do evento: ");
		int repeticoes = scanner.nextInt();
		scanner.nextLine();
		
		ControladorEvento.adicionarEvento(nomeEvento, dataInicio, dataFim, contato, repeticoes);
		System.out.print  ("Evento adicionado com sucesso!");
	}
	
	/**
	 * Metodo que aloca um evento em uma sala. Este metodo passa parmetros q sao tratados no controlador de eventos.
	 * 
	 *  @author Diego Carvalho
	 *  @since 26/07/2016
	 */
	private void alocarEvento(){
		ArrayList<Evento> eventos = new ArrayList<Evento>();
		ArrayList<Evento> eventosAux = (ArrayList<Evento>) ControladorEvento.getEventos();
		ArrayList<Sala> salas = ControladorSala.getSalas();
		Evento eventoAloc = null;
		
		//Checagem de itens na lista---------------------------------------------------------------------
		if(eventosAux.size()==0){
			System.out.println("Nao ha eventos para serem alocados!");
			return;
		}
		else if(salas.size()==0){
			System.out.println("Nao ha salas para alocar eventos!");
			return;
		}
		System.out.println("------------------------------ Alocar Evento ----------------------------------");
		
		//Listando Eventos----------------------------------------------------------------------------------
		System.out.println("Lista de Eventos sem sala...\n");
		int count = 1;
		for(Evento evento: eventosAux){
			
			eventos.add(evento);
			System.out.println("Id: "+count+" | Nome: "+evento.getNome()+" | Data Inicio: "+evento.getDataInicio()+" | Repeticoes: "+evento.getRepeticao());
			count++;
		}
		
		if(eventosAux.size()==0){
			System.out.println("Nao ha eventos para serem alocados!");
			return;
		}
		
		System.out.print("\nEscolha o Evento para alocar uma sala: ");
		int idEvento = scanner.nextInt()-1;
		scanner.nextLine();
		eventoAloc = eventos.get(idEvento);
		System.out.println("Evento escolhido: "+eventoAloc.getNome()+" foi escolhido para alocar uma Sala.\n");
		
		/* ESSA LISTAGEM DE SALAS PODERIA SER A LISTAGEM DE SALAS DISPONIVEIS!!! OU ENTAO REMOVE ESSA LISTAGEM DE SALAS
		 * SE FOR REMOVER A LISTAGEM DAS SALAS, TENTA RETORNAR UMA MENSAGEM DE SUCESSO DO CONTROLLER PRA CÃ�!
		 */
		
		//Listando Salas----------------------------------------------------------------------------------
		System.out.println("Lista de Salas para alocar...\n");
		count = 1;
		for(Sala sala: salas){
			System.out.println(" "+count+" | Nome: "+sala.getId()+" | Apelido: "+sala.getApelido()+" | Capacidade: "+sala.getCapacidade()+" | Tipo: "+sala.getTipo());
			//System.out.println("Id: "+count+" | Nome: "+sala.getId()+" | Apelido: "+sala.getApelido()+" | Capacidade: "+sala.getCapacidade()+" | Tipo: "+sala.getTipo().getClass().getName());
			count++;
		}
		System.out.print("\nEscolha a Sala para alocar um Evento: ");
		int idSala = scanner.nextInt()-1;
		scanner.nextLine();
		
		//Alocando Evento em Sala------------------------------------------------------------------------
		ControladorEvento.alocarEvento(salas.get(idSala), eventoAloc);
		System.out.println("Evento: "+eventoAloc.getNome()+" foi alocado na sala "+salas.get(idSala).getApelido() +".");
	}
	
	/**
	 * Metodo de localizacao de eventos por diversos parametros. Repassa a busca para o controlador de eventos.
	 * 
	 * @author Washington Bruno
	 * @since 26/07/2016
	 * @throws ParseException
	 */
	private void localizarEvento() throws ParseException{
		System.out.println("---------------------------- Localizar Evento ---------------------------------");
		printaSubMenuLocalizar();

		System.out.print("Digite uma opcao de busca: ");
		//int opLocalizar = scanner.nextInt();
		
		String escolha = scanner.nextLine();
		
		try{
			int numeroEscolhido = Integer.parseInt(escolha);
			

			Evento evento = null;
			switch (numeroEscolhido) {
		        case 1:
		            System.out.println("Digite o nome: ");
		            String nome = scanner.nextLine();
		            evento = ControladorEvento.localizarPorNome(nome);           
		            break;
		        case 2:
		            System.out.println("Digite o contato: ");
		            String contato = scanner.nextLine();
		            evento = ControladorEvento.localizarPorContato(contato);          
		            break;
		        case 3:
		            System.out.println("Digite a data inicial: ");
		            String dataIni = scanner.nextLine();
		            evento = ControladorEvento.localizarEventoDataInicial(dataIni);           
		            break;
		        case 4:
		            System.out.println("Digite a data final: ");
		            String dataFim = scanner.nextLine();
		            evento = ControladorEvento.localizarEventoDataFim(dataFim);            
		            break;
		        case 0:   
		        	printaMenu();
		            break;
		        default:
		             System.out.println("Este nao e uma opcao valida!");
			}
			if(evento==null){
				System.out.println("Evento nao encontrado!");
				return;
			}
			System.out.println("Evento Encontrado!");
			System.out.println("Evento: "+evento.getNome()+" | Contato: "+evento.getContato()+" | Data Inicio: "+evento.getDataInicio()+" | Repeticoes: "+evento.getRepeticao());
			
		}catch(NumberFormatException e){
			System.out.println("--> Digite um numero");
		}

	}
	
	/**
	 * Metodo que desaloca um evento de uma sala. Este metodo passa parmetros q sao tratados no controlador de eventos.
	 * 
	 *  @author Diego Carvalho
	 *  @since 26/07/2016
	 */
	private void desalocarEvento(){
		ArrayList<Evento> eventos = (ArrayList<Evento>) ControladorEvento.getEventos();
		System.out.println("---------------------------- Desalocar Evento ---------------------------------");
		System.out.println("Digite o nome do evento para desalocar");
		String eventoNome = scanner.nextLine();
		Evento evento = null;
		for(Evento ev: eventos)
			if(ev.getNome().equals(eventoNome))
				evento = ev;
		try {
			ControladorEvento.desalocarEvento(evento);
			System.out.println("Evento "+evento.getNome()+" desalocado com sucesso!");
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}
	}
	
	/**
	 * Metodo que cancela um evento, removendo o mesmo da aplicacao. Este metodo passa parmetros q sao tratados no controlador de eventos.
	 * 
	 *  @author Diego Carvalho
	 *  @since 26/07/2016
	 */
	private void cancelarEvento(){
		System.out.println("---------------------------- Cancelar Evento ----------------------------------");
		System.out.println("Digite o nome do evento para cancelar");
		String evento = scanner.nextLine();
		try {
			ControladorEvento.cancelarEvento(evento);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Evento "+evento+" cancelado com sucesso!");	
	}
	
	/**
	 * Metodo que remove salas no sistema. Este metodo passa input do usuario para o controlador de salas.
	 * 
	 *  @author Diego Carvalho
	 *  @since 25/07/2016
	 */
	private void removerSala(){
		System.out.println("------------------------------ Remover Sala -----------------------------------");
		System.out.println("Digite o nome de uma sala para remover");
		String sala = scanner.nextLine();
		try {
			ControladorSala.removerSala(sala);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Sala "+sala+" removida com sucesso!");
	}
}