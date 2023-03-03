package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Hilos.*;
import Logica.Logica;
import Logica.Nivel;

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
			Nivel nivel = new Nivel();
			Logica logica = new Logica(juego, nivel);
		
			HiloBloques hiloBloques = new HiloBloques(logica);
			hiloBloques.start();
			HiloEnemigos hiloEnemigos = new HiloEnemigos(logica);
			hiloEnemigos.start();
			//HiloMovimientoE hiloMovimiento = new HiloMovimientoE(logica);
			//hiloMovimiento.start();
			
		}
	}
	
}

