package Hilos;

import GUI.Juego;
import Recursos.Bloque;
import Recursos.BloqueEspecial;

//Hilo que va a generar los bloques cada cierto tiempo
//dichos bloques pueden ser de cualquier tipo
//solo los crea, y el Juego es el encargado de ubicarlos
public class HiloBloques extends Thread {
	protected Juego juegoPrincipal;
	
	public HiloBloques(Juego juego) {
		juegoPrincipal = juego;
	}
	
	public void run() {
		while(true) {
			try {
				for (Bloque b:juegoPrincipal.getNivel().getListaBloques()) {
					juegoPrincipal.ponerBloque(b);
					sleep(5000);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}