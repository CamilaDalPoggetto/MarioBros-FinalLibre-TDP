package GUI;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import Recursos.*;
import Logica.*;
import java.awt.Rectangle;
import java.awt.Font;

public class Juego extends JFrame implements KeyListener{
	private Mario mario;
	private JLabel lblPuntaje = new JLabel("Puntaje: ");
	private JLabel lblNivel = new JLabel("WORLD: 1-1");
	private Logica logica;
	private JLabel lblLadrillos = new JLabel();
	private JLabel lblMastil = new JLabel();
	private JLabel lblNubes = new JLabel();
	private JLabel lblLadrillos2 = new JLabel();
	private int puntaje;
	
	public Juego(){ 
		 getContentPane().setBackground(new Color(107, 136, 254));
		
		setSize(600, 523);
		mario = new Mario(10,360);
		
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

		lblLadrillos.setBounds(0, 426, 586, 80);
		lblLadrillos.setIcon(new ImageIcon("Ladrillos.png"));
		getContentPane().add(lblLadrillos);
		
		lblPuntaje.setForeground(new Color(255, 255, 255));
		lblPuntaje.setFont(new Font("Rockwell Condensed", Font.BOLD, 24));
		lblPuntaje.setBounds(286, 10, 145, 23);
		getContentPane().add(lblPuntaje);
		
		lblNivel.setForeground(new Color(255, 255, 255));
		lblNivel.setFont(new Font("Rockwell Condensed", Font.BOLD, 24));
		lblNivel.setBounds(10, 9, 195, 24);
		getContentPane().add(lblNivel);
		
		
		lblNubes.setBounds(0, 31, 586, 95);
		lblNubes.setIcon(new ImageIcon("Nubes.png"));
		getContentPane().add(lblNubes);
		
		lblLadrillos2.setBounds(0, 37, 586, 50);
		lblLadrillos2.setIcon(new ImageIcon("Ladrillos2.0.png"));
		
		
		/*
		lblFondo.setBounds(0, 0,  586, 391);
		lblFondo.setIcon(new ImageIcon("Fondo.png"));
		getContentPane().add(lblFondo);
		*/
		repaint();
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
		lblAtaqueMario.setBounds(mario.getLabel().getX()+50, mario.getLabel().getY()+50, getWidth(), 10); 
		lblAtaqueMario.setOpaque(true);
		lblAtaqueMario.setIcon(new ImageIcon("Laser.png"));
		getContentPane().add(lblAtaqueMario);
		Timer timer = new Timer(250, evt -> {
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
	
	public void moverEnemigos(Enemigo e) {
		getContentPane().add(e.getLabel());
		repaint();
	}
	public void ponerEnemigo(Enemigo e) {
		getContentPane().add(e.getLabel());
		repaint();
	}

	public Mario getMario() {
		return mario;
	}
	
	public boolean nextLevel() {
		boolean retorno = false;
		
		lblMastil.setIcon(new ImageIcon("Mastil.png"));
		lblMastil.setBounds(480, 150, 45, 300);
		getContentPane().add(lblMastil);
		
		Rectangle rectanguloMastil = new Rectangle();
		rectanguloMastil.setBounds(lblMastil.getBounds());
		
		if(mario.chequearColisiones(rectanguloMastil)) {
			retorno = true;
			lblNivel.setText("WORLD: 1-2");
			mario.setX(10);
			mario.setY(360);
			mario.getLabel().setBounds(mario.getX(), mario.getY(), 91, 111);
			mario.getRectangulo().setBounds(mario.getLabel().getBounds());
			lblLadrillos.setIcon(new ImageIcon("Ladrillos2.png"));
			
			getContentPane().add(lblLadrillos2);
			getContentPane().remove(lblNubes);
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

		lblPuntaje.setBounds(200, 350, 200, 40);
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
