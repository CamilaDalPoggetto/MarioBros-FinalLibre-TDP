package Recursos;

import java.awt.Rectangle;

import javax.swing.*;


public class Bloque { //bloque "normal" (no tiene power up ni dinero)
	
	protected JLabel lblBloque;
	protected String ruta = "BloqueNormal.png";
	protected Rectangle rectangulo;
	protected int puntaje = 5;
	
	public Bloque(String ruta) {
		lblBloque = new JLabel();
		lblBloque.setIcon(new ImageIcon(ruta));
		rectangulo = new Rectangle(100, 180, 45, 40);//x, y, ancho y alto
	}
	
	public Bloque() {
		lblBloque = new JLabel();
		lblBloque.setIcon(new ImageIcon(ruta));
		rectangulo = new Rectangle(100, 180, 45, 40);
		//puntaje = 5;
	}

	public JLabel getLabel() {
		return lblBloque;
	}
	
	public Rectangle getRectangulo() {
		return rectangulo;
	}

	public void serChocado() {
		lblBloque.setIcon(new ImageIcon(""));
	}
	public int getPuntaje() {
		return puntaje;
	}
	
	public PowerUp getPowerUp() {
		return null;
	}
}
