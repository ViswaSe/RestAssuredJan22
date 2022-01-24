package javaprograms;

public class LearnArmstrong {
	
	public static void main(String args[])
	{
		int number = 10240;
		int reminder;
		int quotient=number;
		
		int count=0;
		int total=1;
		
		// for loop will be used only if you know the total number of iteration 
		// while loop will be used based on the condition. 
		
		while(quotient>0) //1534>0 //153>0 //15>0 //1
		{
			quotient = quotient/10;  //15 1 0
			count = count+1;
		}
		
		int final_value=0;
		
		System.out.println(count);
		quotient=number;
		
		while(quotient>0) //1534>0 //153>0 //15>0 //1
		{
			reminder = quotient%10; //4 3 5 1
			quotient = quotient/10;  //15 1 0
			
			for(int i=1;i<=count;i++)
			{
				total = total*reminder; //1*3=3 //3*3=9 //9*3=27 //1*5=5 //5*5=25 //25*5=125
			}
			
			final_value=final_value+total; //27+125
			total=1; //1
		}
		
		System.out.println(final_value);
		
		if(final_value == number)
		{
			System.out.println(number+ " is an armstrong number..");
		}
		else
		{
			System.out.println(number+" is not an armstrong number");
		}
			
		//153/10 = 15,1,0 (quotient)
		//153%10 = 3 (reminder)
	}

}
