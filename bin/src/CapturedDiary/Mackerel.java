package CapturedDiary;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Mackerel extends Fish {
	static int fish_id = 2;
	static String fish_name = "サバ";
	static Double fish_size = 25.0;
	static BufferedImage fish_im;
	
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
	
}
