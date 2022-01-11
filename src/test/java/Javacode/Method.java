package Javacode;

public class Method 
{    
	public static void main(String args[])
	{
		
		
		int i;
		int j;
		int n=5;
		//pyramid(n);
		for (i=0;i<n;i++)
		{
			System.out.print(" "); 

			for(j=n-i;j>1;j--)
			{
				System.out.print(" ");	
			}

			for(j=0;j<=i;j++)
			{
				System.out.print("* ");
				//System.out.print(" ");
			}
			System.out.println();
		}
	}
}
