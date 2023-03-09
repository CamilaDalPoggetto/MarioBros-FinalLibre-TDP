package Logica;

import java.util.LinkedList;
import java.util.Random;

import GUI.Juego;
import Recursos.*;

public class Nivel {
	
	//contiene una lista de Bloque, que pueden o no tener power ups o ser especiales
	//tambien tiene una lista de enemigos
	protected LinkedList<Bloque> llBloques;
	protected LinkedList<Enemigo> llEnemigos;
	
	protected int cantBloques;
	protected int nroNivel;
	
	public Nivel(int nroNivel) {
		llBloques = new LinkedList<Bloque>();
		llEnemigos = new LinkedList<Enemigo>();

		this.nroNivel = nroNivel;
		llenarListaBloques();
		cantBloques = 0;
	}
	public void sumarBloques() {
		cantBloques++;
	}
	public int getCantBloques() {
		return cantBloques;
	}
	
	public void crearEnemigo() {
		Random random = new Random();
		//0 = tortuga, 1 = hongoMalo
		int max = 2;
		int min = 0;
		int nroRandom = random.nextInt(max + min) + min;
		Enemigo retorno = decidirEnemigo(nroRandom);
		retorno.getLabel().setBounds(600, 300, 45, 45);
		llEnemigos.add(retorno);
		System.out.println("cree un enemigo: " + llEnemigos.size());
	}
	
	private Enemigo decidirEnemigo(int random) {
		Enemigo retorno = new Enemigo("");
		switch(random) {
		case 0:
			retorno = new Bullet();
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
		Bloque retorno = new Bloque(nroNivel);
		switch(random) {
		case 0:
			retorno = new Bloque(nroNivel);
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
		LinkedList<Bloque> listaAux = (LinkedList<Bloque>) llBloques;
		listaAux.remove(b);
		cantBloques--;
		llBloques = listaAux;
	}
	
	public LinkedList<Enemigo> getListaEnemigos() {
		return llEnemigos;
	}
	public void eliminarEnemigo(Enemigo e) {
		LinkedList<Enemigo> listaAux = (LinkedList<Enemigo>) llEnemigos;
		listaAux.remove(e);
		llEnemigos = listaAux;
	}
	public void limpiarListaEnemigos() {
		llEnemigos = null;
	}
	
	public int getNroNivel() {
		return nroNivel;
	}
}