package Recursos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mario {
	
	protected int x, y, direccion;
	protected Rectangle rectangulo;
	protected String rutaImagen;
	protected String rutaAlternativa;
	protected int velocidad;
	protected int vidas;
	protected JLabel lblMario;
	
	public Mario(int x, int y) {
		rutaImagen = "Mario.png";
		rutaAlternativa = "Luigi.png";
		this.x = x;
		this.y = y;
		velocidad=5;
		vidas = 3;
		lblMario = new JLabel();
		lblMario.setIcon(new ImageIcon(rutaImagen));
		rectangulo = new Rectangle();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public String getRutaImagen() {
		return rutaImagen;
	}
	public Rectangle getRectangulo() {
		return rectangulo;
	}
	
	public void avanzar() {
		this.x = x+velocidad;
		rectangulo.setLocation(x, y);
		lblMario.setBounds(rectangulo);
	}
	public void retroceder() {
		this.x = x-velocidad;
		rectangulo.setLocation(x, y);
		lblMario.setBounds(rectangulo);
	}
	public void saltar() {
		this.y = y-70;
		rectangulo.setLocation(x, y);
		lblMario.setBounds(rectangulo);
	}
	public void bajar() {
		this.y = y+70;
		rectangulo.setLocation(x, y);
		lblMario.setBounds(rectangulo);
	}
	public boolean chequearColisiones(Rectangle rectangulo) {
		boolean toReturn = false;
		if (this.rectangulo.intersects(rectangulo)) {
			System.out.println("me choque");
			toReturn = true;
		}
		return toReturn;
	}
	public void morir() {
		
	}
	public int getVidas() {
		return vidas;
	}

	public void  visitPowerUp1() {
		velocidad = 10;
	}
	public void visitPowerUp2() {
		vidas++;
	}
	public void  visitPowerUp3() {
		lblMario.setIcon(new ImageIcon(rutaAlternativa));
		String aux = rutaAlternativa;
		rutaAlternativa = rutaImagen ;
		rutaImagen = aux;
	}
	
	public JLabel getLabel() {
		return lblMario;
	}
}
