package Javacode;
//constructor called in child class
public class Subclass extends Base
{
	   //super();
	  Subclass()
	   {
		   super(10);
		   System.out.println("This is child constructor");
	   }
	public static void main(String[] args)
	{
		Subclass s1=new Subclass();
		
	}
}
