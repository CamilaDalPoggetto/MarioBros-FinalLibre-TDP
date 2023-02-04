package Logica;

import java.util.LinkedList;
import java.util.Random;

import Recursos.*;

public class Nivel {
	
	//contiene una lista de Bloque, que pueden o no tener power ups o ser especiales
	//tambien tiene una lista de enemigos (pero no llegamos todavia)
	protected LinkedList<Bloque> llBloques;
	//protected LinkedList<Enemigo> llEnemigos;

	public Nivel(int i) {
		llBloques = new LinkedList<Bloque>();
		llenarListaBloques();
	}

	private void llenarListaBloques() {
		Random random = new Random();
		//0 = normal, 1 = monedas, 2 = powerUp
		while(llBloques.size() < 5) {
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
	
}