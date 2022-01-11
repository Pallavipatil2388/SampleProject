package Javacode;

// we can not create abstract class object we can access abstract class method using child class object
public abstract class Ab 
{
      abstract void m1();
      abstract int m2();
     public static void main(String[] args) 
      {
  		demo d = new demo();
  		d.m1();
	    d.m2();
      }
}
abstract class t extends Ab
{
	
	int m2()
	{
	 System.out.println("This is m2 function");
	 return 0;
	}
	
}
class demo extends t
{
	void m1()
	{
		System.out.println("This is m1 function");
	}
	
}