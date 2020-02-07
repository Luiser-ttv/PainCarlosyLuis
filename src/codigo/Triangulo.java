
package codigo;

import java.awt.Color;


public class Triangulo extends Forma {

    public Triangulo(int _posX, int _posY, Color _color, boolean _relleno) {
	//Inicializa el constructo del triangulo correctamente con 3 lados
	super(_posX, _posY, 3, _color, _relleno);
    }
}
