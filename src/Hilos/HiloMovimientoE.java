package Hilos;

import GUI.Juego;
import Logica.Logica;
import Recursos.Bloque;
import Recursos.Enemigo;

public class HiloMovimientoE extends Thread { //por ahora chequea las colisiones
	protected Logica logicaPrincipal;
	
	public HiloMovimientoE(Logica logica) {
		logicaPrincipal = logica;
	}
	

	public void run() {
		try {
			while(true) {
				logicaPrincipal.moverEnemigos();
				sleep(5000);
			}
		} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
	}
}

