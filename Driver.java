import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
public class Driver { 
 		public static void main(String [] args) throws Exception{ 
  			double [] c1 = {1,2,3}; 
			int [] e1 = {0,1,4};
  			Polynomial p1 = new Polynomial(c1,e1); 
  			double [] c2 = {1,2,2}; 
			int [] e2 = {0,1,3};
  			Polynomial p2 = new Polynomial(c2,e2); 
			System.out.println("Addition testing:");
  			Polynomial s = p1.add(p2); 
			for(int i = 0; i < s.coefficients.length; i++){
				System.out.println(s.coefficients[i]+ " power " + s.exponents[i]);
			}
			System.out.println("\nEvaluation: \n	");
  			System.out.println("s(0.1) = " + s.evaluate(0.1));
			System.out.println("\nMultiplication Testing: \n");
			Polynomial j = p1.multiply(p2);
			for(int i = 0; i < j.coefficients.length; i++){
				
				System.out.println(j.coefficients[i] + " power " + j.exponents[i]);
			}
			System.out.println("\nRoot test using 1: \n");
  			if(s.hasRoot(1)) 
   				System.out.println("1 is a root of s"); 
  			else 
  				System.out.println("1 is not a root of s"); 

			Polynomial p5 = new Polynomial(new File("C:/Users/mohdh/Downloads/test.txt"));
			System.out.println("\nPrinting a File test: \n");
			for(int i = 0; i < p5.coefficients.length; i++)
			{
				System.out.println(p5.coefficients[i] + " Power: " + p5.exponents[i]);
			}
			System.out.println("\nTesting Inserting a polynomial into a file method: \n");
			p1.saveToFile("C:/Users/mohdh/Downloads/test2.txt");
			Polynomial p6 = new Polynomial(new File("C:/Users/mohdh/Downloads/test2.txt"));
			for(int i = 0; i < p6.coefficients.length; i++)
			{
				System.out.println(p6.coefficients[i] + " Power: " + p6.exponents[i]);
			}
		} 
	} 