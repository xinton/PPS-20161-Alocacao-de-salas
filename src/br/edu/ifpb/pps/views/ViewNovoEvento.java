package br.edu.ifpb.pps.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.text.Format;
import java.util.Date;

import javax.swing.border.EtchedBorder;

import br.edu.ifpb.pps.controllers.ControladorEvento;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewNovoEvento extends JFrame {
	private JTextField txtNome;
	private JTextField txtContato;
	private DateFormat format;



	private void closeWindow() {
		AplicacaoGrafica.getInstance().setLocationRelativeTo(ViewNovoEvento.this);
		AplicacaoGrafica.getInstance().setVisible(true);
		ViewNovoEvento.this.dispose();
	}
	
	/**
	 * Create the frame.
	 */
	public ViewNovoEvento() {
		setTitle("Novo Evento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Informacoes do Evento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 6, 288, 216);
		getContentPane().add(panel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(16, 27, 85, 16);
		panel.add(lblNome);
		
		JLabel lblDataInicio = new JLabel("Data Inicio:");
		lblDataInicio.setBounds(16, 61, 85, 16);
		panel.add(lblDataInicio);
		
		JLabel lblDataFim = new JLabel("Data Fim:");
		lblDataFim.setBounds(16, 95, 85, 16);
		panel.add(lblDataFim);
		
		JLabel lblContato = new JLabel("Contato:");
		lblContato.setBounds(16, 131, 96, 16);
		panel.add(lblContato);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(102, 21, 165, 28);
		panel.add(txtNome);
		
		txtContato = new JTextField();
		txtContato.setColumns(10);
		txtContato.setBounds(102, 125, 165, 28);
		panel.add(txtContato);
		
		JSpinner spnRepeticoes = new JSpinner();
		spnRepeticoes.setBounds(102, 157, 165, 28);
		panel.add(spnRepeticoes);
		
		JLabel lblNewLabel = new JLabel("Repeticoes:");
		lblNewLabel.setBounds(16, 163, 85, 16);
		panel.add(lblNewLabel);
		
		format = new SimpleDateFormat("dd/MM/yyyy");
		JFormattedTextField frmtDataFim = new JFormattedTextField(format);
		frmtDataFim.setText("dd/mm/aaaa");
		frmtDataFim.setToolTipText("");
		frmtDataFim.setBounds(102, 89, 165, 28);
		panel.add(frmtDataFim);
		
		JFormattedTextField frmtDataInicio = new JFormattedTextField((Format) null);
		frmtDataInicio.setToolTipText("");
		frmtDataInicio.setText("dd/mm/aaaa");
		frmtDataInicio.setBounds(102, 55, 165, 28);
		panel.add(frmtDataInicio);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeEvento = txtNome.getText();
				Date dataInicio = null;
				try {
					dataInicio = format.parse(frmtDataInicio.getText());
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Data de inicio Invalida");
				}
		        Date dataFim = null;
				try {
					dataFim = format.parse(frmtDataFim.getText());
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Data de termino Invalida");
				}
				String contato = txtContato.getText();
				int repeticoes = (int)spnRepeticoes.getValue();				
				ControladorEvento.adicionarEvento(nomeEvento, dataInicio, dataFim, contato, repeticoes);
				JOptionPane.showMessageDialog(null, "Evento "+nomeEvento+" adicionado com sucesso!");
				closeWindow();
			}
		});
		btnAdicionar.setBounds(6, 243, 117, 29);
		getContentPane().add(btnAdicionar);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnCancelar.setBounds(177, 243, 117, 29);
		getContentPane().add(btnCancelar);
	
		
	}
}

