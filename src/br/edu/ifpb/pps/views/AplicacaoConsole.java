package br.edu.ifpb.pps.views;

import java.util.Date;
import java.util.Scanner;

import br.edu.ifpb.pps.controllers.ControladorEvento;
import br.edu.ifpb.pps.controllers.ControladorSala;


public class AplicacaoConsole {

	private static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		AplicacaoConsole app = new AplicacaoConsole();
		app.startVariables();
		app.printaMenu();
	}
	
	private void startVariables(){
		
	}

	private void printaMenu(){
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
	
	private void selecionaItemDoMenu(){
		System.out.print("Digite uma Opção: ");
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
			case 8: { System.out.println("Fechando a Aplicação!"); System.exit(0); }
			default:{ System.out.println("Seleção inválida, tente novamente!"); selecionaItemDoMenu(); break; }
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
		System.out.println  ("Tipos de sala: 1.AULA | 2.LABORATÓRIO | 3.CONFERÊNCIA | 4.VIDEOCONFÊRENCIA");
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
		System.out.print  ("Repetições semanias do evento: ");
		int repeticoes = scanner.nextInt();
		scanner.nextLine();
		
		ControladorEvento.adicionarEvento(nomeEvento, dataInicio, dataFim, contato, repeticoes);
	}
	
	private void alocarEvento(){
		System.out.println("------------------------------ Alocar Evento ----------------------------------");
	}
	
	private void localizarEvento(){
		System.out.println("---------------------------- Localizar Evento ---------------------------------");
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





