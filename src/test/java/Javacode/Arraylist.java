package Javacode;

import java.util.ArrayList;
import java.util.Collection;

public class Arraylist
{

	public static void main(String[] args) 
	{
		/*ArrayList ar = new ArrayList();
		System.out.println("The ARRAY - ");
		ar.add(100);
		ar.add(200);
		ar.add("Anushree");
		System.out.println(ar);
		System.out.println("The size of array - " +ar.size());
		System.out.println("-----------------------------");
		
		System.out.println("Print array list - ");
		for(int i=0;i<ar.size();i++)
		{
			System.out.println(ar.get(i));
		}
		System.out.println("-----------------------------");
		System.out.println("Adding 2 element in array - ");
		
		ar.add(300);
		ar.add(400);
		
		System.out.println("After adding 2 element array size = " +ar.size());
		
		System.out.println("-----------------------------");
		System.out.println("New array list - ");
		for(int i=0;i<ar.size();i++)
		{
			System.out.println(ar.get(i));
		}*/
		
		Collection c1 = new ArrayList();
		c1.add(10);
		c1.add("Anushri");
		c1.add('A');
		System.out.println(c1);
		System.out.println("----------------");
		
		Collection c2 = new ArrayList();
		c2.add(100);
		c2.add(200);
		System.out.println(c2);
		System.out.println("----------------");
		
		c1.addAll(c2);
		System.out.println(c1);		
		System.out.println("----------------");
		
		boolean b= c1.isEmpty();
		System.out.println(b);
		System.out.println("----------------");
		
		boolean b1 = c2.contains(100);
		System.out.println(b1);
		System.out.println("----------------");
		
		c1.remove(10);
		System.out.println(c1);
		System.out.println("----------------");
		
		c2.removeAll(c2);
		System.out.println(c2);
		System.out.println("----------------");
		
	}

}
