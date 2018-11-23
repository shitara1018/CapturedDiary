package CapturedDiary;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Mackerel extends Fish {
	static int fish_id = 2;
	static String fish_name = "サバ";
	static Double fish_size = 25.0;
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
			try 
			{
				req_im = ImageIO.read(new File("question.jpg"));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else 
		{
			try
			{
				req_im = ImageIO.read(new File("mackerel.jpg"));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return req_im;
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
