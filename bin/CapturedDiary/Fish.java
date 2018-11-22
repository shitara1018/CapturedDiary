package CapturedDiary;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

class Fish 
{
	
	static int fish_id;
	static String fish_name;
	static String exte;
	static Double fish_size = null;
	static Double most_size = null;
	static Double worst_size = null;
	static Integer capture = null;
	static BufferedImage fish_im;
	
	public static void Addcap() 
	{
		if(capture == null) 
		{
			capture = 0;
			capture = capture++;
		}
		else if(capture > 0) {
			capture = capture++;
		}
	}
	
	public static void BigCheck(double cap_size) 
	{
		if(most_size == null) 
		{
			most_size = cap_size;
		}
		else if(most_size != null && cap_size > most_size) 
		{
			most_size = cap_size;
		}
		else {
			;
		}
	}
	
	public static void SmallCheck(double cap_size) 
	{
		if(worst_size == null) 
		{
			worst_size = cap_size;
		}
		else if(worst_size != null && cap_size < worst_size)
		{
			worst_size = cap_size;
		}
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
			req_im = fish_im;
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
