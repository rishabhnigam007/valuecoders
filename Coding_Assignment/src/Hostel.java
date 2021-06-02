import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Hostel 
{
	public static void main(String[] args)
	{
		// Scanner Class for Taking User Input From Console
		Scanner sc=new Scanner(System.in);
		
		try
		{	
			// This is fixed that we can admit maximum 20 student at a time.
			int testCase=20;
			
			// Variable Type and Name
			List<String> id=new ArrayList<String>(); // This is temporary list
			
			List<String> studentId=new ArrayList<String>();
			
			List<String> studentName=new ArrayList<String>();
			
			List<Integer> studentAge=new ArrayList<Integer>();
			
			List<Date> date=new ArrayList<Date>();
		
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
					if(!studentId.contains(dataArray[0]))
					{
						studentId.add(dataArray[0]);
						studentName.add(dataArray[1]);
						studentAge.add(Integer.parseInt(dataArray[2]));
						
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						String tempDate=dataArray[3]+" "+dataArray[4];
						date.add(sdf.parse(tempDate));
						++EOS;
					}
					else
					{
						continue;
					}
				}
			}	
			
			//Need to clear temporary list for memory optimization
			id.clear();
			
			System.out.println();
			
			// This is used for date formatting
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			
			for(int j=0;j<EOS;j++)
			{
				System.out.print("ID: "+studentId.get(j)+", Name: "+studentName.get(j)+", Age: "+studentAge.get(j)+", Admission Date: "+sdf1.format(date.get(j)));
				System.out.println();
			}
				
			System.out.println();
		}
		catch(Exception e)
		{
			// This is for print Error by Message
			System.out.println(e.getMessage());
		}
		finally
		{
			// Need to close Scanner Class object otherwise memory leak problem occur sometime 
			// It is best for practice to close the Scanner connection
			sc.close();
		}		
	}
}