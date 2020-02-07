
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public class Cuadrado extends Forma {
    public Cuadrado (int _posX, int _posY, Color _color, boolean _relleno) {
	//Inicializa el constructo del cuadrado correctamente con 3 lados
	super(_posX, _posY, 4, _color, _relleno);
    }
}