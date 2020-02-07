

package codigo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;


public class Linea extends Forma{
    public Linea(int _posX, int _posY, Color _color, boolean _relleno) {
	//Inicializa el constructo de la linea correctamente
	super(_posX, _posY, 2, _color, _relleno);
    }
}
