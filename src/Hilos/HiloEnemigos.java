package Hilos;

import java.util.LinkedList;

import GUI.Juego;
import Logica.Logica;
import Recursos.Bloque;
import Recursos.Enemigo;

public class HiloEnemigos extends Thread { //crea enemigos de a uno
	protected Logica logicaPrincipal;
	//protected HiloMovimientoE hiloMovimiento;
	public HiloEnemigos(Logica logica, HiloMovimientoE hilo) {
		logicaPrincipal = logica;
		//hiloMovimiento = hilo;
	}
	
	public void run() {
		while(logicaPrincipal.getMario().isVivo()) {
			try {
				//LinkedList<Enemigo> listaAux =  (LinkedList<Enemigo>) logicaPrincipal.getNivel().getListaEnemigos().clone();
				//for (Enemigo e:listaAux) {
					sleep(8000);
					logicaPrincipal.crearEnemigo();
					
					//hiloMovimiento.run(e);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	}
}

