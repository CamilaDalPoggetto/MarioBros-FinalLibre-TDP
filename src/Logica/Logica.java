package Logica;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;

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
					System.out.println("Power up de tipo: " + b.getPowerUp().getClass());					
					b.getPowerUp().accept(mario);
					//juegoPrincipal.setLabelVidas();
				}
			}
			
		}
	}
		
	public void nextLevel() {
		LinkedList<Bloque> listaAux = (LinkedList<Bloque>) nivel.getListaBloques().clone();
		
		if (listaAux.isEmpty() && juegoPrincipal.nextLevel()) {
			if(nivel.getNroNivel() == 1) {
				nivel.limpiarListaEnemigos();
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
			b.getLabel().setBounds(nroRandom, 140, 45, 40);
			b.getRectangulo().setBounds(b.getLabel().getBounds());
			juegoPrincipal.ponerBloque(b);
		}	
	}
	
	public synchronized void moverEnemigos() {
		LinkedList<Enemigo> listaAux = (LinkedList<Enemigo>) nivel.getListaEnemigos().clone();
		for(Enemigo e : listaAux) {
			e.mover();
			siguienteEnemigo = e;
			Rectangle siguienteEnemigo = e.getRectangulo();
			
			if (mario.chequearColisiones(siguienteEnemigo)) {
				e.morir();
				mario.morir();
				juegoPrincipal.gameOver();
				System.out.println("en game over. mario vivo:" + mario.isVivo());
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
	/*
	public void ponerEnemigo(Enemigo e) {
		juegoPrincipal.ponerEnemigo(e);
	}
*/
	public void crearEnemigo() {
		nivel.crearEnemigo();
	}

	public void marioAtaque() {
		if(siguienteEnemigo != null) {
			siguienteEnemigo.morir();
			nivel.eliminarEnemigo(siguienteEnemigo);
		}
	}
}
