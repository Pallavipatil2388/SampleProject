package Javacode;

public class Test 
{

	Test()
	{
		System.out.println("This is constructor");
	}
	{
		System.out.println("This is instance block");
	}
	static		
	{
		System.out.println("Thos is static block");
	
	}
	public static void main(String args[])	
	{
		Test t1=new Test();
	}
	
}
