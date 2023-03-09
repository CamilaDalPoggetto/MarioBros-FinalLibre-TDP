package Hilos;

import java.util.LinkedList;
import Logica.Logica;
import Recursos.Enemigo;

public class HiloMovimientoE extends Thread { //por ahora chequea las colisiones
	protected Logica logicaPrincipal;
	
	public HiloMovimientoE(Logica logica) {
		logicaPrincipal = logica;
	}
	

	public void run() {
		try {
			while(logicaPrincipal.getMario().isVivo()) {
				//LinkedList<Enemigo> listaAux = (LinkedList<Enemigo>) logicaPrincipal.getNivel().getListaEnemigos().clone();
				logicaPrincipal.moverEnemigos();
				logicaPrincipal.nextLevel();
				sleep(50);
			}
		} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
	}
}

