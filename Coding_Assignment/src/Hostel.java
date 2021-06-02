import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Hostel 
{
	public static void main(String[] args) throws ParseException 
	{
		// Scanner Class for Taking User Input From Console
		Scanner sc=new Scanner(System.in);
		
		// This is fixed that we can admit maximum 20 student at a time.
		int testCase=20;
		
		// Variable Type and Name
//		String id[]=new String[testCase];
		List<String> id=new ArrayList<String>();
		String name[]=new String[testCase];
		int age[]=new int[testCase];
		Date date[]=new Date[testCase];
	
		// For Test Cases
		String data[]=new String[testCase];
		
		// For Breaking when EOS come
		int EOS=0;
		
		for(int i=0;i<testCase;i++)
		{
			data[i]=sc.nextLine();	
			String dataArray[]=data[i].split(" ");
			
			if(dataArray[0].equalsIgnoreCase("EOS"))
			{
				break;
			}
			else
			{
//				id[i]=dataArray[0];
				id.add(dataArray[0]);
				name[i]=dataArray[1];
				age[i]=Integer.parseInt(dataArray[2]);
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String tempDate=dataArray[3]+" "+dataArray[4];
				date[i]=sdf.parse(tempDate);
				++EOS;
			}
			
		}		
		
		System.out.println();
		
		// Remove Duplicate Id 
		for(int i=0;i<id.size();i++)
		{
			
		}
		
		// This is used for date formatting
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		for(int j=0;j<id.size();j++)
		{
			System.out.print("ID: "+id.get(j)+", Name: "+name[j]+", Age: "+age[j]+", Admission Date: "+sdf1.format(date[j]));
			System.out.println();
		}
			
		System.out.println();
		sc.close();
	}
}