package Hilos;

import java.util.LinkedList;

import GUI.Juego;
import Logica.Logica;
import Recursos.Bloque;
import Recursos.Enemigo;

public class HiloEnemigos extends Thread { //por ahora chequea las colisiones
	protected Logica logicaPrincipal;
	
	public HiloEnemigos(Logica logica) {
		logicaPrincipal = logica;
	}
	
	public void run() {
		while(true) {
			try {
				LinkedList<Enemigo> listaAux =  (LinkedList<Enemigo>) logicaPrincipal.getNivel().getListaEnemigos().clone();
				for (Enemigo e:listaAux) {
					sleep(10000);
					logicaPrincipal.ponerEnemigo(e);
					logicaPrincipal.moverEnemigos(e);
					System.out.println("puse un enemigo");
					sleep(10000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

