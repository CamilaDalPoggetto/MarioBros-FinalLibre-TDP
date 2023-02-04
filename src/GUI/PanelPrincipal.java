package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Hilos.HiloBloques;
import Hilos.HiloMovimiento;

public class PanelPrincipal extends JFrame{
	private JButton btnJugar;
	private JLabel lblFondo;
	
	public PanelPrincipal() {
		super("MarioBros");
		setSize(600, 450);
		
		btnJugar = new JButton("Jugar");
		btnJugar.setIcon(new ImageIcon("BotonJugar.png"));
		btnJugar.setBounds(365, 259, 90, 32);
		
		lblFondo = new JLabel();
		lblFondo.setBounds(0, 407, 585, -407);
		lblFondo.setIcon(new ImageIcon("FondoPrincipal.jpg"));
		
		getContentPane().add(btnJugar);
		
		getContentPane().add(lblFondo);

		setVisible(true);
		init();
	}
	private void init() {
		btnJugar.addActionListener(new OyenteJugar());
	}
	
	class OyenteJugar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			Juego juego = new Juego();
			HiloBloques hiloBloques = new HiloBloques(juego);
			hiloBloques.start();
			HiloMovimiento hiloMovimiento = new HiloMovimiento(juego);
			hiloMovimiento.start();
		}
	}
	
}

