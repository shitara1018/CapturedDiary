package CapturedDiary;

import java.io.File;

import javax.imageio.ImageIO;

class Thunnus extends Fish 
{	
	Thunnus() 
	{
		fish_id = 1;
		fish_name = "マグロ";
		fish_size = 150.0; 
		try
		{
			fish_im = ImageIO.read(new File("thunnus.jpg"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
