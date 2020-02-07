/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author rioja
 */
public class Escribe {
    
    public int x, y;
    String texto;

    public Escribe (int posX, int posY, String _texto) {
        this.x = posX;
        this.y = posY;
        texto = _texto;
    }
    
    public void escribe(Graphics2D g2,int posX ,int posY,String texto,Color color,int tamañoLetra){
        Font font = new Font("Comic Sans MS", Font.PLAIN, tamañoLetra);
        FontRenderContext frc = new FontRenderContext(null, true, true);
        Rectangle2D bounds = font.getStringBounds(texto, frc);
        g2.setColor(color);
        g2.setFont(font);
        g2.drawString(texto, (float) posX, (float) posY);
    }
    
}
