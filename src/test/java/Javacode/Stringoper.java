package Javacode;

public class Stringoper 
{
	public static void main(String [] args)
	{
		/*String S="I myself Pallavi";
		System.out.println("The string = " + S);
		//Print length
		System.out.println("The length of string = " + S.length());

		//Print specific character
		System.out.println("Specific char of given index = " +S.charAt(4));

		//Print the index of specific char
		System.out.println("The index given 'a' char =" + S.indexOf('a'));

		//2nd 'a' index position
		System.out.println("The 2nd occurance of char 'a' = "+ S.indexOf('a',11));

		//upper case print
		String a= "myself pallavi";
		System.out.println("The string in upper case = " + a.toUpperCase());


		//lower case print
		String b= "MYSELF PALLAVI";
		System.out.println("The string in lower case = " + b.toLowerCase());

		//Trim - remove white spaces
		String c = "            Hi!friends!               ";
		System.out.println("The after removing space = "+ c.trim());

		//Remove some specific character from string 
		System.out.println("The after removinf ! = " + c.replace('!','$'));

		String str11 = "Your transaction number is - 78E354dL thank you";
		String TransationId = str11.substring(29, 37);
		System.out.println("The extracted id from str11 is : " + TransationId);

		//To compare two strings
		String statement1 = "Java is platform independent";
		String statement2 = "java is platform independent";
		String statement3 = "Java is platform independent";
		System.out.println("Are statement1 & statement2 having exact same content : " + statement1.equals(statement2));
		System.out.println("Are statement1 & statement3 having exact same content : " + statement1.equals(statement3));
		System.out.println("Are statement1 & statement2 having exact same content : " + statement1.equalsIgnoreCase(statement2));

		// 13. Splitting the String on basis of some specific char
		String str13 = "Java is based on Object Oeriented Programming Principles";
		String[] words = str13.split(" "); 
		for (int i = 0; i < words.length; i++) 
		{
			System.out.println(words[i]);
		}

		
		// Splitting the String on basis of some specific char & print it in reverse order(Word by word)
		String stm = "Good Bye";
		String revWord[] = stm.split(" ");
		System.out.println(revWord[1]+" "+revWord[0]); // O/P - "Bye Good"*/
		
		String UserName = "Tom";
		if (UserName == "Tom" || UserName == "Peter")
		{
			System.out.println("Hi developer " + UserName);
			System.out.println("How may I help you?");
		} 
		else if (UserName == "Steve" || UserName == "Joe")
		{
			System.out.println("Hi tester " + UserName);
			System.out.println("How may I help you?");
		}
		else 
		{
			System.out.println("Hi there " + UserName);
			System.out.println("How may I help you?");
	    }
	}
}
