package ezerd;
import java.awt.*;
import java.awt.event.*;

public class ezTriangle extends ezObj
{
    ezTriangle(ezPage p, int x, int y, int w, int h)
    {        
        super(p, x, y, w, h);
    }   
    void draw(Graphics pen)
    {    
        if(parent.father.choosecolorswitch)
        {           
            pen.setColor(co);
            int width = this.getWidth();
            int height = this.getHeight();
            pen.drawLine(width/2, 0, 0, height-5);
            pen.drawLine(width/2, 0, width, height-5);
            pen.drawLine(0, height-5, width, height-5);
            parent.father.choosecolorswitch = false;
        }
        else
        {
            pen.setXORMode(Color.green);                 
            int width = this.getWidth();
            int height = this.getHeight();
            pen.drawLine(width/2, 0, 0, height-5);
            pen.drawLine(width/2, 0, width, height-5);
            pen.drawLine(0, height-5, width, height-5);                     
        }
    }
}
