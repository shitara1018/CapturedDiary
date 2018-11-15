package CapturedDiary;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainMenu {

	public static void main(String args[]) {
		MainWindow m = new MainWindow();
		m.setVisible(true);
	}
}

class MainWindow extends Frame {
	public MainWindow() {
	    setSize(640,480);
	    setLayout(new FlowLayout());
        Button start = new Button();
        start.setLabel("ゲーム開始");
	    add(start);
     	Button lib = new Button();
	    lib.setLabel("図鑑");
	    add(lib);
	    addWindowListener(new MainExit());
	}
}

class MainExit extends WindowAdapter
{
	public void windowClosing(WindowEvent e) {
		System.exit(0);;
	}
}