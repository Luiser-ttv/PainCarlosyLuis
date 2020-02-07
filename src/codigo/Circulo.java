
package codigo;

import java.awt.Color;


public class Circulo extends Forma {

    public Circulo(int _posX, int _posY, Color _color, boolean _relleno) {
	//Inicializa el constructo del circulo correctamente con 5000 lados
	super(_posX, _posY, 5000, _color, _relleno);
    }
}
