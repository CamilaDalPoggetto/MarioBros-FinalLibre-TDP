package Hilos;

import java.util.LinkedList;

import GUI.Juego;
import Logica.Logica;
import Recursos.Bloque;
import Recursos.BloqueEspecial;

//Hilo que va a generar los bloques cada cierto tiempo
//dichos bloques pueden ser de cualquier tipo
//solo los crea, y el Juego es el encargado de ubicarlos
public class HiloBloques extends Thread {
	protected Logica logicaPrincipal;
	
	public HiloBloques(Logica logica) {
		logicaPrincipal = logica;
	}
	
	public void run() {
		try {
			while(true) {
				LinkedList<Bloque> listaAux =  (LinkedList<Bloque>) logicaPrincipal.getNivel().getListaBloques().clone();
				for (Bloque b:listaAux) {
					logicaPrincipal.ponerBloqueRandom(b);
					sleep(3000);
				}
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
