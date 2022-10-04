import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Driver2 { 
	public static void main(String [] args) throws Exception{ 
		Polynomial p = new Polynomial(); 
		
		System.out.println(p.evaluate(3)); 

		double [] c1 = {2,4,3};
		double [] c2 = {1,2,3};
		int [] e1 = {0,2,3};
		int [] e2 = {0,1,4};
		Polynomial p1 = new Polynomial(c1,e1);
		Polynomial p2 = new Polynomial(c2,e2);

		System.out.println("Addition test: ");
		System.out.println();
		
		Polynomial p3 = p1.add(p2);

		for(int i = 0; i < p3.coefficients.length; i++)
		{
			System.out.println(p3.coefficients[i] + " Power: " + p3.exponents[i]);
		}
		
		System.out.println();
		System.out.println("Multiplication test: ");
		System.out.println();

		Polynomial p4 = p1.multiply(p2);

		for(int i = 0; i < p4.coefficients.length; i++)
		{
			System.out.println(p4.coefficients[i] + " Power: " + p4.exponents[i]);
		}

		System.out.println();
		System.out.println("File test: ");
		System.out.println();

		Polynomial p5 = new Polynomial(new File("C:/Users/mohdh/Downloads/test.txt"));

		for(int i = 0; i < p5.coefficients.length; i++)
		{
			System.out.println(p5.coefficients[i] + " Power: " + p5.exponents[i]);
			
		}
		
		p5.saveToFile("C:/Users/mohdh/Downloads/test2.txt");
	} 
} 