package core_java;

public class Math_Random_Manipulation 
{
	public static void main(String[] args) 
	{
		// Random manipulation
		System.out.println("OTP : "+(int)(Math.random()*1000000));
		
		// Square root 
		System.out.println("Square Root : "+(int)Math.sqrt(144));
		
		//floor --> it will complete value if decimal exist then backward the number 
		System.out.println("Floor : "+(int)Math.floor(124.656));
		
		//ceil --> it will complete value if decimal exist then forward the number
		System.out.println("Ceil : "+(int)Math.ceil(124.356));
	}
}