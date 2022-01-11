package Javacode;

import java.util.Scanner;

public class Array 
{
	public static void main (String args[])
	{
	
		//int size = a.length;
		
		/*copy array int b[]=a;
		int a[] = {10,20,30,40,50};
		System.out.println(a[0]);
		System.out.println(b[0]);
		System.out.println(b[3]);
		a[3]=100;
		System.out.println(a[3]);
		System.out.println(b[0]);*/
		
		//array user input and print
		
		/*int a[]=new int[5];		
		for(int i=0;i<5;i++)
		{
		    Scanner sc=new Scanner(System.in);
		    a[i] =sc.nextInt();
			System.out.println("Enter no=" +a[i]);
		   
		}
		for(int i=0;i<5;i++)
		{
			System.out.println(-a[i]);
		}*/
		
		//MAximum no.
        
		/*int max;
		int a[]=new int[5];
		
		System.out.println("Array input");
		for(int i=0;i<5;i++)
		{
		    Scanner sc=new Scanner(System.in);
		    a[i] =sc.nextInt();
		    System.out.println(a[i]);
		   
		}
		
		max=a[0];
		
		for(int i=0;i<5;i++)
		{
			if(max<a[i])
			{
				max=a[i];
			}
		}
		
		System.out.println("Maximum number = "+ max);*/
		
	// leap year
		/*int a[]=new int[200];
		int i,count=0;
		
		for(i=1901;i<=2025;i++)
		{
			if(i%4==0)
			{
				a[count]=i;
				count++;
			}
		}
		
		System.out.println("List of Leap year=");
		for(i=0;i<count;i++)
		{
			System.out.println(a[i]);
		}*/
		
		//Amstrong no.
		
		int n,r1,r2,r3,d1,d2,D;
		
		for(n=1;n<500;n++)
		{	
		r1=n%10;//
		d1=n/10;
		r2=d1%10;
		d2=d1/10;
		r3=d2%10;
		D=(r1*r1*r1)+(r2*r2*r2)+(r3*r3*r3);
		
		if(D==n)
		{
			System.out.println(n);
		}
		}
		/*else
		{
			System.out.println("The 153 is not amstrong no.");
		}*/
		
	}
	
}



