package ezerd;
import java.awt.*;
import java.awt.event.*;

public class ezRelationship extends ezObj
{
    ezRelationship(ezPage p, int x, int y,int w, int h)
    {
        super(p, x, y, w, h);
    }
    void draw(Graphics pen)
    {
        if(parent.father.choosecolorswitch)
        {           
            pen.setColor(co);
            int w = this.getWidth();
            int h = this.getHeight();
            pen.drawLine(0, h/2, w/2, h);
            pen.drawLine(w/2, h, w, h/2);
            pen.drawLine(w, h/2, w/2, 0);
            pen.drawLine(w/2, 0, 0, h/2);                      
            parent.father.choosecolorswitch = false;
        }
        else
        {
            pen.setXORMode(Color.green);
            int w = this.getWidth();
            int h = this.getHeight();
            pen.drawLine(0, h/2, w/2, h);
            pen.drawLine(w/2, h, w, h/2);
            pen.drawLine(w, h/2, w/2, 0);
            pen.drawLine(w/2, 0, 0, h/2);                      
        }
        
    }
    
}
