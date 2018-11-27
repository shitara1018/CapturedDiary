package CapturedDiary;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

class Kuma extends Fish
{
	static int fish_id = 3;
	static String fish_name = "釣られクマ―";
	static Double fish_size = 180.0;
	static Double most_size = null;
	static Double worst_size = null;
	static Integer capture = null;
	static BufferedImage fish_im;

	public static void AddCap()
	{
		if(capture == null)
		{
			capture = 0;
			capture = capture + 1;
		}
		else
		{
			capture = capture + 1;
		}

		return;
	}


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

		if(capture == null) {
			req_im = Toolkit.getDefaultToolkit().getImage("./src/CapturedDiary/question.png");
		}
		else
		{
			req_im = Toolkit.getDefaultToolkit().getImage("./src/CapturedDiary/kuma.png");
		}
		return req_im;
	}

	public static Image ReqIcon()
	{
		Image req_ic = null;

		if(capture == null) {
			req_ic = Toolkit.getDefaultToolkit().getImage("./src/CapturedDiary/question.png");
		}
		else
		{
			req_ic = Toolkit.getDefaultToolkit().getImage("./src/CapturedDiary/kuma.png");
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
