package Recursos;

import java.awt.Rectangle;

import javax.swing.*;

import GUI.ElementoGrafico;

public class Bloque { //bloque "normal" (no tiene power up ni dinero)
	
	protected ElementoGrafico grafico;
	protected JLabel lblBloque;
	protected String ruta = "BloqueNormal.png";
	protected Rectangle rectangulo;
	
	public Bloque(String ruta) {
		grafico = new ElementoGrafico(ruta);
		lblBloque = new JLabel();
		lblBloque.setIcon(new ImageIcon(ruta));
		rectangulo = new Rectangle();//x, y, ancho y alto
	}
	
	public Bloque() {
		grafico = new ElementoGrafico(ruta);
		lblBloque = new JLabel();
		lblBloque.setIcon(new ImageIcon(ruta));
		rectangulo = new Rectangle();
	}

	public ElementoGrafico getGrafico() {
		return grafico;
	}
	
	public JLabel getLabel() {
		return lblBloque;
	}
	
	public Rectangle getRectangulo() {
		return rectangulo;
	}
}
