package ezerd;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JColorChooser;
import javax.swing.colorchooser.*;

public class ezColor extends Frame 
{
   ezToolbox parent;
   public JColorChooser colorchooser;
    
   public ezColor(ezToolbox p)
   {
        super();
        parent = p;
        Color ch;
        Color c = JColorChooser.showDialog(ezColor.this,"Choose Color", getBackground());//直接取得使用者點選的顏色
        if(c!=null)
        {
            System.out.println(c);
            parent.choosecolorswitch = true;
            if(parent.father.workpage.activeobj!=null)//物件的顏色
            {
                parent.father.workpage.activeobj.co = c;            
                parent.father.workpage.activeobj.repaint();
            }
            else//畫線的顏色
            {                
                parent.father.workpage.choosecolor = c;
            }
        }
   }
}
