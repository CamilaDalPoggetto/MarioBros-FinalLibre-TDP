package Recursos;

import java.awt.Rectangle;

public class Mario {
	
	protected int cantVida, x, y, direccion;
	protected boolean ataque;
	protected Rectangle rectangulo;
	protected String rutaImagen;
	
	public Mario(int x, int y) {
		rutaImagen = "Mario";
		cantVida = 10;
		this.x = x;
		this.y = y;
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
		this.x = x+5;
		rectangulo.setLocation(x, y);
	}
	public void retroceder() {
		this.x = x-5;
	}
	public void saltar() {
		this.y = y-70;
		rectangulo.setLocation(x, y);
	}
	public void bajar() {
		this.y = y+70;
		rectangulo.setLocation(x, y);
	}
	public void chequearColisiones(Rectangle rectangulo) {
		if (this.rectangulo.contains(rectangulo)) {
			System.out.println("me choque");
		}
	}
	public void morir() {
		
	}

	
}
