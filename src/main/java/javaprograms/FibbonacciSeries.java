package javaprograms;

public class FibbonacciSeries {
	
	public static void main(String args[])
	{
		int a = -1;
		int b = 1; 
		
		int size = 12;
		
		System.out.println(a);
		System.out.println(b);
		
		for(int i=1;i<size;i++)
		{
			b=a+b;  // a = -1 , b = 0
			a=b-a;  // a = 1, b = 0 
			System.out.println(b);
		}
	}

}
