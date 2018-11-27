package CapturedDiary;

import java.awt.Image;

class Choice
{
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

	public static Integer ReqCap(int choice)
	{
		Integer req_cap = null;

		if(choice == 1)
		{
			req_cap = Thunnus.ReqCap();
		}
		else if(choice == 2)
		{
			req_cap = Mackerel.ReqCap();
		}
		else if(choice == 3)
		{
			req_cap = Kuma.ReqCap();
		}

		return req_cap;
	}

	public static Double ReqMosS(int choice)
	{
		Double req_ms = null;

		if(choice == 1)
		{
			req_ms = Thunnus.ReqMosS();
		}
		else if(choice == 2)
		{
			req_ms = Mackerel.ReqMosS();
		}
		else if(choice == 3)
		{
			req_ms = Kuma.ReqMosS();
		}

		return req_ms;
	}

	public static Double ReqWorS(int choice)
	{
		Double req_ws = null;

		if(choice == 1)
		{
			req_ws = Thunnus.ReqWorS();
		}
		else if(choice == 2)
		{
			req_ws = Mackerel.ReqWorS();
		}
		else if(choice == 3)
		{
			req_ws = Kuma.ReqWorS();
		}

		return req_ws;
	}

	public static int ReqID(int choice)
	{
		int req_id = 0;
		if(choice == 1)
		{
			req_id = Thunnus.ReqID();
		}
		else if(choice == 2)
		{
			req_id = Mackerel.ReqID();
		}
		else if(choice == 3)
		{
			req_id = Kuma.ReqID();
		}

		return req_id;
	}

	public static Image ReqImage(int choice)
	{
		Image req_im = null;
		if(choice == 1)
		{
			req_im = Thunnus.ReqImage();
		}
		else if(choice == 2)
		{
			req_im = Mackerel.ReqImage();
		}
		else if(choice == 3)
		{
			req_im = Kuma.ReqImage();
		}

		return req_im;
	}
	
	public static Image ReqIcon(int choice)
	{
		Image req_ic = null;
		if(choice == 1)
		{
			req_ic = Thunnus.ReqIcon();
		}
		else if(choice == 2)
		{
			req_ic = Mackerel.ReqIcon();
		}
		else if(choice == 3)
		{
			req_ic = Kuma.ReqIcon();
		}

		return req_ic;
	}

	public static String ReqName(int choice)
	{
		String req_name = null;
		if(choice == 1)
		{
			req_name = Thunnus.ReqName();
		}
		else if(choice == 2)
		{
			req_name = Mackerel.ReqName();
		}
		else if(choice == 3)
		{
			req_name = Kuma.ReqName();
		}

		return req_name;
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
}














