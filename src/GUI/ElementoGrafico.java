package GUI;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ElementoGrafico {

	protected Image imagen;
	protected String rutaImagen;
	
	public ElementoGrafico(String ruta) {
		rutaImagen = ruta;
		imagen = new ImageIcon(ruta).getImage();
	}

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	
	
}
