package CapturedDiary;

import java.awt.*;
import java.awt.event.*;

class Preframe extends Frame{


	public PreFrame(String title) {
		setTitle(title);


		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}

public class MainMenu {


	public static void main(String args[]) {
		PreFrame frm = new PreFrame("釣られ日誌");
		frm.setLocation(640.480);
		frm.setSize(640,480);
		frm.setBackground(Color.LIGHT_GRAY);
		frm.setVisible(true);

		Button start = new Button();
		start.setLabel("ゲーム開始");
		frm.add(start);

		Button lib = new Button();
		lib.setLabel("図鑑");
		frm.add(lib);

	}
}
