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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import br.edu.ifpb.pps.controllers.ControladorEvento;
import br.edu.ifpb.pps.controllers.ControladorSala;
import br.edu.ifpb.pps.models.Evento;
import br.edu.ifpb.pps.models.Sala;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewAlocarEvento extends JFrame {

	private JPanel contentPane;
	private List<Evento> eventos = new ArrayList<Evento>();
	private List<Sala> salas = new ArrayList<Sala>();
	private JComboBox cbxSalas;
	private JComboBox cbxEventos;
	


	/**
	 * Create the frame.
	 */
	public ViewAlocarEvento() {
		setTitle("Alocar Evento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Eventos nao Alocados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 6, 290, 63);
		contentPane.add(panel);
		
		JLabel lblEvento = new JLabel("Evento:");
		lblEvento.setBounds(16, 27, 85, 16);
		panel.add(lblEvento);
		
		cbxEventos = new JComboBox();
		cbxEventos.setBounds(102, 23, 165, 27);
		panel.add(cbxEventos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Sala Para o Evento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(6, 112, 290, 63);
		contentPane.add(panel_1);
		
		JLabel lblSala = new JLabel("Sala:");
		lblSala.setBounds(16, 27, 85, 16);
		panel_1.add(lblSala);
		
		cbxSalas = new JComboBox();
		cbxSalas.setBounds(102, 23, 165, 27);
		panel_1.add(cbxSalas);
		
		JButton btnAlocar = new JButton("Alocar");
		btnAlocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Evento ev = eventos.get(cbxEventos.getSelectedIndex());
				Sala sa = salas.get(cbxSalas.getSelectedIndex());
				ControladorEvento.alocarEvento(sa, ev);
				JOptionPane.showMessageDialog(null, "Evento Alocado com sucesso!");
				closeWindow();
			}
		});
		btnAlocar.setBounds(6, 243, 117, 29);
		contentPane.add(btnAlocar);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnCancelar.setBounds(177, 243, 117, 29);
		contentPane.add(btnCancelar);
		
		JLabel label = new JLabel("|");
		label.setBounds(140, 77, 22, 16);
		contentPane.add(label);
		
		JLabel lblV = new JLabel("V");
		lblV.setBounds(138, 93, 22, 16);
		contentPane.add(lblV);
		
		populate();
		if(cbxSalas.getItemCount()==0 || cbxEventos.getItemCount()==0)
			btnAlocar.setEnabled(false);
	}
	
	private void closeWindow(){
		AplicacaoGrafica.getInstance().setLocationRelativeTo(ViewAlocarEvento.this);
		AplicacaoGrafica.getInstance().setVisible(true);
		ViewAlocarEvento.this.dispose();
	}
	
	private void populate(){
		salas.clear();
		eventos.clear();
		List<Evento> eventosAux = ControladorEvento.getEventos();
		salas = ControladorSala.getSalas();
		for(Sala s:salas)
			cbxSalas.addItem(s.getId());
		for(Evento e:eventosAux){
			if(e.getNumeroDeSalas()==0){
				eventos.add(e);
				cbxEventos.addItem(e.getNome());
			}
		}
	}

}
