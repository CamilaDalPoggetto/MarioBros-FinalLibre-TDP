package Recursos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Enemigo {
	
	protected String rutaImagen;
	protected JLabel lblEnemigo;
	protected Rectangle rectangulo;
	protected boolean vivo;
	public Enemigo(String ruta) {
		rutaImagen = ruta;
		lblEnemigo = new JLabel();
		lblEnemigo.setIcon(new ImageIcon(ruta));
		vivo = false;
		rectangulo = new Rectangle(100, 180, 45, 40);
	}
	public JLabel getLabel() {
		return lblEnemigo;
	}
	
	public Rectangle getRectangulo() {
		return rectangulo;
	}
	public void morir() {
		vivo = false;
		lblEnemigo.setIcon(new ImageIcon(""));
	}
	public void nacer() {
		vivo = true;
	}
	public boolean isVivo() {
		return vivo;
	}
	public void mover() {
		lblEnemigo.setBounds(lblEnemigo.getX()-10, lblEnemigo.getY(), lblEnemigo.getWidth(), lblEnemigo.getHeight());
		rectangulo.setBounds(lblEnemigo.getBounds());
	}
}
