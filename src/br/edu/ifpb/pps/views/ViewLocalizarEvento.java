package br.edu.ifpb.pps.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.border.EtchedBorder;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import br.edu.ifpb.pps.controllers.ControladorEvento;
import br.edu.ifpb.pps.models.Evento;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewLocalizarEvento extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusca;
	private JTextField txtInicio;
	private JTextField txtNome;
	private JTextField txtFim;
	private JTextField txtContato;
	private DateFormat format;


	/**
	 * Create the frame.
	 */
	public ViewLocalizarEvento() {
		setTitle("Buscar Evento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), 
				"Busca de Evento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 6, 290, 58);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("Busca:");
		label_1.setBounds(16, 30, 85, 16);
		panel.add(label_1);
		
		txtBusca = new JTextField();
		txtBusca.setColumns(10);
		txtBusca.setBounds(102, 24, 165, 28);
		panel.add(txtBusca);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Evento Encontrado", 
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(6, 67, 290, 172);
		contentPane.add(panel_1);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(16, 27, 85, 16);
		panel_1.add(lblNome);
		
		JLabel lblDataInicio = new JLabel("Data Inicio:");
		lblDataInicio.setBounds(16, 95, 85, 16);
		panel_1.add(lblDataInicio);
		
		txtInicio = new JTextField();
		txtInicio.setEnabled(false);
		txtInicio.setEditable(false);
		txtInicio.setColumns(10);
		txtInicio.setBounds(102, 89, 165, 28);
		panel_1.add(txtInicio);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(102, 21, 165, 28);
		panel_1.add(txtNome);
		
		JLabel lblDataFim = new JLabel("Data Fim:");
		lblDataFim.setBounds(16, 129, 85, 16);
		panel_1.add(lblDataFim);
		
		txtFim = new JTextField();
		txtFim.setEnabled(false);
		txtFim.setEditable(false);
		txtFim.setColumns(10);
		txtFim.setBounds(102, 123, 165, 28);
		panel_1.add(txtFim);
		
		txtContato = new JTextField();
		txtContato.setEnabled(false);
		txtContato.setEditable(false);
		txtContato.setColumns(10);
		txtContato.setBounds(102, 55, 165, 28);
		panel_1.add(txtContato);
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setBounds(16, 61, 85, 16);
		panel_1.add(lblContato);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnVoltar.setBounds(179, 243, 117, 29);
		contentPane.add(btnVoltar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Evento ev = null;
				try {
					ev = ControladorEvento.localizarEventoDataFim(txtBusca.getText());
				} catch (ParseException e1) {}
				
				if(ev==null){
					try {
						System.out.println("1");
						ev = ControladorEvento.localizarEventoDataInicial(txtBusca.getText());
					} catch (ParseException e1) {}
				}
				
				if(ev==null){
					ev = ControladorEvento.localizaEventoParteDoNome(txtBusca.getText());
					System.out.println("2");
				}
				if(ev == null){
					JOptionPane.showMessageDialog(null, "Evento nao localizado!");
					closeWindow();
					return;
				}
				format = new SimpleDateFormat("dd/MM/yyyy");
				txtNome.setText(ev.getNome());
				txtContato.setText(ev.getContato());
				Date dt = ev.getDataInicio();
				txtInicio.setText(format.format(dt));
				dt = ev.getDataFim();
				txtFim.setText(format.format(dt));
			}
		});
		btnBuscar.setBounds(6, 243, 117, 29);
		contentPane.add(btnBuscar);
	}
	
	private void closeWindow(){
		AplicacaoGrafica.getInstance().setLocationRelativeTo(ViewLocalizarEvento.this);
		AplicacaoGrafica.getInstance().setVisible(true);
		ViewLocalizarEvento.this.dispose();
	}
}
