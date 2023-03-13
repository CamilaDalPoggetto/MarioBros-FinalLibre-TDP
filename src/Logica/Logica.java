package Logica;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.Timer;

import GUI.Juego;
import Recursos.Bloque;
import Recursos.Enemigo;
import Recursos.Mario;

public class Logica {
	private Juego juegoPrincipal;
	private Nivel nivel;
	private Mario mario;
	private Enemigo siguienteEnemigo;
	
	
	public Logica(Juego juego, Nivel nivel) {
		juegoPrincipal = juego;
		juegoPrincipal.setLogica(this);
		this.nivel = nivel;
		this.mario = juegoPrincipal.getMario();
	}
	
	public void chequearColisiones() {
		LinkedList<Bloque> listaAux = (LinkedList<Bloque>) nivel.getListaBloques().clone();
		for (Bloque b: listaAux) {
			b.getRectangulo().setBounds(b.getLabel().getBounds());
			Rectangle siguienteBloque = b.getRectangulo();
			boolean choque = mario.chequearColisiones(siguienteBloque);
			if (choque) {
				b.serChocado();
				nivel.eliminarBloque(b);
				juegoPrincipal.setLabelPuntaje(b.getPuntaje());
				if(b.getPowerUp() != null) {
					b.getPowerUp().accept(mario);
				}
			}
			
		}
	}
		
	public void nextLevel() {
		LinkedList<Bloque> listaAux = (LinkedList<Bloque>) nivel.getListaBloques().clone();
		
		if (listaAux.isEmpty() && juegoPrincipal.nextLevel()) {
			if(nivel.getNroNivel() == 1) {
				nivel.limpiarListEnemigos();
				nivel = new Nivel(2);
			}else {
				mario.morir();
				juegoPrincipal.fin();

			}
		}
	}

	public void ponerBloqueRandom(Bloque b) {
		if (nivel.getCantBloques() < 5) { //para que haya solo 5 bloques en pantalla a la vez
			
			Random random = new Random();
			int max = 450;
			int min = 10;
			int nroRandom = random.nextInt(max + min) + min;

			nivel.sumarBloques();
			b.getLabel().setBounds(nroRandom, 210, 45, 40);
			b.getRectangulo().setBounds(b.getLabel().getBounds());
			juegoPrincipal.ponerBloque(b);
		}	
	}
	
	public void moverEnemigos() {
		LinkedList<Enemigo> listaAux = (LinkedList<Enemigo>) nivel.getListaEnemigos().clone();
		for(Enemigo e : listaAux) {
			e.mover();
			siguienteEnemigo = e;
			Rectangle siguienteEnemigo = e.getRectangulo();
			
			if (!mario.isInmortal() && mario.chequearColisiones(siguienteEnemigo)) {
				e.morir();
				mario.morir();
				juegoPrincipal.gameOver();
			}
			juegoPrincipal.ponerEnemigo(e);
		}
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	public Mario getMario() {
		return mario;
	}
	public void crearEnemigo() {
		nivel.crearEnemigo();
	}

	public void marioAtaque() {
		if(siguienteEnemigo != null) {
			siguienteEnemigo.morir();
			juegoPrincipal.setLabelPuntaje(10);
			nivel.eliminarEnemigo(siguienteEnemigo);
			siguienteEnemigo = null;
		}
	}
}
