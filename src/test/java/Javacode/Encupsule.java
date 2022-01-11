package Javacode;

public class Encupsule
{
    private int rollno;
    private String name;
    
    public void setrollno(int rollno)
    {
    	this.rollno=rollno;
    }
    public int getrollno()
    {
    	return rollno;
    }
    public void setname(String name)
    {
    	this.name=name;
    }
    public String getname()
    {
    	return name;
    }
    public static void main(String [] args)
    {
    	Encupsule e= new Encupsule();
    	
    	e.setname("pallavi");
    	e.setrollno(10);
    	System.out.println(e.getname() + " " +e.getrollno());
    }
}   
