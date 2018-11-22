package CapturedDiary;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class Library {


	public static void main(String[] args) {
		SetButton.Refresh();
		SetLabel.Refresh();
		
		LibraryWindow lw = new LibraryWindow("図鑑");
	    lw.setVisible(true);
	}
}

class LibraryWindow extends Frame
{
	public LibraryWindow(String title)
	{
		int sws_x = 1280;
		int sws_y = 980;
		int bts_x = 150;
	    int bts_y = 150;
	    int lbs_x = 80;
	    int lbs_y = 20;

		setTitle(title);
		setSize(sws_x, sws_y);
		setLayout(null);

		/*Icon thun_ic = new ImageIcon((Thunnus.ReqImage()));*/
		String thun_name = Thunnus.ReqName();
		JButton thun_bt = new JButton(/*thun_ic*/);
		thun_bt.setSize(bts_x, bts_y);
		thun_bt.setLocation(SetButton.SetPointX(sws_x,bts_x), SetButton.SetPointY(sws_y, bts_y));
		add(thun_bt);
		if(Thunnus.ReqCap() != null) 
		{
			thun_bt.addActionListener(new ThunPush());
		}
		Label thun_lb = new Label(thun_name);
		thun_lb.setSize(lbs_x, lbs_y);
		thun_lb.setFont(new Font("Arial", Font.PLAIN,20));
		thun_lb.setLocation(SetLabel.SetPointX(sws_x, lbs_x), SetLabel.SetPointY(sws_y, lbs_y, bts_y));
		add(thun_lb);
		
		/*Icon mack_ic = new ImageIcon((Mackerel.ReqImage()))*/
		String mack_name = Mackerel.ReqName();
		JButton mack_bt = new JButton();
		mack_bt.setSize(bts_x, bts_y);
		mack_bt.setLocation(SetButton.SetPointX(sws_x, bts_x), SetButton.SetPointY(sws_y, bts_y));
		add(mack_bt);
		if(Mackerel.ReqCap() != null) 
		{
			mack_bt.addActionListener(new MackPush());
		}
		Label mack_lb = new Label(mack_name);
		mack_lb.setSize(lbs_x, lbs_y);
		mack_lb.setFont(new Font("Arial", Font.PLAIN,20));
		mack_lb.setLocation(SetLabel.SetPointX(sws_x, lbs_x), SetLabel.SetPointY(sws_y, lbs_y, bts_y));
		add(mack_lb);

		/*
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				JButton fish = new JButto"魚");
				fish.setSize(bts_x,bts_y);
				fish.setLocation((sws_x / 5) * (j + 1) - (bts_x / 2), (sws_y / 5) * (i + 1) - ( bts_y / 2) );
				add(fish);
				fish.addActionListener(new FishPush());
			}
		}
		*/

		addWindowListener(new LibraryExit());
	}
}



class SetButton
{
	static int cnt_i = 1;
	static int cnt_j = 1;
	
	public static int SetPointX(int sws_x, int bts_x)
	{
		int pt_x;
		pt_x = (sws_x / 5) * cnt_j - (bts_x / 2);
		cnt_j++;
		if(cnt_j >= 4) 
		{
			cnt_j = 1;
			cnt_i++;
		}
		return pt_x;
	}
	
	public static int SetPointY(int sws_y, int bts_y)
	{
		int pt_y;
		pt_y = (sws_y / 5) * cnt_i - (bts_y / 2);
		return pt_y;
	}
	
	public static void Refresh()
	{
		cnt_i = 1;
		cnt_j = 1;
	}
}



class SetLabel
{
	static int cnt_i = 1;
	static int cnt_j = 1;
	
	public static int SetPointX(int sws_x, int lbs_x) 
	{
		int pt_x;
		pt_x = (sws_x / 5) * cnt_j - (lbs_x / 2);
		cnt_j++;
		if(cnt_j >= 4) 
		{
			cnt_j = 1;
			cnt_i++;
		}
		return pt_x;
	}
	
	public static int SetPointY(int sws_y, int lbs_y,int bts_y)
	{
		int pt_y;
		pt_y = (sws_y / 5) * cnt_i + (lbs_y / 2) + (bts_y / 2);
		return pt_y;
	}
	
	public static void Refresh()
	{
		cnt_i = 1;
		cnt_j = 1;
	}
}



class LibraryExit extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		e.getWindow().dispose();
	}

}


/*
class FishPush implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{

	}
}
*/



class ThunPush implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		
	}
}

class MackPush implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		
	}
}










