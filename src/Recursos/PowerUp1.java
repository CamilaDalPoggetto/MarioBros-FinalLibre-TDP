package Recursos;

import javax.swing.ImageIcon;

public class PowerUp1 extends PowerUp{
	public PowerUp1() {
		super("velocidad.png");
	}

	@Override
	public void accept(Mario m) {
		m.visitPowerUp1();
	}
	
	
}
