package CapturedDiary;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainMenu
{

	public static void main(String[] args) {
		MainWindow mw = new MainWindow("釣られ日誌");//ウィンドウタイトルを釣られ日誌に設定しオブジェクトMainWindowの呼び出し
		mw.setVisible(true);//ウィンドウ(メインメニュー)の表示
		return;
	}
}

class MainWindow extends Frame
{
	public MainWindow(String title)//文字列型タイトルを受け取り、表示するウィンドの設定
	{
		setTitle(title);
	    setSize(1280,960);
	    setLayout(null);

        Button start = new Button();//ゲームスタートボタンのセッティング
        start.setLabel("ゲーム開始");
        start.setSize(200,80);
        start.setLocation(540,300);
	    add(start);
	    start.addActionListener(new StartPush());
	    
     	Button lib = new Button();//図鑑表示ボタンのセッティング
	    lib.setLabel("図鑑");
	    lib.setSize(200,80);
	    lib.setLocation(540,600);
	    add(lib);
	    lib.addActionListener(new LibPush());
	    
	    
	    Button test = new Button();
	    test.setLabel("AddTest");
	    test.setSize(200, 80);
	    test.setLocation(1280 / 3 - 100, 960 / 5 - 40);
	    add(test);
	    test.addActionListener(new AddTest());
	    

	    addWindowListener(new MainExit());
	}
}

class MainExit extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}

class StartPush implements ActionListener
{
	private static final String[] args = null;

	public void actionPerformed(ActionEvent e)
	{
		WebCamSample.main(args);
	}
}

class LibPush implements ActionListener
{
   private static final String[] args = null;

   public void actionPerformed(ActionEvent e)
   {
       Library.main(args);
   }
}




class AddTest implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		Thunnus.AddCap();
	}
}

