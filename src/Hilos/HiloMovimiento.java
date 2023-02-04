package Hilos;

import GUI.Juego;

public class HiloMovimiento extends Thread {
	protected Juego juegoPrincipal;
	
	public HiloMovimiento(Juego juego) {
		juegoPrincipal = juego;
	}
	
	public void run() {
		while(true) {
			try {
				sleep(500);
				juegoPrincipal.moverBloque();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
