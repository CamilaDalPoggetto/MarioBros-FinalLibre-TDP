package GUI;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.*;
import Recursos.*;
import Logica.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;

public class Juego extends JFrame implements KeyListener{
	private Mario mario;
	private JLabel lblPuntaje = new JLabel("Puntaje: ");
	private JLabel lblDinero = new JLabel("Dinero: ");
	private JLabel lblVidas = new JLabel("Vidas: " + 3);
	private Logica logica;
	
	private int puntaje;
	public Juego(){
		getContentPane().setBackground(new Color(135, 206, 235));
		setSize(600, 450);
		mario = new Mario(10,250);
		
		iniciarMario();
		iniciarFondo();
		addKeyListener(this);
		setResizable(false);
		setVisible(true);
		puntaje = 0;
		
	}
	public void setLogica(Logica logica) {
		this.logica = logica;
	}
	private void iniciarFondo() {
		JLabel lblLadrillos = new JLabel();
		lblLadrillos.setBounds(0, 339, 586, 88);
		lblLadrillos.setIcon(new ImageIcon("Ladrillos.png"));
		getContentPane().add(lblLadrillos);
		
		
		lblPuntaje.setBounds(192, 10, 145, 13);
		getContentPane().add(lblPuntaje);
		lblDinero.setBounds(392, 10, 145, 13);
		getContentPane().add(lblDinero);
		lblVidas.setBounds(10, 10, 145, 13);
		getContentPane().add(lblVidas);
		
		/*JLabel lblFondo = new JLabel();
		lblFondo.setIcon(new ImageIcon("FondoPrincipal.jpg"));
		lblFondo.setBounds(0, 0, 600, 450);
		getContentPane().add(lblFondo);
		*/
	}
	private void iniciarMario() {
		getContentPane().setLayout(null);
		
		mario.getLabel().setBounds(10, 250, 91, 111);
		getContentPane().add(mario.getLabel());
		mario.getRectangulo().setBounds(mario.getLabel().getBounds());
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getExtendedKeyCode() == KeyEvent.VK_UP) {
			mario.saltar();
			logica.chequearColisiones();
		}else if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
			mario.avanzar();
		}else if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
			mario.retroceder();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getExtendedKeyCode() == KeyEvent.VK_UP) {
			mario.bajar();
		}
	}

	public void ponerBloque(Bloque b) {
		getContentPane().add(b.getLabel());
		repaint();
	}
	
	public void setLabelPuntaje(int pun) {
		puntaje+=pun;
		lblPuntaje.setText("Puntaje: " + puntaje);
		
	}
	public void setLabelVidas() {
		lblVidas.setText("Vidas: " + mario.getVidas());
	}
	
	public void moverEnemigos(Enemigo e) {
		getContentPane().add(e.getLabel());
	}
	public void ponerEnemigo(Enemigo e) {
		//e.getLabel().setBounds(610, 200, 45, 40);
		getContentPane().add(e.getLabel());
		System.out.println("puse un enemigo con coordenada: " + e.getLabel().getBounds());
		repaint();
	}

	public Mario getMario() {
		return mario;
	}
}
