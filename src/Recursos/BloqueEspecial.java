package Recursos;

import GUI.ElementoGrafico;

public class BloqueEspecial extends Bloque{ //es un bloque, que ademas tiene dinero o power up
	
	protected boolean tienePowerUp; //o tiene power up, o tiene dinero
	protected static String ruta = "BloqueEspecial.png";
	
	public BloqueEspecial() {
		super(ruta);
		//tienePowerUp  = random entre 0 y 1 tal que 0 = false 1 = true
	}
	
	public ElementoGrafico getGrafico() {
		return grafico;
	}

}
