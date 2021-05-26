package core_java;

class Operation
{
	int square(int n)
	{
		return n*n;
	}
}

public class Containment_Class 
{
	// This is Aggregation
	Operation op;
	
	double pi=3.14;
	
	double area(int radius)
	{
		op=new Operation();
		int square = op.square(radius);
		return pi*square;
	}
	
	public static void main(String[] args) 
	{
		// This is also known as aggregation in java
		// also HAS-A Relationship
		// if a class have an entity reference, it is known as aggregation.
		// Aggregation represent HAS-A Realtionship
		Containment_Class cc=new Containment_Class();
		double result=cc.area(5);
		System.out.println(result);
	}
}