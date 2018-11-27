package CapturedDiary;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

class Thunnus extends Fish
{
	static int fish_id = 1;
	static String fish_name = "マグロ";
	static Double fish_size = 150.0;
	static Double most_size = null;
	static Double worst_size = null;
	static Integer capture = null;
	static BufferedImage fish_im;

	public static void AddCap()
	{
		if(capture == null)
		{
			capture = 1;
		}
		else
		{
			capture = capture + 1;
		}
	}

	/*
	Thunnus()
	{

		super.fish_id = 1;
		super.fish_name = "マグロ";
		super.fish_size = 150.0;
		try
		{
			fish_im = ImageIO.read(new File("thunnus.jpg"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	*/
	/*
	public static void Addcap()
	{
		if(capture == null)
		{
			capture = 0;
			capture = capture++;
		}
		else if(capture > 0)
		{
			capture = capture++;
		}
	}
	*/
	public static boolean BigCheck(double cap_size)
	{
		boolean result = false;

		if(most_size == null)
		{
			most_size = cap_size;
			result = true;
		}
		else if(most_size != null && cap_size > most_size)
		{
			most_size = cap_size;
			result = true;
		}
		return result;
	}

	public static boolean SmallCheck(double cap_size)
	{
		boolean result = false;

		if(worst_size == null)
		{
			worst_size = cap_size;
			result = true;
		}
		else if(worst_size != null && cap_size < worst_size)
		{
			worst_size = cap_size;
			result = true;
		}

		return result;
	}


	public static int ReqID()
	{
		return fish_id;
	}

	public static Image ReqImage()
	{
		Image req_im = null;

		/*if(capture == null) {
			req_im = Toolkit.getDefaultToolkit().getImage("./src/CapturedDiary/question.jpg");
			try
			{
				req_im = ImageIO.read(new File("./src/CapturedDiary/question.png"));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}*/
		/*else
		{*/
			req_im = Toolkit.getDefaultToolkit().getImage("./src/CapturedDiary/thunnus.jpg");
			/*
			try
			{
				req_im = ImageIO.read(new File("./src/CapturedDiary/thunnus.png"));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}*/

		req_im = req_im.getScaledInstance(150, 150, Image.SCALE_DEFAULT);

		return req_im;
	}

	public static Image ReqIcon()
	{
		Image req_ic = null;

		if(capture == null) {
			req_ic = Toolkit.getDefaultToolkit().getImage("./src/CapturedDiary/question.jpg");
		}
		else
		{
			req_ic = Toolkit.getDefaultToolkit().getImage("./src/CapturedDiary/thunnus.jpg");
		}

		req_ic = req_ic.getScaledInstance(150, 150, Image.SCALE_DEFAULT);

		return req_ic;
	}

	public static String ReqName()
	{
		String req_name = "???";
		if(capture != null)
		{
			req_name = fish_name;
		}
		return req_name;
	}

	public static Double ReqSiz()
	{
		return fish_size;
	}


	public static Integer ReqCap()
	{
		return capture;
	}

	public static Double ReqMosS()
	{
		return most_size;
	}

	public static Double ReqWorS()
	{
		return worst_size;
	}

}
