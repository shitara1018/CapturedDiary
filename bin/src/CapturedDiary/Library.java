package CapturedDiary;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
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

		ImageIcon thun_ic = new ImageIcon((Thunnus.ReqImage()));
		String thun_name = Thunnus.ReqName();
		JButton thun_bt = new JButton(thun_ic);
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


		String kuma_name = Kuma.ReqName();
		JButton kuma_bt = new JButton();
		kuma_bt.setSize(bts_x, bts_y);
		kuma_bt.setLocation(SetButton.SetPointX(sws_x, bts_x), SetButton.SetPointY(sws_y, bts_y));
		add(kuma_bt);
		if(Kuma.ReqCap() != null)
		{
			kuma_bt.addActionListener(new KumaPush());
		}
		Label kuma_lb = new Label(kuma_name);
		kuma_lb.setSize(lbs_x, lbs_y);
		kuma_lb.setFont(new Font("Arial", Font.PLAIN,20));
		kuma_lb.setLocation(SetLabel.SetPointX(sws_x, lbs_x), SetLabel.SetPointY(sws_y, lbs_y, bts_y));
		add(kuma_lb);

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
		if(cnt_j > 4)
		{
			cnt_j = 1;
			cnt_i++;
		}
		int pt_x;
		pt_x = (sws_x / 5) * cnt_j - (bts_x / 2);
		cnt_j++;
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
		if(cnt_j > 4)
		{
			cnt_j = 1;
			cnt_i++;
		}
		int pt_x;
		pt_x = (sws_x / 5) * cnt_j - (lbs_x / 2);
		cnt_j++;
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


class ThunPush implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		ChapterWindow cp = new ChapterWindow("マグロ", 1);
		cp.setVisible(true);
	}
}


class MackPush implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		ChapterWindow cp = new ChapterWindow("サバ", 2);
		cp.setVisible(true);
	}
}


class KumaPush implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		ChapterWindow cp = new ChapterWindow("釣られクマ―", 3);
		cp.setVisible(true);
	}
}


class ChapterWindow extends Frame
{
	public ChapterWindow(String title, int fish_id)
	{
		int sws_x = 640;
		int sws_y = 490;
		int lbs_x = 80;
		int lbs_y = 20;
		int font_sz = 10;

		/*Image fish_im = Choice.ReqImage(fish_id);*/
		String fish_name = Choice.ReqName(fish_id);
		Integer capture = Choice.ReqCap(fish_id);
		Double fish_size = Choice.ReqSiz(fish_id);
		Double most_size = Choice.ReqMosS(fish_id);
		Double worst_size = Choice.ReqWorS(fish_id);

		setTitle(title);
		setSize(sws_x, sws_y);
		setLayout(null);

	    Label name_lb = new Label("名前：" + fish_name);
	    name_lb.setSize(lbs_x, lbs_y);
	    name_lb.setFont(new Font("Arial", Font.PLAIN, font_sz));
	    name_lb.setLocation(sws_x / 3 * 1 - lbs_x / 2, sws_y / 5 * 3 - lbs_y /2);
	    add(name_lb);

		Label cap_lb = new Label("捕獲数：" + String.valueOf(capture));
		cap_lb.setSize(lbs_x, lbs_y);
	    cap_lb.setFont(new Font("Arial", Font.PLAIN, font_sz));
	    cap_lb.setLocation(sws_x / 3 * 2 - lbs_x / 2, sws_y / 5 * 3 - lbs_y /2);
	    add(cap_lb);

	    Label fs_lb = new Label("平均サイズ：" + String.valueOf(fish_size));
	    fs_lb.setSize(lbs_x, lbs_y);
	    fs_lb.setFont(new Font("Arial", Font.PLAIN, font_sz));
	    fs_lb.setLocation(sws_x / 4 * 1 - lbs_x / 2, sws_y / 5 * 4 - lbs_y /2);
	    add(fs_lb);

		Label ms_lb = new Label("最大サイズ：" + String.valueOf(most_size));
		ms_lb.setSize(lbs_x, lbs_y);
		ms_lb.setFont(new Font("Arial", Font.PLAIN, font_sz));
		ms_lb.setLocation(sws_x / 4 * 2 - lbs_x / 2, sws_y / 5 * 4 - lbs_y /2);
		add(ms_lb);

		Label ws_lb = new Label("最小サイズ:" + String.valueOf(worst_size));
		ws_lb.setSize(lbs_x, lbs_y);
		ws_lb.setFont(new Font("Arial", Font.PLAIN, font_sz));
		ws_lb.setLocation(sws_x / 4 * 3 - lbs_x / 2, sws_y / 5 * 4 - lbs_y /2);
		add(ws_lb);

		addWindowListener(new LibraryExit());
	}
}









