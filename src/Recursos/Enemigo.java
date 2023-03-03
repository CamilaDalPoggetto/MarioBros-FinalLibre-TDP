package Recursos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Enemigo {
	
	protected String rutaImagen;
	protected JLabel lblEnemigo;
	protected Rectangle rectangulo;
	
	public Enemigo(String ruta) {
		rutaImagen = ruta;
		lblEnemigo = new JLabel();
		lblEnemigo.setIcon(new ImageIcon(ruta));
		rectangulo = new Rectangle(100, 180, 45, 40);
	}

	public JLabel getLabel() {
		return lblEnemigo;
	}
	
	public Rectangle getRectangulo() {
		return rectangulo;
	}
	private void morir() {
		
	}
}
