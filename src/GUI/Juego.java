package GUI;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.*;
import Recursos.*;
import Logica.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;

public class Juego extends JFrame implements KeyListener{
	private Mario mario;
	private Nivel nivel;
	private JLabel lblMario;
	
	public Juego(){
		getContentPane().setBackground(new Color(135, 206, 235));
		setSize(600, 450);

		mario = new Mario(10,250);
		nivel = new Nivel(1);
		iniciarMario();
		iniciarFondo();
		addKeyListener(this);
		
		setVisible(true);
		//ponerBloque();
	}
	
	private void iniciarFondo() {
		JLabel lblLadrillos = new JLabel();
		lblLadrillos.setBounds(0, 339, 586, 88);
		lblLadrillos.setIcon(new ImageIcon("Ladrillos.png"));
		getContentPane().add(lblLadrillos);
		
		/*JLabel lblFondo = new JLabel();
		lblFondo.setIcon(new ImageIcon("FondoPrincipal.jpg"));
		lblFondo.setBounds(0, 0, 600, 450);
		getContentPane().add(lblFondo);
		*/
	}
	private void iniciarMario() {
		getContentPane().setLayout(null);
		
		lblMario = new JLabel();
		lblMario.setBounds(10, 250, 91, 111);
		lblMario.setIcon(new ImageIcon("Mario.png"));
		getContentPane().add(lblMario);
		mario.getRectangulo().setBounds(lblMario.getBounds());
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getExtendedKeyCode() == KeyEvent.VK_UP) {
			mario.saltar();
			lblMario.setLocation(mario.getX(), mario.getY());
			mario.getRectangulo().setBounds(lblMario.getBounds());
		}else if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
			mario.avanzar();
			lblMario.setLocation(mario.getX(), mario.getY());
			mario.getRectangulo().setBounds(lblMario.getBounds());
		}else if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
			mario.retroceder();
			mario.getRectangulo().setBounds(lblMario.getBounds());
			lblMario.setLocation(mario.getX(), mario.getY());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getExtendedKeyCode() == KeyEvent.VK_UP) {
			mario.bajar();
			lblMario.setLocation(mario.getX(), mario.getY());
			mario.getRectangulo().setBounds(lblMario.getBounds());
			
		}
	}

	public void ponerBloque(Bloque b) {
		b.getLabel().setBounds(610, 180, 45, 40);
		getContentPane().add(b.getLabel());
	}
	
	public void moverBloque() {
		for (Bloque b: nivel.getListaBloques()) {
			JLabel lblAux = b.getLabel();
			Rectangle siguienteBloque = b.getRectangulo();
			mario.chequearColisiones(siguienteBloque);
			
			lblAux.setLocation(lblAux.getX()-5, lblAux.getY());
			getContentPane().add(lblAux);
			siguienteBloque.setBounds(lblAux.getBounds());
			
		}
	}

	public Nivel getNivel() {
		return nivel;
	}
}
