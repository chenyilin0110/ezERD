package ezerd;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.lang.Math;

enum ezPagestatus{activated, inactivated, ready2draw, drawing, ready2creatobj, creatingobj}

public class ezPage extends Panel 
{
    static Color co[] ={Color.RED,Color.BLUE,Color.GREEN,Color.PINK};
    static int i=0;
    //boolean drawswitch=false;
    Point startpoint,endpoint;
    Vector<ezDrawline> draws;
    ezPagestatus status;
    ezToolbox father;
    ezObj activeobj;
    Color choosecolor;
    ezPage(ezToolbox p)
    {
        this.setLayout(null);
        father = p;
        status = status.activated;
        draws = new Vector<ezDrawline>();
        //this.setBackground(co[i%4]);
        //i++;
        this.addMouseListener(new MouseAdapter()
        {
           public void mousePressed(MouseEvent e)
           {
               if(activeobj!=null)//表已有物件在ezPage上
               {
                   //System.out.println("123");
                   if(activeobj.status == ezObjStatus.select)
                   {
                       activeobj.hideOutline();
                       activeobj.status = ezObjStatus.unselect;
                       activeobj = null;
                       System.out.println("123");
                   }
               }
               
               if(status == status.ready2draw)
               {
                   System.out.println("Pressed");
                   status = status.drawing;
                   startpoint = e.getPoint();
               }
               else if(status == status.ready2creatobj)
               {
                   System.out.println("Pressed");
                   status = status.creatingobj;
                   startpoint = e.getPoint();
                   endpoint = null;
               }
           }
        });
        this.addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                if(status == status.drawing)
                {
                    endpoint = e.getPoint();
                    Graphics pen = ezPage.this.getGraphics();
                    //pen.setColor(Color.white);                                
                    pen.setColor(choosecolor);                   
                    pen.drawLine(startpoint.x, startpoint.y, endpoint.x, endpoint.y);
                    draws.add(new ezDrawline(startpoint,endpoint));
                    startpoint = endpoint;
                }
                else if(status == status.creatingobj)
                {
                    Graphics pen = ezPage.this.getGraphics();
                    if(endpoint != null)//消除上一個圖形
                    {                        
                        pen.setXORMode(Color.green);
                        int tempx = endpoint.x - startpoint.x;
                        int tempy = endpoint.y - startpoint.y;  
                        System.out.println(endpoint.x + "," + endpoint.y);
                        if( (tempx>0) && (tempy>0) )//第四象限
                            pen.drawRect(startpoint.x, startpoint.y, tempx, tempy);
                        else if( (tempx<0) && (tempy>0) )//第三象限
                        {        
                            System.out.println("第三象限");
                            tempx=Math.abs(tempx);
                            tempy=Math.abs(tempy);
                            pen.drawRect(endpoint.x, startpoint.y, tempx, tempy);
                        }
                        else if( (tempx>0) && (tempy<0) )//第二象限
                        {         
                            System.out.println("第二象限");
                            tempx=Math.abs(tempx);
                            tempy=Math.abs(tempy);
                            pen.drawRect(startpoint.x, endpoint.y, tempx, tempy);
                        }
                        else if( (tempx<0) && (tempy<0))
                        {
                            System.out.println("第一象限");
                            tempx=Math.abs(tempx);
                            tempy=Math.abs(tempy);
                            pen.drawRect(endpoint.x, endpoint.y, tempx, tempy);
                        }
                    }
                    endpoint = e.getPoint();
                    pen.setXORMode(Color.green);
                    //pen.setColor(Color.white);
                    int tempx = endpoint.x - startpoint.x;
                    int tempy = endpoint.y - startpoint.y;                      
                    if( (tempx>0) && (tempy>0) )//第四象限
                        pen.drawRect(startpoint.x, startpoint.y, tempx, tempy);
                    else if( (tempx<0) && (tempy>0) )//第三象限
                    {                            
                        System.out.println("第三象限");
                        tempx=Math.abs(tempx);
                        tempy=Math.abs(tempy);
                        System.out.println("TEMPX"+tempx+"TEMPY"+tempy);
                        pen.drawRect(endpoint.x, startpoint.y,tempx,tempy );
                    }
                    else if( (tempx>0) && (tempy<0) )//第二象限
                    {                   
                        System.out.println("第二象限");
                        tempx=Math.abs(tempx);
                        tempy=Math.abs(tempy);
                        pen.drawRect(startpoint.x, endpoint.y, tempx, tempy);
                    }
                    else if( (tempx<0) && (tempy<0))
                    {
                        System.out.println("第一象限");
                        tempx=Math.abs(tempx);
                        tempy=Math.abs(tempy);
                        pen.drawRect(endpoint.x, endpoint.y, tempx, tempy);
                    }
                    //pen.drawRect(startpoint.x,startpoint.y ,endpoint.x - startpoint.x, endpoint.y - startpoint.y);
                }
            }
        });
        this.addMouseListener(new MouseAdapter()
        {
            public void mouseReleased(MouseEvent e)
            {
                if(status == status.drawing)
                {
                    status = status.ready2draw;
                    System.out.println("Released");
                }
                else if(status == status.creatingobj)
                {
                    if( (startpoint.x != e.getPoint().x) || (startpoint.y != e.getPoint().y))
                    {
                        System.out.println("Releasedcreatobj");  
                        Graphics pen = ezPage.this.getGraphics();
                        if(endpoint != null)//消除上一個圖形
                        {                        
                            pen.setXORMode(Color.green);
                            int tempx = endpoint.x - startpoint.x;
                            int tempy = endpoint.y - startpoint.y;  
                            System.out.println(endpoint.x + "," + endpoint.y);
                            if( (tempx>0) && (tempy>0) )//第四象限
                                pen.drawRect(startpoint.x, startpoint.y, tempx, tempy);
                            else if( (tempx<0) && (tempy>0) )//第三象限
                            {        
                                System.out.println("第三象限");
                                tempx=Math.abs(tempx);
                                tempy=Math.abs(tempy);
                                pen.drawRect(endpoint.x, startpoint.y, tempx, tempy);
                            }
                            else if( (tempx>0) && (tempy<0) )//第二象限
                            {         
                                System.out.println("第二象限");
                                tempx=Math.abs(tempx);
                                tempy=Math.abs(tempy);
                                pen.drawRect(startpoint.x, endpoint.y, tempx, tempy);
                            }
                            else if( (tempx<0) && (tempy<0))
                            {
                                System.out.println("第一象限");
                                tempx=Math.abs(tempx);
                                tempy=Math.abs(tempy);
                                pen.drawRect(endpoint.x, endpoint.y, tempx, tempy);
                            }
                        }
                        int width = endpoint.x - startpoint.x;
                        int height = endpoint.y - startpoint.y;
                        int x = startpoint.x;
                        int y = startpoint.y;
                        status = ezPagestatus.ready2creatobj;
                        ezObj obj = null;
                        if(ezPage.this.father.objtype == ezPage.this.father.objtype.ES)//長方形
                        {
                            System.out.println("draw Entity");
                            int tempx = endpoint.x - startpoint.x;
                            int tempy = endpoint.y - startpoint.y;                      
                            if( (tempx>0) && (tempy>0) )//第四象限
                                obj = new ezEntity(ezPage.this, startpoint.x, startpoint.y, tempx, tempy);                                                
                            else if( (tempx<0) && (tempy>0) )//第三象限
                            {                            
                                System.out.println("第三象限");
                                tempx=Math.abs(tempx);
                                obj = new ezEntity(ezPage.this, endpoint.x, startpoint.y, tempx, tempy);
                            }
                            else if( (tempx>0) && (tempy<0) )//第二象限
                            {                   
                                System.out.println("第二象限");
                                tempx=Math.abs(tempx);
                                tempy=Math.abs(tempy);
                                obj = new ezEntity(ezPage.this, startpoint.x, endpoint.y, tempx, tempy);                                                
                            }
                            else if( (tempx<0) && (tempy<0))
                            {
                                System.out.println("第一象限");
                                tempx=Math.abs(tempx);
                                tempy=Math.abs(tempy);
                                obj = new ezEntity(ezPage.this, endpoint.x, endpoint.y, tempx, tempy);
                            }   
                        }
                        else if(ezPage.this.father.objtype == ezPage.this.father.objtype.Rs)//菱形
                        {
                            System.out.println("draw Realtionship");
                            int tempx = endpoint.x - startpoint.x;
                            int tempy = endpoint.y - startpoint.y;                      
                            if( (tempx>0) && (tempy>0) )//第四象限
                                obj = new ezRelationship(ezPage.this, startpoint.x, startpoint.y, tempx, tempy);                                                
                            else if( (tempx<0) && (tempy>0) )//第三象限
                            {                            
                                System.out.println("第三象限");
                                tempx=Math.abs(tempx);
                                obj = new ezRelationship(ezPage.this, endpoint.x, startpoint.y, tempx, tempy);
                            }
                            else if( (tempx>0) && (tempy<0) )//第二象限
                            {                   
                                System.out.println("第二象限");
                                tempx=Math.abs(tempx);
                                tempy=Math.abs(tempy);
                                obj = new ezRelationship(ezPage.this, startpoint.x, endpoint.y, tempx, tempy);                                                
                            }
                            else if( (tempx<0) && (tempy<0))
                            {
                                System.out.println("第一象限");
                                tempx=Math.abs(tempx);
                                tempy=Math.abs(tempy);
                                obj = new ezRelationship(ezPage.this, endpoint.x, endpoint.y, tempx, tempy);
                            }   
                        }
                        else if(ezPage.this.father.objtype == ezPage.this.father.objtype.AT)
                        {
                            System.out.println("draw Attribute");
                            int tempx = endpoint.x - startpoint.x;
                            int tempy = endpoint.y - startpoint.y;                      
                            if( (tempx>0) && (tempy>0) )//第四象限
                                obj = new ezAttribute(ezPage.this, startpoint.x, startpoint.y, tempx, tempy);                                                
                            else if( (tempx<0) && (tempy>0) )//第三象限
                            {                            
                                System.out.println("第三象限");
                                tempx=Math.abs(tempx);
                                obj = new ezAttribute(ezPage.this, endpoint.x, startpoint.y, tempx, tempy);
                            }
                            else if( (tempx>0) && (tempy<0) )//第二象限
                            {                   
                                System.out.println("第二象限");
                                tempx=Math.abs(tempx);
                                tempy=Math.abs(tempy);
                                obj = new ezAttribute(ezPage.this, startpoint.x, endpoint.y, tempx, tempy);                                                
                            }
                            else if( (tempx<0) && (tempy<0))
                            {
                                System.out.println("第一象限");
                                tempx=Math.abs(tempx);
                                tempy=Math.abs(tempy);
                                obj = new ezAttribute(ezPage.this, endpoint.x, endpoint.y, tempx, tempy);
                            }
                        }
                        else
                        {
                            System.out.println("draw Triangle");
                            int tempx = endpoint.x - startpoint.x;
                            int tempy = endpoint.y - startpoint.y;                      
                            if( (tempx>0) && (tempy>0) )//第四象限
                                obj = new ezTriangle(ezPage.this, startpoint.x, startpoint.y, tempx, tempy);                                                
                            else if( (tempx<0) && (tempy>0) )//第三象限
                            {                            
                                System.out.println("第三象限");
                                tempx=Math.abs(tempx);
                                obj = new ezTriangle(ezPage.this, endpoint.x, startpoint.y, tempx, tempy);
                            }
                            else if( (tempx>0) && (tempy<0) )//第二象限
                            {                   
                                System.out.println("第二象限");
                                tempx=Math.abs(tempx);
                                tempy=Math.abs(tempy);
                                obj = new ezTriangle(ezPage.this, startpoint.x, endpoint.y, tempx, tempy);                                                
                            }
                            else if( (tempx<0) && (tempy<0))
                            {
                                System.out.println("第一象限");
                                tempx=Math.abs(tempx);
                                tempy=Math.abs(tempy);
                                obj = new ezTriangle(ezPage.this, endpoint.x, endpoint.y, tempx, tempy);
                            }
                        }
                        if(ezPage.this.activeobj!=null)//如果已經有物件了 那就做上一個物件外框清除                        
                        {
                            activeobj.hideOutline();
                        }
                        ezPage.this.activeobj = obj;
                        ezPage.this.add(obj);
                    }
                    ezPage.this.status = ezPage.this.status.ready2creatobj;
                }    
            }
        });
    }
    public void paint(Graphics drawpen)
    {
        drawpen.setColor(Color.green);
        for(ezDrawline f:draws)//從第一筆畫到draws的最後一筆
            drawpen.drawLine(f.s.x, f.s.y, f.e.x, f.e.y);
        if(activeobj!=null)
        {
            activeobj.showOutline();
        }
    }
}

