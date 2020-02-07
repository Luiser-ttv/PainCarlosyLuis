

package codigo;

import java.awt.Color;


public class Linea extends Forma{
    public Linea(int _posX, int _posY, Color _color, boolean _relleno) {
	//Inicializa el constructo de la linea correctamente
	super(_posX, _posY, 2, _color, _relleno);
    }
}
