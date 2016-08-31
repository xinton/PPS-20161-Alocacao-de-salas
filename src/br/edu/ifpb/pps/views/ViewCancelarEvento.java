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

import br.edu.ifpb.pps.controllers.ControladorEvento;
import br.edu.ifpb.pps.controllers.ControladorSala;
import br.edu.ifpb.pps.models.Evento;
import br.edu.ifpb.pps.models.Sala;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ViewCancelarEvento extends JFrame {

	private JPanel contentPane;
	private JComboBox cbxEvento;
	private JTextField txtInicio;
	private JTextField txtContato;
	private JTextField txtFim;
	private List<Evento> eventos = new ArrayList<Evento>();
	private DateFormat format;

	

	/**
	 * Create the frame.
	 */
	public ViewCancelarEvento() {
		setTitle("Cancelar Evento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Eventos Marcados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 26, 290, 205);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Evento:");
		label.setBounds(16, 27, 61, 16);
		panel.add(label);
		
		cbxEvento = new JComboBox();
		cbxEvento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				format = new SimpleDateFormat("dd/MM/yyyy");
				populate();
				Evento ev = eventos.get(cbxEvento.getSelectedIndex());
				Date dt = ev.getDataInicio();
				txtInicio.setText(format.format(dt));
				dt = ev.getDataFim();
				txtFim.setText(format.format(dt));
				txtContato.setText(ev.getContato());
			}
		});
		
		cbxEvento.setBounds(78, 23, 206, 27);
		panel.add(cbxEvento);
		
		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setBounds(16, 61, 61, 16);
		panel.add(lblInicio);
		
		JLabel lblFim = new JLabel("Fim:");
		lblFim.setBounds(16, 102, 61, 16);
		panel.add(lblFim);
		
		JLabel lblContato = new JLabel("Contato:");
		lblContato.setBounds(16, 141, 61, 16);
		panel.add(lblContato);
		
		txtInicio = new JTextField();
		txtInicio.setEditable(false);
		txtInicio.setBounds(78, 55, 206, 28);
		panel.add(txtInicio);
		txtInicio.setColumns(10);
		
		txtContato = new JTextField();
		txtContato.setEditable(false);
		txtContato.setColumns(10);
		txtContato.setBounds(78, 135, 206, 28);
		panel.add(txtContato);
		
		txtFim = new JTextField();
		txtFim.setEditable(false);
		txtFim.setColumns(10);
		txtFim.setBounds(78, 96, 206, 28);
		panel.add(txtFim);
		
		JButton btnCancelarEvento = new JButton("Cancelar Evento");
		btnCancelarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Evento ev = eventos.get(cbxEvento.getSelectedIndex());
				try {
					ControladorEvento.cancelarEvento(ev.getNome());
					JOptionPane.showMessageDialog(null, "Evento cancelado com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Evento nao encontrado!");
				}
				closeWindow();
			}
		});
		btnCancelarEvento.setBounds(6, 243, 144, 29);
		contentPane.add(btnCancelarEvento);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicacaoGrafica.getInstance().setLocationRelativeTo(ViewCancelarEvento.this);
				AplicacaoGrafica.getInstance().setVisible(true);
				ViewCancelarEvento.this.dispose();
			}
		});
		btnVoltar.setBounds(179, 243, 117, 29);
		contentPane.add(btnVoltar);
		
		populate();
		if(cbxEvento.getItemCount()==0)
			btnCancelarEvento.setEnabled(false);
	}
	private void closeWindow() {
		AplicacaoGrafica.getInstance().setLocationRelativeTo(ViewCancelarEvento.this);
		AplicacaoGrafica.getInstance().setVisible(true);
		ViewCancelarEvento.this.dispose();
	}
	private void populate(){
		if(eventos.size()==0){
			eventos = ControladorEvento.getEventos();
			for(Evento e:eventos){
				cbxEvento.addItem(e.getNome());
			}
		}
	}
	
}
