import java.util.Calendar;
import java.util.Locale;
import java.text.DateFormatSymbols;
import java.util.Scanner;
public class month
{
	public void ptr()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("��ѡ�����ڣ��Ҿ��ܸ�����ʾ��������:");
		int myYear = sc.nextInt();
		int myMonth = sc.nextInt();
		Calendar cd = Calendar.getInstance();
		int myDay = cd.get(Calendar.DAY_OF_MONTH);
		cd.set(myYear,myMonth-1,myDay);//������ǰ����
		//��Ҫ�õ��Ĳ���
		int maxweek = cd.getActualMaximum(Calendar.DAY_OF_WEEK);
		int weekday = cd.get(Calendar.DAY_OF_WEEK);
		int firstday = cd.getFirstDayOfWeek();
		String [] titleWeek = new DateFormatSymbols().getShortWeekdays();
		//��ӡ��������
		for(int i=1;i<=maxweek;i++)
		{
			System.out.print(titleWeek[i]+"\t");
		}
		System.out.println();
		//ȷ��һ���µ�һ��
		int space = 0;
		if(myDay!=weekday)
		{
			cd.add(Calendar.DAY_OF_MONTH,-1);
			weekday = cd.get(Calendar.DAY_OF_WEEK);
			space++;
		}
		//��ӡ����
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
		//����
		System.out.println();
	}

	public static void main(String[]args)
	{
		Locale.setDefault(Locale.US);
		month mm = new month();
		mm.ptr();
	}
}