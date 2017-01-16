package ezerd;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
public class ezERD 
{
    ezMainWin mainwin;
    ezToolbox toolbox;
    ezMessage message;
    ezPage workpage;
    static int now=0,total=1;
    Vector<ezPage> pages;
    ezERD()
    {
        mainwin = new ezMainWin(this);
        toolbox = new ezToolbox(this);
        message = new ezMessage(this);
        mainwin.setToolbox(toolbox);
        mainwin.setMessage(message);
        pages = new Vector<ezPage>();
        ezPage first = new ezPage(toolbox);
        workpage = null;
        mainwin.addpage(first);
    }
    public void run()
    {
        mainwin.setVisible(true);
    }
}
