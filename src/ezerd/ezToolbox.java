package ezerd;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.*;
enum ezObjtype{ES, Rs, AT,TR}

public class ezToolbox extends Panel 
{
    ezERD father;
    ezObjtype objtype;
    ezColor color;
    int R,G,B;
    boolean choosecolorswitch=false;
    ezToolbox(ezERD p)
    {
        father = p;
        this.setBackground(Color.gray);
        this.setLayout(new FlowLayout());
        Button newpage = new Button("New");
        this.add(newpage);
        newpage.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                ezPage newone = new ezPage(ezToolbox.this);
                father.mainwin.addpage(newone);
                father.total++;
                father.message.updatemessage(father.now, father.total);
            }
        });
        Button prevpage = new Button("Prev");
        this.add(prevpage);
        prevpage.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(father.now != 1)
                {
                    father.mainwin.prevpage();
                    father.message.updatemessage(father.now, father.total);
                }
            }
        });
        Button nextpage = new Button("Next");
        this.add(nextpage);
        nextpage.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
               
                if(father.now != father.total)
                {
                     //System.out.println("NO");
                    father.mainwin.nextpage();
                    father.message.updatemessage(father.now, father.total);
                }
            }
        });        
        Button remove = new Button("RemovePage");
        this.add(remove);
        remove.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if( (father.now == 1) && (father.total == 1) )//先判斷是不是在首頁
                {
                    System.out.println("You can't remove Firstpage");
                }
                else if(father.now == father.total)
                {
                    System.out.println("end");
                    father.mainwin.removesame();
                    father.total--;
                    father.message.updatemessage(father.now, father.total);
                } 
                else if(father.now != father.total)
                {
                    father.mainwin.remove();
                    father.total--;
                    father.message.updatemessage(father.now, father.total);
                }               
            }
        });
        Button draw = new Button("Draw");
        this.add(draw);
        draw.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(father.workpage.status == father.workpage.status.activated)
                {
                        father.workpage.status = father.workpage.status.ready2draw;
                }
                else if(father.workpage.status == father.workpage.status.ready2creatobj)
                {
                        father.workpage.status = father.workpage.status.ready2draw;
                }
                //father.workpage.drawswitch = true;
            }
        });
        Button entity = new Button("Entity");
        this.add(entity);
        entity.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                objtype = objtype.ES;
                if(father.workpage.status == father.workpage.status.activated)
                {
                    father.workpage.status = father.workpage.status.ready2creatobj;
                }
                else if(father.workpage.status == father.workpage.status.ready2draw)
                {
                    father.workpage.status = father.workpage.status.ready2creatobj;
                }
            }
        });
        Button relationship = new Button("Relationship");
        this.add(relationship);
        relationship.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                objtype = objtype.Rs;
                if(father.workpage.status == father.workpage.status.activated)
                {
                    father.workpage.status = father.workpage.status.ready2creatobj;
                }
                else if(father.workpage.status == father.workpage.status.ready2draw)
                {
                    father.workpage.status = father.workpage.status.ready2creatobj;
                }
            }
        });
        Button attribute = new Button("Attribute");
        this.add(attribute);
        attribute.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                objtype = objtype.AT;
                if(father.workpage.status == father.workpage.status.activated)
                {
                    father.workpage.status = father.workpage.status.ready2creatobj;
                }
                else if(father.workpage.status == father.workpage.status.ready2draw)
                {
                    father.workpage.status = father.workpage.status.ready2creatobj;
                }
            }
        });
        Button triangle = new Button("Triangle");
        this.add(triangle);
        triangle.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            { 
                objtype = objtype.TR;
                if(father.workpage.status == father.workpage.status.activated)
                {
                    father.workpage.status = father.workpage.status.ready2creatobj;
                }
                else if(father.workpage.status == father.workpage.status.ready2draw)
                {
                    father.workpage.status = father.workpage.status.ready2creatobj;
                }                                
            }
        });
        Button choosecolor = new Button("Choose Color");
        this.add(choosecolor);
        choosecolor.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                color = new ezColor(ezToolbox.this);                                                 
            }
        });
        JButton delet = new JButton(new ImageIcon("1241243029-1.png"));
        //delet.setBounds(20,20,30, 30);
        this.add(delet);
        delet.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            { 
                if(father.workpage.activeobj != null)
                {
                    father.workpage.activeobj.setVisible(false);
                    father.workpage.activeobj.hideOutline();
                    father.workpage.activeobj = null;
                }                                
            }
        });
        Button first = new Button("FirstPage");
        this.add(first);
        first.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(father.now != 1)
                {
                    System.out.println("First");
                    father.mainwin.gofirstpage();
                    father.message.updatemessage(father.now, father.total);
                }
            }
        });
        Button end = new Button("EndPage");
        this.add(end);
        end.addMouseListener(new MouseAdapter()
        {
           public void mouseClicked(MouseEvent e)
           {
               if(father.now != father.total)
               {
                   System.out.println("End");
                   father.mainwin.end();
                   father.message.updatemessage(father.now, father.total);
               }
           }
        });
    }
}
