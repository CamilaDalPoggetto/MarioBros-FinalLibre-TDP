package Recursos;

public class PowerUp2 extends PowerUp{
	public PowerUp2() {
		super("vidas.png");
	}

	@Override
	public void accept(Mario mario) {
		mario.visitPowerUp2();
	}
	
}
