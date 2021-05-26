package core_java;
class EmployementCount
{
	private int numOfEmployee=0;
	public void setOfEmployee(int count)
	{
		numOfEmployee=count;
	}
	public double getNoOfEmployee() 
	{
		return numOfEmployee;
	}
}

public class Encapsulation
{
	public static void main(String[] args) 
	{
		EmployementCount ec=new EmployementCount();
		ec.setOfEmployee(1013);
		System.out.println((int)ec.getNoOfEmployee());
	}

}
