package br.edu.ifpb.pps.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

import br.edu.ifpb.pps.controllers.ControladorSala;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class ViewNovaSala extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdSala;
	private JTextField txtApelido;


	/**
	 * Create the frame.
	 */
	public ViewNovaSala() {
		setTitle("Nova Sala");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacoes da Sala", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 6, 288, 216);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(16, 27, 25, 16);
		panel.add(lblNewLabel);
		
		JLabel lblApelido = new JLabel("Apelido:");
		lblApelido.setBounds(16, 61, 61, 16);
		panel.add(lblApelido);
		
		JLabel lblCapacidade = new JLabel("Cap.:");
		lblCapacidade.setBounds(16, 95, 85, 16);
		panel.add(lblCapacidade);
		
		JLabel lblTipoDeSala = new JLabel("Tipo de Sala:");
		lblTipoDeSala.setBounds(16, 135, 96, 16);
		panel.add(lblTipoDeSala);
		
		txtIdSala = new JTextField();
		txtIdSala.setBounds(102, 21, 165, 28);
		panel.add(txtIdSala);
		txtIdSala.setColumns(10);
		
		txtApelido = new JTextField();
		txtApelido.setColumns(10);
		txtApelido.setBounds(102, 55, 165, 28);
		panel.add(txtApelido);
		
		JSpinner spnCapacidade = new JSpinner();
		spnCapacidade.setBounds(102, 89, 165, 28);
		panel.add(spnCapacidade);
		
		JComboBox cbxTipo = new JComboBox();
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Aula", "Laboratorio", "Conferencia", "VideoConferencia"}));
		cbxTipo.setBounds(102, 131, 165, 27);
		panel.add(cbxTipo);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String salaId = txtIdSala.getText();
				String salaApelido = txtApelido.getText();
				int salaCapacidade = (int) spnCapacidade.getValue();
				int tipoSala = cbxTipo.getSelectedIndex()+1;
				ControladorSala.adicionarSala(salaId, salaApelido, salaCapacidade, tipoSala);
				JOptionPane.showMessageDialog(null, "Sala "+salaId+" adicionada com sucesso!");
				closeWindow();
			}
		});
		btnAdicionar.setBounds(6, 243, 117, 29);
		contentPane.add(btnAdicionar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnCancelar.setBounds(177, 243, 117, 29);
		contentPane.add(btnCancelar);
	}
	
	private void closeWindow(){
		AplicacaoGrafica.getInstance().setLocationRelativeTo(ViewNovaSala.this);
		AplicacaoGrafica.getInstance().setVisible(true);
		ViewNovaSala.this.dispose();
	}
}
