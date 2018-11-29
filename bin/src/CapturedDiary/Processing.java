package CapturedDiary;

import java.util.Random;

class Processing 
{
	
	public static int CapCon()
	{
		Random r = new Random();
		int fish_id = r.nextInt(3) + 1;
		return fish_id;
	}
	
	public static void AddCap(int choice)
	{
		if(choice == 1)
		{
			Thunnus.AddCap();
		}
		else if(choice == 2)
		{
			Mackerel.AddCap();
		}
		else if(choice == 3)
		{
			Kuma.AddCap();
		}
	}
	
	public static Double ReqSiz(int choice)
	{
		Double req_siz = null;
		if(choice == 1)
		{
			req_siz = Thunnus.ReqSiz();
		}
		else if(choice == 2)
		{
			req_siz = Mackerel.ReqSiz();
		}
		else if(choice == 3)
		{
			req_siz = Kuma.ReqSiz();
		}
		
		return req_siz;
	}
	
	public static double SizCon(double cap_size)
	{
		cap_size = cap_size * (Math.random() + 0.5);
		return cap_size;
	}

	public static boolean BigCheck(int choice, double cap_size)
	{
		boolean result = false;

		if(choice == 1)
		{
			result = Thunnus.BigCheck(cap_size);
		}
		else if(choice == 2)
		{
			result = Mackerel.BigCheck(cap_size);
		}
		else if(choice == 3)
		{
			result = Kuma.BigCheck(cap_size);
		}

		return result;
	}

	public static boolean SmallCheck(int choice, double cap_size)
	{
		boolean result = false;

		if(choice == 1)
		{
			result = Thunnus.SmallCheck(cap_size);
		}
		else if(choice == 2)
		{
			result = Mackerel.SmallCheck(cap_size);
		}
		else if(choice == 3)
		{
			result = Kuma.SmallCheck(cap_size);
		}

		return result;
	}

}
