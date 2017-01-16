package ezerd;
import java.awt.*;
import java.awt.event.*;

public class ezMessage extends Panel
{
    String message;
    Label show;
    ezMessage(ezERD p)
    {
        this.setBackground(Color.gray);
        this.setLayout(new FlowLayout());
        message = "1/1";
        showmessage(message);
    }
    public void showmessage(String s)
    {
        show  = new Label(s);
        this.add(show);
    }
    public void updatemessage(int n, int t)
    {
        show.setText(" " + n + "/" + t );
    }
}
