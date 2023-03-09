package Recursos;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
public class Mario {
	
	protected int x, y, direccion, velocidad;
	protected Rectangle rectangulo;
	protected String rutaImagen, rutaAlternativa;
	protected JLabel lblMario, lblAtaque;
	protected boolean vivo, inmortal;
	
	public Mario(int x, int y) {
		rutaImagen = "Mario.png";
		rutaAlternativa = "Luigi2.png";
		
		vivo = true;
		inmortal = false;
		
		this.x = x;
		this.y = y;
		velocidad=5;
		lblMario = new JLabel();
		lblMario.setIcon(new ImageIcon(rutaImagen));
		lblMario.setBounds(x, y, 91, 110);
		
		lblAtaque = new JLabel();
		lblAtaque.setIcon(new ImageIcon("Laser2.gif"));
		
		rectangulo = new Rectangle();
		rectangulo.setBounds(lblMario.getBounds());
	}
	
	
	public boolean isVivo() {
		return vivo;
	}
	
	public JLabel getLabelAtaque() {
		return lblAtaque;
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
	public void setY(int y) {
		this.y = y;
	}
	public String getRutaImagen() {
		return rutaImagen;
	}
	public Rectangle getRectangulo() {
		return rectangulo;
	}
	
	public void avanzar() {
		if (x < 500) {
			this.x = x+velocidad;
			rectangulo.setLocation(x, y);
			lblMario.setBounds(rectangulo);
		}
	}
	public void retroceder() {
		if (x > 0) {
			this.x = x-velocidad;
			rectangulo.setLocation(x, y);
			lblMario.setBounds(rectangulo);
		}
	}
	public void saltar() {
		this.y = y-130;
		rectangulo.setLocation(x, y);
		lblMario.setBounds(rectangulo);
	}
	public void bajar() {
		this.y = y+130;
		rectangulo.setLocation(x, y);
		lblMario.setBounds(rectangulo);
	}
	
	public boolean chequearColisiones(Rectangle rectangulo) {
		
		boolean toReturn = false;
		if (this.rectangulo.intersects(rectangulo)) {
			toReturn = true;
		}
		return toReturn;
	}

	public void  visitPowerUp1() {
		velocidad = 10;
	}
	public void visitPowerUp2() {
		inmortal = true;
		lblMario.setIcon(new ImageIcon("MarioConEscudo.png"));
		Timer timer = new Timer(10000, evt -> {
		    inmortal = false;
			lblMario.setIcon(new ImageIcon("Mario.png"));
		});
		
		timer.setRepeats(false);
		timer.start();
		
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

	public void morir() {
		vivo = false;
	}


	public boolean isInmortal() {
		return inmortal;
	}


}
