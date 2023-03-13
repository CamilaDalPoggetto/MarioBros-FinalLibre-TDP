package Hilos;

import Logica.Logica;

public class HiloEnemigos extends Thread { //crea enemigos de a uno
	protected Logica logicaPrincipal;
	
	public HiloEnemigos(Logica logica, HiloMovimientoE hilo) {
		logicaPrincipal = logica;
	}
	
	public void run() {
		try {
			while(logicaPrincipal.getMario().isVivo()) {
				sleep(5000);
				logicaPrincipal.crearEnemigo();
			}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}


