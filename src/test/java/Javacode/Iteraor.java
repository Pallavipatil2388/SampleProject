package Javacode;

import java.util.ArrayList;
import java.util.Iterator;

public class Iteraor 
{
      public static void main(String [] args)
      {
    	  ArrayList al = new ArrayList();
    	  al.add(10);
    	  al.add(20);
    	  al.add(30);
    	  Iterator <Integer>itr = al.iterator();
    	  while(itr.hasNext())
    	  {
    		  if(itr.next()==20)
    		  {
    		  itr.remove();
    		  }
    	  }
    	  System.out.println(al);
    	  
      }
}
