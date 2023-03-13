package Recursos;

import java.awt.Rectangle;

import javax.swing.*;


public class Bloque { //bloque "normal" (no tiene power up)
	
	protected JLabel lblBloque;
	protected String ruta = "BloqueNormal.png";
	protected String rutaAlternativa = "BloqueNormalAzul.png";
	protected Rectangle rectangulo;
	protected int puntaje = 5;
	
	public Bloque(String ruta) {
		lblBloque = new JLabel();
		lblBloque.setIcon(new ImageIcon(ruta));
		rectangulo = new Rectangle(100, 210, 45, 40);//x, y, ancho y alto
	}
	
	public Bloque(int nroNivel) {
		lblBloque = new JLabel();
		if (nroNivel == 1){
			lblBloque.setIcon(new ImageIcon(ruta));
		}else {
			lblBloque.setIcon(new ImageIcon(rutaAlternativa));
		}
		rectangulo = new Rectangle(100, 210, 45, 40);
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
	public String getNombre() {
		return ruta;
	}
}
