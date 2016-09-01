package br.edu.ifpb.pps.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.edu.ifpb.pps.controllers.ControladorSala;
import br.edu.ifpb.pps.models.Sala;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ViewRemoverSala extends JFrame {

	private JPanel contentPane;
	private JComboBox cbxSalas;
	private JTextField txtCapacidade;
	private JTextField txtApelido;
	private JTextField txtTipo;
	private List<Sala> salas = new ArrayList<Sala>();


	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public ViewRemoverSala() {
		setTitle("Remover Sala");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Salas Cadastradas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 26, 290, 211);
		contentPane.add(panel);
		
		JLabel lblSala = new JLabel("Sala:");
		lblSala.setBounds(16, 27, 85, 16);
		panel.add(lblSala);
		
		cbxSalas = new JComboBox();
		cbxSalas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Sala s = salas.get(cbxSalas.getSelectedIndex());
				txtApelido.setText(s.getApelido());
				txtCapacidade.setText(""+s.getCapacidade());
				txtTipo.setText(s.getApelido());
			}
		});
		cbxSalas.setBounds(94, 23, 179, 27);
		panel.add(cbxSalas);
		
		JLabel lblApelido = new JLabel("Apelido:");
		lblApelido.setBounds(16, 60, 61, 16);
		panel.add(lblApelido);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(16, 100, 61, 16);
		panel.add(lblTipo);
		
		JLabel lblCapacidade = new JLabel("Capacidade:");
		lblCapacidade.setBounds(16, 138, 85, 16);
		panel.add(lblCapacidade);
		
		txtCapacidade = new JTextField();
		txtCapacidade.setBounds(94, 132, 179, 28);
		panel.add(txtCapacidade);
		txtCapacidade.setColumns(10);
		
		txtApelido = new JTextField();
		txtApelido.setColumns(10);
		txtApelido.setBounds(94, 54, 179, 28);
		panel.add(txtApelido);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(94, 94, 179, 28);
		panel.add(txtTipo);
		
		JButton btnRemoverSala = new JButton("Remover Sala");
		btnRemoverSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorSala.removerSala(salas.get(cbxSalas.getSelectedIndex()).getId());
				JOptionPane.showMessageDialog(null, "Sala Removida com sucesso!");
				closeWindow();
			}
		});
		btnRemoverSala.setBounds(6, 243, 144, 29);
		contentPane.add(btnRemoverSala);
		
		JButton button_1 = new JButton("Voltar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		button_1.setBounds(179, 243, 117, 29);
		contentPane.add(button_1);
		
		populate();
		if(salas.size() == 0)
			btnRemoverSala.setEnabled(false);
	}

	@SuppressWarnings("unchecked")
	private void populate(){
		if(salas.size() ==0){
			salas = ControladorSala.getSalas();
			for(Sala s:salas)
				cbxSalas.addItem(s.getId());			
		}
	}
	
	private void closeWindow(){
		AplicacaoGrafica.getInstance().setLocationRelativeTo(ViewRemoverSala.this);
		AplicacaoGrafica.getInstance().setVisible(true);
		ViewRemoverSala.this.dispose();
	}
}
