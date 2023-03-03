package Logica;

import java.util.LinkedList;
import java.util.Random;

import GUI.Juego;
import Recursos.*;

public class Nivel {
	
	//contiene una lista de Bloque, que pueden o no tener power ups o ser especiales
	//tambien tiene una lista de enemigos (pero no llegamos todavia)
	protected LinkedList<Bloque> llBloques;
	protected LinkedList<Enemigo> llEnemigos;
	
	protected int cantBloques;
	protected int puntaje;
	
	public Nivel() {
		llBloques = new LinkedList<Bloque>();
		llEnemigos = new LinkedList<Enemigo>();

		llenarListaEnemigos();
		llenarListaBloques();
		cantBloques = 0;
		puntaje = 0;
	}
	public void sumarBloques() {
		cantBloques++;
	}
	public int getCantBloques() {
		return cantBloques;
	}
	
	private void llenarListaEnemigos() {
		Random random = new Random();
		//0 = tortuga, 1 = hongoMalo
		while(llEnemigos.size() < 10) {
			int max = 2;
			int min = 0;
			int nroRandom = random.nextInt(max + min) + min;

			Enemigo retorno = decidirEnemigo(nroRandom);
			retorno.getLabel().setBounds(610, 200, 20, 45);
			llEnemigos.add(retorno);
		}
	}
	private Enemigo decidirEnemigo(int random) {
		Enemigo retorno = new Enemigo("");
		switch(random) {
		case 0:
			retorno = new Tortuga();
			break;
		case 1:
			retorno = new HongoMalo();
			break;
		}
		return retorno;
	}
	private void llenarListaBloques() {
		Random random = new Random();
		//0 = normal, 1 = especial
		while(llBloques.size() < 10) {
			int max = 2;
			int min = 0;
			int nroRandom = random.nextInt(max + min) + min;

			Bloque retorno = decidirBloque(nroRandom);
			llBloques.add(retorno);
		}
	}
	
	private Bloque decidirBloque(int random) {
		Bloque retorno = new Bloque();
		switch(random) {
		case 0:
			retorno = new Bloque();
			break;
		case 1:
			retorno = new BloqueEspecial();
			break;
		}
		return retorno;
	}
	
	public LinkedList<Bloque> getListaBloques(){
		return llBloques;
	}

	public void eliminarBloque(Bloque b) {
		//recorrer la lista hasta encontrar el bloque y eliminarlo
		LinkedList<Bloque> listaAux = (LinkedList<Bloque>) llBloques;
		listaAux.remove(b);
		llBloques = listaAux;
	}
	
	public void sumarPuntaje(int p) {
		puntaje+=p;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public LinkedList<Enemigo> getListaEnemigos() {
		return llEnemigos;
	}
	
}