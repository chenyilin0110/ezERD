package ezerd;
import java.awt.*;
import java.awt.event.*;

enum ezObjStatus { select, unselect, ready2move, moving, ready2resize, resizing}

public abstract class ezObj extends Panel//要加上abstract
{
    ezOutline outline;
    ezObjStatus status;
    public ezPage parent;
    Point startpoint=null;
    Color co;
    ezObj(ezPage p, int x,int y, int w, int h)
    {
        parent = p;
        this.setSize(w,h);
        this.setLocation(x,y);
        outline = new ezOutline(this);
        status = ezObjStatus.select;
        showOutline();
        this.addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                if((status == status.moving) || (status == status.ready2move))
                {
                    status = status.moving;
                    int dx,dy;
                    dx = e.getPoint().x - startpoint.x;
                    dy = e.getPoint().y - startpoint.y;
                    Point p = ezObj.this.getLocation();
                    ezObj.this.setLocation(p.x+dx, p.y+dy);
                    System.out.println("dragged ("+e.getX()+","+e.getY()+")");                                        
                }
            }
        });        
        this.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                System.out.println(ezObj.this.status);
                if(ezObj.this.status == ezObjStatus.select)
                {
                    status = ezObjStatus.ready2move;
                    System.out.println("pressed (" + e.getX() +","+ e.getY() +")");     
                    startpoint = e.getPoint();
                    System.out.println("pressed (" + startpoint.getX() +","+ startpoint.getY() +")");     
                    ezObj.this.hideOutline();
                }    
                else if(ezObj.this.status == ezObjStatus.unselect)
                {
                    if(ezObj.this.parent.activeobj == null)
                    {
                        ezObj.this.parent.activeobj = ezObj.this;
                        ezObj.this.showOutline();
                        ezObj.this.status = status.select; 
                    }
                    else
                    {
                        ezObj.this.parent.activeobj.hideOutline();
                        ezObj.this.parent.activeobj.status = status.unselect;
                        ezObj.this.parent.activeobj = null;
                        
                        ezObj.this.showOutline();
                        ezObj.this.status = status.select;
                        ezObj.this.parent.activeobj = ezObj.this;                        
                        System.out.println(ezObj.this.status);
                        parent.repaint();
                    }
                }
            }
        });
        this.addMouseListener(new MouseAdapter()
        {
            public void mouseReleased(MouseEvent e)
            {
                if(ezObj.this.status == ezObj.this.status.ready2move)
                {
                    ezObj.this.status = ezObj.this.status.select;
                    ezObj.this.showOutline();       
                    parent.repaint();
                }
                else if(ezObj.this.status == ezObj.this.status.moving)
                {
                    ezObj.this.status = ezObj.this.status.select;
                    ezObj.this.showOutline();                    
                    parent.repaint();
                }
            }
        });
    }
    public void paint (Graphics pen)
    {       
        draw(pen);             
    }
    abstract void draw(Graphics pen);//繼承ezObj就必需時做上述的draw
    
    public void showOutline()
    {
        outline.show();
    }
    public void hideOutline()
    {
        outline.hideshow();
    }    
}
