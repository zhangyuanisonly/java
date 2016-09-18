import java.util.Calendar;
import java.util.Locale;
import java.text.DateFormatSymbols;
import java.util.Scanner;
public class month
{
	public void ptr()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("你选个日期，我就能给你显示当月日历:");
		int myYear = sc.nextInt();
		int myMonth = sc.nextInt();
		Calendar cd = Calendar.getInstance();
		int myDay = cd.get(Calendar.DAY_OF_MONTH);
		cd.set(myYear,myMonth-1,myDay);//调整当前日期
		//需要用到的参数
		int maxweek = cd.getActualMaximum(Calendar.DAY_OF_WEEK);
		int weekday = cd.get(Calendar.DAY_OF_WEEK);
		int firstday = cd.getFirstDayOfWeek();
		String [] titleWeek = new DateFormatSymbols().getShortWeekdays();
		//打印标题星期
		for(int i=1;i<=maxweek;i++)
		{
			System.out.print(titleWeek[i]+"\t");
		}
		System.out.println();
		//确定一个月第一天
		int space = 0;
		if(myDay!=weekday)
		{
			cd.add(Calendar.DAY_OF_MONTH,-1);
			weekday = cd.get(Calendar.DAY_OF_WEEK);
			space++;
		}
		//打印日历
		cd.set(myDay,1);
		if(myMonth-1==cd.get(Calendar.MONTH))
		{
			for(int i=1;i<space;i++)
			{
				System.out.print("\t");
			}
			System.out.print(myDay);
			cd.add(Calendar.DAY_OF_MONTH,1);
			myDay = cd.get(Calendar.DAY_OF_MONTH);
		}
		//换行
		System.out.println();
	}

	public static void main(String[]args)
	{
		Locale.setDefault(Locale.US);
		month mm = new month();
		mm.ptr();
	}
}