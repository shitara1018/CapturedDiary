package CapturedDiary;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Library {

	
	public static void main(String[] args) {
		LibraryWindow lw = new LibraryWindow("図鑑");
		lw.setVisible(true);
		return;
	}
}

class LibraryWindow extends Frame
{
	public LibraryWindow(String title) 
	{
		int sws_x = 1280;
		int sws_y = 980;
		
		
		setTitle(title);
		setSize(sws_x, sws_y);
		setLayout(null);
		
	    int bts_x = 150;
	    int bts_y = 150;
		
		for(int i = 1; i <= 4; i++) 
		{
			for(int j = 1; j <= 4; j++) 
			{
				Button fish = new Button();
				fish.setLabel("魚");
				fish.setSize(bts_x,bts_y);
				fish.setLocation((sws_x / 5) * j - (bts_x / 2), (sws_y / 5) * i - ( bts_y / 2) );
				add(fish);
			}
		}
		
		addWindowListener(new LibraryExit());
	}
}

class LibraryExit extends WindowAdapter
{
	public void windowClosing(WindowEvent e) 
	{
		System.exit(0);
	}
}