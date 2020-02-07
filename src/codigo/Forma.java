

package codigo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;


public class Forma extends Polygon{
    public Color color = null;
    public boolean relleno = false;
    //Coordenadas del centro de la forma
    public int x = 0;
    public int y = 0;
    
        public Forma(int _posX, int _posY, int _lados, Color _color, boolean _relleno) {
	//Inicializa el constructor de la forma con distintos lados
	super(new int[_lados], new int[_lados], _lados);
	//Guarda el centro de la forma
	x = _posX;
	y = _posY;
	//Asigna el color y relleno de la forma
	color = _color;
	relleno = _relleno;
    }
    
        public void dibujate(Graphics2D g2, int _posX, int _posY, BasicStroke _trazo) {
	// Redibuja la forma
	calculaVertices(y - _posY, x - _posX);
	// Asigna el color de la forma
	g2.setColor(color);
	// Asigna el relleno de la forma
	if (relleno) {
	    g2.fill(this);
	} else {
	    g2.setStroke(_trazo);
	    g2.draw(this);
	}
    }

    /**
     * Recalcula la posicion de los vertices en un poligono regular
     *
     * @param _radio - int
     */
    public void calculaVertices(int _radio, double _giro) {
	for (int i = 0; i < npoints; i++) {
	    xpoints[i] = (int) (x + _radio * Math.cos((2 * Math.PI * i + _giro / 40) / npoints));
	    ypoints[i] = (int) (y + _radio * Math.sin((2 * Math.PI * i + _giro / 40) / npoints));
	}
    }
}


