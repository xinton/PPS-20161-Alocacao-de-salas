package br.edu.ifpb.pps.views;


import java.awt.EventQueue;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.edu.ifpb.pps.controllers.ControladorEvento;
import br.edu.ifpb.pps.controllers.ControladorSala;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AplicacaoGrafica extends JFrame {

	private JPanel contentPane;
	private static AplicacaoGrafica instance;
	private JTextField salasNum;
	private JTextField eventosNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		if(instance == null)
			instance = new AplicacaoGrafica();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacaoGrafica frame = new AplicacaoGrafica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		instance.inicializacaoDeDebug();
	}
	
	@SuppressWarnings("unused")
	private void inicializacaoDeDebug(){
		ControladorSala.adicionarSala("Sala 01","sl01", 1, 1);
		ControladorSala.adicionarSala("Laboratorio 01", "lb01", 2, 2);
		ControladorSala.adicionarSala("Laboratorio 02", "lb02", 3, 2);
		
		ControladorEvento.adicionarEvento("PHP", new Date(), new Date(), "Matheus Mayer", 1);
		ControladorEvento.adicionarEvento("C#", new Date(), new Date(), "Pedro Paiva", 2);
		ControladorEvento.adicionarEvento("Firebase", new Date(), new Date(), "Joao Paulo", 3);
		ControladorEvento.adicionarEvento("UNITY", new Date(), new Date(), "Diego Carvalho", 4);
		ControladorEvento.adicionarEvento("Photoshop", new Date(), new Date(), "Washington Bruno", 5);
	}

	/**
	 * Create the frame.
	 */
	public AplicacaoGrafica() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				salasNum.setText(""+ControladorSala.getSalas().size());
				eventosNum.setText(""+ControladorEvento.getEventos().size());
			}
		});
		setTitle("Alocacao de salas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Salas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 44, 286, 59);
		contentPane.add(panel);
		
		JButton btnRemoverSala = new JButton("Remover Sala");
		btnRemoverSala.setBounds(145, 24, 133, 29);
		btnRemoverSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicacaoGrafica.this.setVisible(false);
				ViewRemoverSala v = new ViewRemoverSala();
				v.setLocationRelativeTo(AplicacaoGrafica.this);
				v.setVisible(true);
			}
		});
		panel.setLayout(null);
		panel.add(btnRemoverSala);
		
		JButton btnAdicionarSala = new JButton("Adicionar Sala");
		btnAdicionarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicacaoGrafica.this.setVisible(false);
				ViewNovaSala v = new ViewNovaSala();
				v.setLocationRelativeTo(AplicacaoGrafica.this);
				v.setVisible(true);
			}
		});
		btnAdicionarSala.setBounds(6, 24, 133, 29);
		panel.add(btnAdicionarSala);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Eventos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(6, 106, 286, 125);
		contentPane.add(panel_1);
		
		JButton btnLocalizarEvento = new JButton("Localizar Evento");
		btnLocalizarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicacaoGrafica.this.setVisible(false);
				ViewLocalizarEvento v = new ViewLocalizarEvento();
				v.setLocationRelativeTo(AplicacaoGrafica.this);
				v.setVisible(true);
			}
		});
		btnLocalizarEvento.setBounds(6, 88, 133, 29);
		panel_1.add(btnLocalizarEvento);
		
		JButton btnAdicionarEvento = new JButton("Adicionar Evento");
		btnAdicionarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicacaoGrafica.this.setVisible(false);
				ViewNovoEvento v = new ViewNovoEvento();
				v.setLocationRelativeTo(AplicacaoGrafica.this);
				v.setVisible(true);
			}
		});
		btnAdicionarEvento.setBounds(6, 24, 133, 29);
		panel_1.add(btnAdicionarEvento);
		
		JButton btnDesalocarEvento = new JButton("Desalocar Evento");
		btnDesalocarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicacaoGrafica.this.setVisible(false);
				ViewDesalocarEvento v = new ViewDesalocarEvento();
				v.setLocationRelativeTo(AplicacaoGrafica.this);
				v.setVisible(true);
			}
		});
		btnDesalocarEvento.setBounds(147, 57, 133, 29);
		panel_1.add(btnDesalocarEvento);
		
		JButton btnCancelarEvento = new JButton("Cancelar Evento");
		btnCancelarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicacaoGrafica.this.setVisible(false);
				ViewCancelarEvento v = new ViewCancelarEvento();
				v.setLocationRelativeTo(AplicacaoGrafica.this);
				v.setVisible(true);
			}
		});
		btnCancelarEvento.setBounds(147, 24, 133, 29);
		panel_1.add(btnCancelarEvento);
		
		JButton btnAlocarEvento = new JButton("Alocar Evento");
		btnAlocarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicacaoGrafica.this.setVisible(false);
				ViewAlocarEvento v = new ViewAlocarEvento();
				v.setLocationRelativeTo(AplicacaoGrafica.this);
				v.setVisible(true);
			}
		});
		btnAlocarEvento.setBounds(6, 57, 133, 29);
		panel_1.add(btnAlocarEvento);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(6, 233, 286, 39);
		contentPane.add(btnSair);
		
		JLabel lblNSalas = new JLabel("Salas:");
		lblNSalas.setBounds(6, 16, 50, 16);
		contentPane.add(lblNSalas);
		
		JLabel lblEventos = new JLabel("Eventos:");
		lblEventos.setBounds(169, 16, 61, 16);
		contentPane.add(lblEventos);
		
		salasNum = new JTextField();
		salasNum.setEditable(false);
		salasNum.setBounds(57, 10, 50, 28);
		contentPane.add(salasNum);
		salasNum.setColumns(10);
		
		eventosNum = new JTextField();
		eventosNum.setEditable(false);
		eventosNum.setColumns(10);
		eventosNum.setBounds(242, 10, 50, 28);
		contentPane.add(eventosNum);
	}
	
	public static AplicacaoGrafica getInstance(){
		return instance;
	}
}
