package Reflection_API;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest 
{
	public static void main(String[] args)
	{
		try
		{
			Class<?> c=Class.forName("Reflection_API.Person");
			
			// 1. Getting constructor of the class
			System.out.println("<---Getting Constructors of the class--->");
			Constructor<?> constructors[]=c.getConstructors();
//			System.out.println("Constructors : "+Arrays.toString(constructors));
			for(Constructor<?> g:constructors)
			{
				System.out.print(g.getName()+" : ");
			}
			
			
			System.out.println();
			System.out.println();
			// 2. Getting all methods (even inherited) of the class
			System.out.println("<---Getting all method of the class--->");
			Method m[]=c.getMethods();
//			System.out.println("Inherited Methods : "+Arrays.toString(m));
			for(Method g:m)
			{
				System.out.print(g.getName()+" : ");
			}
			
			
			System.out.println();
			System.out.println();
			// 3. Getting declare methods of the class
			System.out.println("<---Getting declare method of same class--->");
			Method dm[]=c.getDeclaredMethods();
//			System.out.println("Declared class methods : "+Arrays.toString(dm));
			for(Method g:dm)
			{
				System.out.print(g.getName()+" : ");
			}
			
			
			System.out.println();
			System.out.println();
			// 4. Getting all fields of the class
			System.out.println("<---Getting declared fields of the class--->");
			Field f[]=c.getDeclaredFields();
//			System.out.println("Field : "+Arrays.toString(f));
			for(Field g:f)
			{
				System.out.print(g.getName()+" : ");
			}
			
			
			System.out.println();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}