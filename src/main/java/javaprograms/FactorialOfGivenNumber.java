package javaprograms;

public class FactorialOfGivenNumber {
	
	public static void main(String args[])
	{
		int given_no = 149;
		
		double result=1;
		
		for(int i=1;i<=given_no;i++) //1 //2 //3 //4 //5
		{
			System.out.println(result);
			result=result*i; //1 //2 //6 //24 //120 
		}
		
		System.out.println(result); 
	}

}
