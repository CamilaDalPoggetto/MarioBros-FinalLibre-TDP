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
				System.out.println("puntaje " + b.getPuntaje());
				if(b.getPowerUp() != null) {
					b.getPowerUp().accept(mario);
					juegoPrincipal.setLabelVidas();
					System.out.println("tipo power up: " + b.getPowerUp().getClass());
				}
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
			juegoPrincipal.ponerBloqueRandom(b,nroRandom);
			
		}
	
	}
	
	public void moverEnemigos() {
		for(Enemigo e : nivel.getListaEnemigos()) {
			JLabel lblAux = e.getLabel();
			lblAux.setLocation(lblAux.getX()-5, lblAux.getY());
				
			e.getRectangulo().setBounds(e.getLabel().getBounds());
			Rectangle siguienteBloque = e.getRectangulo();
			boolean choque = mario.chequearColisiones(siguienteBloque);
			
			if (choque) {
				//b.serChocado();
				//nivel.eliminarBloque(b);
				System.out.println("choque con un enemigo");
			}	

			juegoPrincipal.ponerEnemigo(e);
		}
	}
	public Nivel getNivel() {
		return nivel;
	}
}
