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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;

import br.edu.ifpb.pps.controllers.ControladorEvento;
import br.edu.ifpb.pps.models.Evento;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ViewDesalocarEvento extends JFrame {

	private JPanel contentPane;
	private JTextField txtInicio;
	private JTextField txtContato;
	private JTextField txtFim;
	private JComboBox cbxEvento;
	private DateFormat format;
	private List<Evento> eventos = new ArrayList<Evento>();

	
	/**
	 * Create the frame.
	 */
	public ViewDesalocarEvento() {
		setTitle("Desalocar Evento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDesalocar = new JButton("Desalocar");
		btnDesalocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Evento ev = eventos.get(cbxEvento.getSelectedIndex());
					try {
						ControladorEvento.desalocarEvento(ev);
						JOptionPane.showMessageDialog(null, "Evento desalocado com sucesso!");
						closeWindow();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Evento Nao existente!");
				}
			}
		});
		btnDesalocar.setBounds(6, 243, 117, 29);
		contentPane.add(btnDesalocar);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnCancelar.setBounds(179, 243, 117, 29);
		contentPane.add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Eventos Alocados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 20, 290, 205);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Evento:");
		label.setBounds(16, 27, 61, 16);
		panel.add(label);
		
		cbxEvento = new JComboBox();
		cbxEvento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				format = new SimpleDateFormat("dd/MM/yyyy");
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
		
		JLabel label_1 = new JLabel("Inicio:");
		label_1.setBounds(16, 61, 61, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Fim:");
		label_2.setBounds(16, 102, 61, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Contato:");
		label_3.setBounds(16, 141, 61, 16);
		panel.add(label_3);
		
		txtInicio = new JTextField();
		txtInicio.setEditable(false);
		txtInicio.setColumns(10);
		txtInicio.setBounds(78, 55, 206, 28);
		panel.add(txtInicio);
		
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
		
		populate();
		if(cbxEvento.getItemCount()==0)
			btnDesalocar.setEnabled(false);
	}
	
	private void closeWindow(){
		AplicacaoGrafica.getInstance().setLocationRelativeTo(ViewDesalocarEvento.this);
		AplicacaoGrafica.getInstance().setVisible(true);
		ViewDesalocarEvento.this.dispose();
	}
	
	private void populate(){
		eventos.clear();
		List<Evento> eventosAux = ControladorEvento.getEventos();
		for(Evento e:eventosAux){
			if(e.getNumeroDeSalas()!=0){
				eventos.add(e);
			 	cbxEvento.addItem(e.getNome());
			}
		}
	}
}
