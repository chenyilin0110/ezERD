package ezerd;
import java.awt.*;
import java.awt.event.*;

public class ezEntity extends ezObj
{   
    ezEntity(ezPage p, int x, int y, int w, int h)
    {        
        super(p, x, y, w, h);
    }   
    void draw(Graphics pen)
    {    
        if(parent.father.choosecolorswitch)
        {           
            pen.setColor(co);
            pen.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);            
            parent.father.choosecolorswitch = false;
        }
        else
        {
            pen.setXORMode(Color.green);                 
            pen.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);                       
        }
    }
    
}
