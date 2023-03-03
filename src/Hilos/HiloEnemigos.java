package Hilos;

import GUI.Juego;
import Logica.Logica;
import Recursos.Enemigo;

public class HiloEnemigos extends Thread { //por ahora chequea las colisiones
	protected Logica logicaPrincipal;
	
	public HiloEnemigos(Logica logica) {
		logicaPrincipal = logica;
	}
	
	public void run() {
		while(true) {
			try {
				for (Enemigo e: logicaPrincipal.getNivel().getListaEnemigos()) {
					logicaPrincipal.moverEnemigos();
					sleep(10000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

