package Recursos;

public class PowerUp3 extends PowerUp{

	public PowerUp3() {
		super("");
	}

	@Override
	public void accept(Mario mario) {
		mario.visitPowerUp3();
	}

}
