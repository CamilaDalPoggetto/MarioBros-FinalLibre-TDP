package Recursos;

import java.util.Random;

import javax.swing.ImageIcon;

public class BloqueEspecial extends Bloque{ //es un bloque, que ademas tiene dinero o power up
	
	protected static String ruta = "BloqueEspecial.png";
	protected PowerUp powerUp;
	
	public BloqueEspecial() {
		super(ruta);
		puntaje = 50;
		randomPowerUp();
	}
	
	private void randomPowerUp() {
		/**
		 * random tal que 
		 * 0 = dinero
		 * 1 = power up velocidad
		 * 2 = power up crecer
		 * 3 = power up balas
		 */
		
		Random random = new Random();
		int max = 2;
		int min = 1;
		int nroRandom = random.nextInt(max + min) + min;
		System.out.println("nro random: " + nroRandom);
		decidirPowerUp(nroRandom);
	}
	
	private void decidirPowerUp(int nroRandom) {
		switch(nroRandom){
		case 1:
			powerUp = new PowerUp1(); //velocidad
			break;
		case 2:
			powerUp = new PowerUp2(); //+1 vida
			break;
		case 3:
			powerUp = new PowerUp3(); //cambio de skin
			break;
		}
	}
	
	
	public void serChocado() {
		lblBloque.setIcon(new ImageIcon(""));
	}
	public PowerUp getPowerUp() {
		return powerUp;
	}
}
