package CapturedDiary;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainMenu
{

	public static void main(String args[]) {
		MainWindow mw = new MainWindow("釣られ日誌");
		mw.setVisible(true);
	}
}

class MainWindow extends Frame
{
	public MainWindow(String title)
	{
		setTitle(title);
	    setSize(640,480);
	    setLayout(null);

        Button start = new Button();
        start.setLabel("ゲーム開始");
        start.setSize(100,40);
        start.setLocation(270,150);
	    add(start);
	    start.addActionListener(new StartPush());

     	Button lib = new Button();
	    lib.setLabel("図鑑");
	    lib.setSize(100,40);
	    lib.setLocation(270,320);
	    add(lib);
	    lib.addActionListener(new LibPush());

	    addWindowListener(new MainExit());
	}
}

class MainExit extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);;
	}
}

class StartPush implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{

	}
}

class LibPush implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {

   }
}

