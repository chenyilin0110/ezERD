package ezerd;
import java.awt.*;
import java.awt.event.*;

public class ezOutline 
{
    ezObj parent;
    Point startpoint;
    private Panel E,W,N,S,SE,SW,NE,NW;
    ezOutline(ezObj p)
    {
        parent = p;
        startpoint  = new Point();
        N = new Panel();
        N.setBackground(Color.red);
        N.setSize(7,7);
        N.setLocation(parent.getLocation().x+ parent.getWidth()/2-3,
                       parent.getLocation().y-8);
        parent.parent.add(N);
        N.addMouseListener(new MouseAdapter()
        {
             public void mousePressed(MouseEvent e)
            {
                if(parent.status == parent.status.select)
                {
                    parent.status = parent.status.ready2resize;
                    startpoint = e.getPoint();
                    parent.setVisible(false);
                    System.out.println(startpoint.x + "," + startpoint.y);
                    
                }
            }
            public void mouseReleased(MouseEvent e)
            {
                if(parent.status == parent.status.resizing)
                {
                    parent.status = parent.status.select;                    
                    parent.setVisible(true);                                        
                }
            }
        });       
        N.addMouseMotionListener(new MouseAdapter()
        {
            int dx, dy;
            public void mouseDragged(MouseEvent e)
            {
                if(parent.status == parent.status.ready2resize)
                {
                    parent.status = parent.status.resizing;
                    dx = e.getPoint().x - startpoint.x;
                    dy = e.getPoint().y - startpoint.y;//-
                    parent.hideOutline();                            
                    parent.setSize(parent.getWidth(),parent.getHeight()-dy);                    
                    parent.setLocation(parent.getLocation().x,parent.getLocation().y+dy);
                    startpoint = e.getPoint();
                    parent.showOutline();
                }
                else if(parent.status == parent.status.resizing)
                {
                    dx = e.getPoint().x - startpoint.x;
                    dy = e.getPoint().y - startpoint.y;
                    parent.hideOutline();                         
                    parent.setSize(parent.getWidth(),parent.getHeight()-dy);                    
                    parent.setLocation(parent.getLocation().x,parent.getLocation().y+dy);
                    startpoint = e.getPoint();
                    parent.showOutline();                    
                }
            }
        });
        NE = new Panel();
        NE.setBackground(Color.red);
        NE.setSize(7,7);
        NE.setLocation(parent.getLocation().x+ parent.getWidth()+2,
                       parent.getLocation().y-9);
        parent.parent.add(NE);
        NE.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if(parent.status == parent.status.select)
                {
                    parent.status = parent.status.ready2resize;
                    startpoint = e.getPoint();
                    System.out.println(startpoint.x + "," + startpoint.y);
                    parent.setVisible(false);
                }
            }
            public void mouseReleased(MouseEvent e)
            {
                if(parent.status == parent.status.resizing)
                {
                    parent.status = parent.status.select;                    
                    parent.setVisible(true);
                }
            }
        });
        NE.addMouseMotionListener(new MouseAdapter()
        {
            int dx, dy;
            public void mouseDragged(MouseEvent e)
            {
                if(parent.status == parent.status.ready2resize)
                {
                    parent.status = parent.status.resizing;
                    dx = e.getPoint().x - startpoint.x;
                    dy = e.getPoint().y - startpoint.y;// -
                    parent.hideOutline();
                    parent.setSize(parent.getWidth()+dx,parent.getHeight()-dy);
                    parent.setLocation(parent.getLocation().x,parent.getLocation().y+dy);
                    startpoint = e.getPoint();
                    parent.showOutline();
                    
                }
                else if(parent.status == parent.status.resizing)
                {
                    dx = e.getPoint().x - startpoint.x;
                    dy = e.getPoint().y - startpoint.y;
                    parent.hideOutline();
                    parent.setSize(parent.getWidth()+dx,parent.getHeight()-dy);
                    parent.setLocation(parent.getLocation().x,parent.getLocation().y+dy);
                    startpoint = e.getPoint();
                    parent.showOutline();
                }
            }
        });
        E = new Panel();
        E.setBackground(Color.red);
        E.setSize(7,7);
        E.setLocation(parent.getLocation().x+ parent.getWidth()+2,
                       parent.getLocation().y+parent.getHeight()/2-3);
        parent.parent.add(E);
        E.addMouseListener(new MouseAdapter()
        {
             public void mousePressed(MouseEvent e)
            {
                if(parent.status == parent.status.select)
                {
                    parent.status = parent.status.ready2resize;
                    startpoint = e.getPoint();
                    System.out.println(startpoint.x + "," + startpoint.y);
                    parent.setVisible(false);
                }
            }
            public void mouseReleased(MouseEvent e)
            {
                if(parent.status == parent.status.resizing)
                {
                    parent.status = parent.status.select;                    
                    parent.setVisible(true);
                }
            }
        });
        E.addMouseMotionListener(new MouseAdapter()
        {
            int dx, dy;
            public void mouseDragged(MouseEvent e)
            {
                if(parent.status == parent.status.ready2resize)
                {
                    parent.status = parent.status.resizing;
                    dx = e.getPoint().x - startpoint.x;// +
                    dy = e.getPoint().y - startpoint.y;
                    parent.hideOutline();
                    parent.setSize(parent.getWidth()+dx,parent.getHeight());                    
                    parent.setLocation(parent.getLocation().x,parent.getLocation().y);
                    startpoint = e.getPoint();
                    parent.showOutline();
                    
                }
                else if(parent.status == parent.status.resizing)
                {
                    dx = e.getPoint().x - startpoint.x;
                    dy = e.getPoint().y - startpoint.y;
                    parent.hideOutline();
                    parent.setSize(parent.getWidth()+dx,parent.getHeight());                    
                    parent.setLocation(parent.getLocation().x,parent.getLocation().y);
                    startpoint = e.getPoint();
                    parent.showOutline();
                }
            }
        });
        SE = new Panel();
        SE.setBackground(Color.red);
        SE.setSize(7,7);
        SE.setLocation(parent.getLocation().x+ parent.getWidth()+2,
                       parent.getLocation().y+parent.getHeight()+2);//抓到起始點+上拉行距離  +2是因為點是7*7 線寬1 外框與內框差5 故+2
        //System.out.println(parent.getLocation().x + "," + parent.getLocation().y);
        parent.parent.add(SE);
        SE.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if(parent.status == parent.status.select)
                {
                    parent.status = parent.status.ready2resize;
                    startpoint = e.getPoint();
                    System.out.println(startpoint.x + "," + startpoint.y);
                    parent.setVisible(false);
                }
            }
            public void mouseReleased(MouseEvent e)
            {
                if(parent.status == parent.status.resizing)
                {
                    parent.status = parent.status.select;                    
                    parent.setVisible(true);                 
                }
            }
        });
        SE.addMouseMotionListener(new MouseAdapter()
        {
            int dx, dy;
            public void mouseDragged(MouseEvent e)
            {
                if(parent.status == parent.status.ready2resize)
                {
                    parent.status = parent.status.resizing;
                    dx = e.getPoint().x - startpoint.x;
                    dy = e.getPoint().y - startpoint.y;
                    parent.hideOutline();
                    parent.setSize(parent.getWidth()+dx,parent.getHeight()+dy);
                    startpoint = e.getPoint();
                    parent.showOutline();
                    
                }
                else if(parent.status == parent.status.resizing)
                {
                    dx = e.getPoint().x - startpoint.x;
                    dy = e.getPoint().y - startpoint.y;
                    parent.hideOutline();
                    System.out.println("hideoutline");
                    parent.setSize(parent.getWidth()+dx,parent.getHeight()+dy);
                    startpoint = e.getPoint();
                    parent.showOutline();
                    System.out.println("showoutline");
                }
            }
        });
        S = new Panel();
        S.setBackground(Color.red);
        S.setSize(7,7);
        S.setLocation(parent.getLocation().x+ parent.getWidth()/2-3,
                       parent.getLocation().y+parent.getHeight()+2);
        parent.parent.add(S);
        S.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if(parent.status == parent.status.select)
                {
                    parent.status = parent.status.ready2resize;
                    startpoint = e.getPoint();
                    System.out.println(startpoint.x + "," + startpoint.y);
                    parent.setVisible(false);
                }
            }
            public void mouseReleased(MouseEvent e)
            {
                if(parent.status == parent.status.resizing)
                {
                    parent.status = parent.status.select;                    
                    parent.setVisible(true);
                }
            }
        });
        S.addMouseMotionListener(new MouseAdapter()
        {
            int dx, dy;
            public void mouseDragged(MouseEvent e)
            {
                if(parent.status == parent.status.ready2resize)
                {
                    parent.status = parent.status.resizing;
                    dx = e.getPoint().x - startpoint.x;
                    dy = e.getPoint().y - startpoint.y;
                    parent.hideOutline();
                    parent.setSize(parent.getWidth(),parent.getHeight()+dy);            
                    parent.setLocation(parent.getLocation().x,parent.getLocation().y);
                    startpoint = e.getPoint();
                    parent.showOutline();
                }
                else if(parent.status == parent.status.resizing)
                {
                    dx = e.getPoint().x - startpoint.x;
                    dy = e.getPoint().y - startpoint.y;
                    parent.hideOutline();
                    parent.setSize(parent.getWidth(),parent.getHeight()+dy);            
                    parent.setLocation(parent.getLocation().x,parent.getLocation().y);
                    startpoint = e.getPoint();
                    parent.showOutline();
                }
            }
        });
        SW = new Panel();
        SW.setBackground(Color.red);
        SW.setSize(7,7);
        SW.setLocation(parent.getLocation().x-8,
                       parent.getLocation().y+parent.getHeight()+2);
        parent.parent.add(SW);
        SW.addMouseListener(new MouseAdapter()
        {
             public void mousePressed(MouseEvent e)
            {
                if(parent.status == parent.status.select)
                {
                    parent.status = parent.status.ready2resize;
                    startpoint = e.getPoint();
                    System.out.println(startpoint.x + "," + startpoint.y);
                    parent.setVisible(false);
                }
            }
            public void mouseReleased(MouseEvent e)
            {
                if(parent.status == parent.status.resizing)
                {
                    parent.status = parent.status.select;                    
                    parent.setVisible(true);
                }
            }
        });
        SW.addMouseMotionListener(new MouseAdapter()
        {
            int dx, dy;
            public void mouseDragged(MouseEvent e)
            {
                if(parent.status == parent.status.ready2resize)
                {
                    parent.status = parent.status.resizing;
                    dx = e.getPoint().x - startpoint.x;// -
                    dy = e.getPoint().y - startpoint.y;
                    parent.hideOutline();
                    parent.setSize(parent.getWidth() - dx,parent.getHeight()+dy);
                    parent.setLocation(parent.getLocation().x+dx,parent.getLocation().y);
                    startpoint = e.getPoint();
                    parent.showOutline();
                }
                else if(parent.status == parent.status.resizing)
                {
                    dx = e.getPoint().x - startpoint.x;
                    dy = e.getPoint().y - startpoint.y;
                    parent.hideOutline();
                    parent.setSize(parent.getWidth() - dx,parent.getHeight()+dy);
                    parent.setLocation(parent.getLocation().x+dx,parent.getLocation().y);
                    startpoint = e.getPoint();
                    parent.showOutline();
                }
            }
        });
        W = new Panel();
        W.setBackground(Color.red);
        W.setSize(7,7);
        W.setLocation(parent.getLocation().x-8,
                       parent.getLocation().y+parent.getHeight()/2-3);        
        parent.parent.add(W);                     
        W.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if(parent.status == parent.status.select)
                {
                    parent.status = parent.status.ready2resize;
                    startpoint = e.getPoint();
                    System.out.println(startpoint.x + "," + startpoint.y);
                    parent.setVisible(false);
                }
            }
            public void mouseReleased(MouseEvent e)
            {
                if(parent.status == parent.status.resizing)
                {
                    parent.status = parent.status.select;                    
                    parent.setVisible(true);
                }
            }
        });
        W.addMouseMotionListener(new MouseAdapter()
        {
            int dx, dy;
            public void mouseDragged(MouseEvent e)
            {
                if(parent.status == parent.status.ready2resize)
                {
                    parent.status = parent.status.resizing;
                    dx = e.getPoint().x - startpoint.x;// -
                    dy = e.getPoint().y - startpoint.y;
                    parent.hideOutline();
                    parent.setSize(parent.getWidth()-dx,parent.getHeight());
                    parent.setLocation(parent.getLocation().x+dx,parent.getLocation().y);
                    startpoint = e.getPoint();
                    parent.showOutline();
                    
                }
                else if(parent.status == parent.status.resizing)
                {
                    dx = e.getPoint().x - startpoint.x;
                    dy = e.getPoint().y - startpoint.y;
                    parent.hideOutline();
                    parent.setSize(parent.getWidth()-dx,parent.getHeight());
                    parent.setLocation(parent.getLocation().x+dx,parent.getLocation().y);
                    startpoint = e.getPoint();
                    parent.showOutline();
                }
            }
        });
        NW = new Panel();
        NW.setBackground(Color.red);
        NW.setSize(7,7);
        NW.setLocation(parent.getLocation().x-8,
                       parent.getLocation().y-8);        
        parent.parent.add(NW);
        NW.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if(parent.status == parent.status.select)
                {
                    parent.status = parent.status.ready2resize;
                    startpoint = e.getPoint();
                    System.out.println(startpoint.x + "," + startpoint.y);
                    parent.setVisible(false);
                }
            }
            public void mouseReleased(MouseEvent e)
            {
                if(parent.status == parent.status.resizing)
                {
                    parent.status = parent.status.select;                    
                    parent.setVisible(true);
                }
            }
        });      
        NW.addMouseMotionListener(new MouseAdapter()
        {
            int dx, dy;
            public void mouseDragged(MouseEvent e)
            {
                if(parent.status == parent.status.ready2resize)
                {
                    parent.status = parent.status.resizing;
                    dx = e.getPoint().x - startpoint.x;// -
                    dy = e.getPoint().y - startpoint.y;// -
                    parent.hideOutline();
                    parent.setSize(parent.getWidth()-dx,parent.getHeight()-dy);
                    parent.setLocation(parent.getLocation().x+dx,parent.getLocation().y+dy);
                    startpoint = e.getPoint();
                    parent.showOutline();
                    
                }
                else if(parent.status == parent.status.resizing)
                {
                    dx = e.getPoint().x - startpoint.x;
                    dy = e.getPoint().y - startpoint.y;
                    parent.hideOutline();
                    parent.setSize(parent.getWidth()-dx,parent.getHeight()-dy);
                    parent.setLocation(parent.getLocation().x+dx,parent.getLocation().y+dy);
                    startpoint = e.getPoint();
                    parent.showOutline();
                }
            }
        });
    }
    void show()
    {
        Graphics g = parent.parent.getGraphics();
        g.setXORMode(Color.green);
        g.drawRect(parent.getLocation().x-5, parent.getLocation().y-5, parent.getWidth()+10, parent.getHeight()+10);                        
        N.setLocation(parent.getLocation().x+ parent.getWidth()/2-3,parent.getLocation().y-8);
        N.setVisible(true);
        NE.setLocation(parent.getLocation().x+ parent.getWidth()+2,parent.getLocation().y-9);
        NE.setVisible(true);
        E.setLocation(parent.getLocation().x+ parent.getWidth()+2,parent.getLocation().y+parent.getHeight()/2-3);
        E.setVisible(true);
        SE.setLocation(parent.getLocation().x+parent.getWidth()+2, parent.getLocation().y+parent.getHeight()+2);
        SE.setVisible(true);        
        S.setLocation(parent.getLocation().x+ parent.getWidth()/2-3,parent.getLocation().y+parent.getHeight()+2);
        S.setVisible(true);
        SW.setLocation(parent.getLocation().x-8,parent.getLocation().y+parent.getHeight()+2);
        SW.setVisible(true);
        W.setLocation(parent.getLocation().x-8,parent.getLocation().y+parent.getHeight()/2-3);
        W.setVisible(true);
        NW.setLocation(parent.getLocation().x-8,parent.getLocation().y-8);
        NW.setVisible(true);
    }
    void hideshow()
    {
        Graphics g = parent.parent.getGraphics();
        g.setXORMode(Color.green);
        g.drawRect(parent.getLocation().x-5, parent.getLocation().y-5, parent.getWidth()+10, parent.getHeight()+10);
        N.setVisible(false);
        NE.setVisible(false);
        E.setVisible(false);
        SE.setVisible(false);
        S.setVisible(false);
        SW.setVisible(false);
        W.setVisible(false);
        NW.setVisible(false);
    }   
}
