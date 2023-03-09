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
import java.awt.Font;

public class Juego extends JFrame implements KeyListener{
	private Mario mario;
	private JLabel lblPuntaje = new JLabel("Puntaje: ");
	//private JLabel lblVidas = new JLabel();
	private JLabel lblNivel = new JLabel("Nivel: " + 1);
	private Logica logica;
	private JLabel lblLadrillos = new JLabel();
	//private JLabel lblAtaqueMario = new JLabel();
	private JLabel lblMastil = new JLabel();
	private int puntaje;
	
	public Juego(){ 
		getContentPane().setBackground(new Color(4, 156, 216));
		setSize(600, 428);
		mario = new Mario(10,260);
		
		iniciarMario();
		iniciarFondo();
		addKeyListener(this);
		setResizable(false);
		setVisible(true);
		//setLabelVidas();
		puntaje = 0;
		
		
	}
	public void setLogica(Logica logica) {
		this.logica = logica;
	}
	private void iniciarFondo() {

		lblLadrillos.setBounds(0, 331, 586, 80);
		lblLadrillos.setIcon(new ImageIcon("Ladrillos.png"));
		getContentPane().add(lblLadrillos);
		
		lblPuntaje.setForeground(new Color(255, 255, 255));
		lblPuntaje.setFont(new Font("Rockwell Condensed", Font.BOLD, 24));
		lblPuntaje.setBounds(192, 10, 145, 23);
		getContentPane().add(lblPuntaje);
	
		/*
		lblVidas.setForeground(new Color(255, 255, 255));
		lblVidas.setFont(new Font("Rockwell Condensed", Font.BOLD, 24));
		lblVidas.setBounds(396, 10, 145, 23);
		getContentPane().add(lblVidas);*/
		lblNivel.setForeground(new Color(255, 255, 255));
		lblNivel.setFont(new Font("Rockwell Condensed", Font.BOLD, 24));
		lblNivel.setBounds(10, 9, 77, 24);
		getContentPane().add(lblNivel);
		
		
		/*JLabel lblFondo = new JLabel();
		lblFondo.setIcon(new ImageIcon("FondoPrincipal.jpg"));
		lblFondo.setBounds(0, 0, 600, 450);
		getContentPane().add(lblFondo);
		*/
	}
	private void iniciarMario() {
		getContentPane().setLayout(null);
		getContentPane().add(mario.getLabel());
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
		}else if(e.getExtendedKeyCode() == KeyEvent.VK_SPACE) {
			logica.marioAtaque();
			ataque();
			
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getExtendedKeyCode() == KeyEvent.VK_UP) {
			mario.bajar();
		}
	}
	private void ataque() {
		JLabel lblAtaqueMario = new JLabel();
		//lblAtaqueMario.setIcon(new ImageIcon("Laser.gif"));
		lblAtaqueMario.setBounds(mario.getLabel().getX()+50, mario.getLabel().getY()+50, getWidth(), 10); 
		lblAtaqueMario.setOpaque(true);
		lblAtaqueMario.setBackground(Color.red);
		getContentPane().add(lblAtaqueMario);
		
		Timer timer = new Timer(2000, evt -> {
		    lblAtaqueMario.setVisible(false);
		});
		timer.setRepeats(false);
		timer.start();
		repaint();
	}
	
	public void ponerBloque(Bloque b) {
		getContentPane().add(b.getLabel());
		repaint();
	}
	
	public void setLabelPuntaje(int pun) {
		puntaje+=pun;
		lblPuntaje.setText("Puntaje: " + puntaje);
		
	}
	/*
	public void setLabelVidas() {
		lblVidas.setText("Vidas: " + mario.getVidas());
	}
	*/
	public void moverEnemigos(Enemigo e) {
		getContentPane().add(e.getLabel());
	}
	public void ponerEnemigo(Enemigo e) {
		getContentPane().add(e.getLabel());
		repaint();
	}

	public Mario getMario() {
		return mario;
	}
	
	public boolean nextLevel() {
		boolean retorno  =false;
		
		lblMastil.setIcon(new ImageIcon("Mastil.png"));
		lblMastil.setBounds(480, 50, 45, 300);
		getContentPane().add(lblMastil);
		
		Rectangle rectanguloMastil = new Rectangle();
		rectanguloMastil.setBounds(lblMastil.getBounds());
		
		if(mario.chequearColisiones(rectanguloMastil)) {
			retorno = true;
			System.out.println("pase de nivel");
			lblNivel.setText("Nivel: " + 2);
			mario.setX(10);
			mario.setY(260);
			mario.getLabel().setBounds(mario.getX(), mario.getY(), 91, 111);
			mario.getRectangulo().setBounds(mario.getLabel().getBounds());
			lblLadrillos.setIcon(new ImageIcon("Ladrillos2.png"));
			getContentPane().remove(lblMastil);
			getContentPane().setBackground(Color.BLACK);
		}
		return retorno;
	}
	public void fin() { //limpiar la pantalla y mostrar un mensaje de ganar
		getContentPane().removeAll();
		JLabel lblThankYou = new JLabel();
		JLabel lblYouWin = new JLabel();
		
		lblThankYou.setIcon(new ImageIcon("ThankYouMario.png"));
		lblYouWin.setIcon(new ImageIcon("YouWin.png"));
		lblThankYou.setBounds(50, 100, 450, 36);
		lblYouWin.setBounds(60, 150, 450, 74);

		lblPuntaje.setBounds(100, 200, 200, 40);
		getContentPane().add(lblYouWin);
		getContentPane().add(lblThankYou);
		getContentPane().add(lblPuntaje);
		repaint();
	}
	public void gameOver() {
		//limpiar la pantalla y mostrar mensaje de game over
		getContentPane().removeAll();
		JLabel lblGameOver = new JLabel();
		lblGameOver.setIcon(new ImageIcon("GameOver.png"));
		lblGameOver.setBounds(40, 130, 510, 74);
		lblPuntaje.setBounds(100, 200, 200, 40);
		
		getContentPane().add(lblGameOver);
		getContentPane().add(lblPuntaje);
		repaint();
	}
}
