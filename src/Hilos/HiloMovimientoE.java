package Hilos;

import Logica.Logica;

public class HiloMovimientoE extends Thread { //por ahora chequea las colisiones
	protected Logica logicaPrincipal;
	
	public HiloMovimientoE(Logica logica) {
		logicaPrincipal = logica;
	}
	

	public void run() {
		try {
			while(logicaPrincipal.getMario().isVivo()) {
				logicaPrincipal.moverEnemigos();
				logicaPrincipal.nextLevel();
				sleep(50);
			}
		} catch (InterruptedException e1) {
				e1.printStackTrace();
		}
	}
}

