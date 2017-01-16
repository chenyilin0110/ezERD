package ezerd;
import java.awt.*;
import java.awt.event.*;

public class ezMainWin extends Frame 
{
    ezERD father;
    ezMainWin(ezERD p)
   {
       super();
       father = p;
       Dimension src = Toolkit.getDefaultToolkit().getScreenSize();
       this.setSize(1200, 700);
       this.setLocation(src.width/2-500, src.height/2-300);
       this.addWindowListener(new WindowAdapter()
       {
           public void windowClosing(WindowEvent e)
           {
               System.exit(0);
           }
       });
   }
    public void setToolbox(ezToolbox tb)
    {
        this.add(tb,BorderLayout.NORTH);
    }
    public void setMessage(ezMessage mg)
    {
        this.add(mg,BorderLayout.SOUTH);
    }
    public void addpage(ezPage p)
    {
        if(father.workpage!= null)
        {
            this.remove(father.workpage);
        }
        this.add(p,BorderLayout.CENTER);
        father.pages.add(father.now,p);
        this.validate();
        father.now++;
        father.workpage = p;     
        int a = father.pages.indexOf(father.workpage);
        System.out.println(a);
        
    }
    public void prevpage()
    {
        int a = father.pages.indexOf(father.workpage);
        ezPage prev = father.pages.elementAt(--a);
        //if(father.workpage!=null)
            this.remove(father.workpage);
        this.add(prev,BorderLayout.CENTER);
        this.validate();
        father.now--;
        father.workpage = prev;
        int b = father.pages.indexOf(father.workpage);
        System.out.println(b);
        
    }
    public void nextpage()
    {
        int a = father.pages.indexOf(father.workpage);
        ezPage next = father.pages.elementAt(++a);
        this.remove(father.workpage);
        this.add(next,BorderLayout.CENTER);
        this.validate();
        father.now++;
        father.workpage = next;        
        int c = father.pages.indexOf(father.workpage);
        System.out.println(c);
    }
    public void gofirstpage()
    {
        //int a = father.pages.indexOf(father.workpage);
        ezPage first = father.pages.elementAt(0);
        this.remove(father.workpage);
        this.add(first,BorderLayout.CENTER);
        this.validate();
        father.now = 1;//首頁
        father.workpage = first;        
    }
    public void end()
    {
        int temp;
        temp = father.total-1;
        ezPage end = father.pages.elementAt(temp);//因--father.total  會存回father.total 故要用變數
        this.remove(father.workpage);
        this.add(end,BorderLayout.CENTER);
        this.validate();
        father.now = father.total;
        father.workpage = end;        
    }
    public void removesame()
    {
        int a = father.pages.indexOf(father.workpage);
        ezPage same = father.pages.elementAt(--a);//回到上一頁
        this.remove(father.workpage);
        this.add(same,BorderLayout.CENTER);
        this.validate();
        father.now--;
        father.workpage = same;
    }
    public void remove()
    {
        int a = father.pages.indexOf(father.workpage);        
        int q = a;
        ezPage down = father.pages.elementAt(++a);//取下一頁來        
        father.pages.remove(q);
        this.remove(father.workpage);
        this.add(down,BorderLayout.CENTER);
        this.validate();
        father.workpage = down;
    }
        
}
