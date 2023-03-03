package Recursos;

import javax.swing.*;

public abstract class PowerUp {
	
	protected String ruta;
	protected JLabel label;
	
	public PowerUp(String ruta) {
		this.ruta = ruta;
		label = new JLabel();
		label.setIcon(new ImageIcon(ruta));
	}
	public abstract void accept(Mario mario);
}
