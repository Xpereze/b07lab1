import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintStream;
import javax.lang.model.util.ElementScanner14;
import java.io.StringWriter;
import java.io.File;
import java.io.FileNotFoundException;




public class Polynomial{
	double [] coefficients= new double[100];
	int [] exponents = new int[100];
	public Polynomial(){
		coefficients[0] = 0;
		exponents[0] = 0;
	}
	public Polynomial(double [] input, int [] power){
		for(int i = 0; i < input.length; i++){
			
			coefficients[i] = input[i];
			exponents[i] = power[i];
		}
	}

	public Polynomial(File random) throws Exception{
		FileReader input = new FileReader(random);
		BufferedReader b = new BufferedReader(input);
		String line = b.readLine();
		int m = 0;
		double [] coeff = new double[100];
		int [] pow = new int[100];
		int signc = 0;
		for(int leng = 0; leng<line.length();leng++){
			if(leng == 0){
				if(!line.substring(leng,leng+1).equals("-")){
					coeff[signc]=1;
					signc++;

				}
			}
			 if(line.substring(leng,leng+1).equals("+")){
				coeff[signc] = 1;
				signc++;
			}
			if(line.substring(leng,leng+1).equals("-")){
				coeff[signc] = -1;
				signc++;
			}
		}
		
		if(line.substring(0,1).equals("-")){
			coeff[0]=-1;
			String linea = line.substring(1);
			String [] split1 = linea.split("[-+]");
			for(String x : split1){
				if(x.contains("x")){
					String [] split2 = x.split("x");
					if(m == 0){
						coeff[m] *= Double.parseDouble(split2[0]);
						pow[m] = Integer.parseInt(split2[1]);
						m++;
					}
					else{
						coeff[m] *= Double.parseDouble(split2[0]);
						pow[m] = Integer.parseInt(split2[1]);
						m++;
					}
				}
				else{
					if(m == 0){
						coeff[m] *= Double.parseDouble(x);
						pow[m] = 0;
						m++;
					}
				}
			}
		}
		else{
			String [] split2 = line.split("[-+]");
			for(String x : split2){
				if(x.contains("x")){
					String [] split3 = x.split("x");
					if(m == 0){
						coeff[m] *= Double.parseDouble(split3[0]);
						pow[m] = Integer.parseInt(split3[1]);
						m+=1;
					}
					else{
						coeff[m] *= Double.parseDouble(split3[0]);
						pow[m] = Integer.parseInt(split3[1]);
						m++;
					}
				}
				else{
					if(m == 0){
						coeff[m] *= Double.parseDouble(x);
						pow[m] = 0;
						m++;
					}
				}
			}
		}
		int count = 0;
		for(int i = 0; i<100;i++){
			if(coeff[i]!=0){
				count++;
			}
		}
	
		double [] coeffa = new double[count];
		int [] expa = new int [count];
		
		int count2 = 0;
		for(int j = 0; j < 100; j++){
			if(coeff[j]!=0){
				coeffa[count2] = coeff[j];
				expa[count2] = pow[j];
				count2++;
			}
		}
		coefficients = coeffa.clone();
		exponents = expa.clone();
		b.close();
		
	
	
	}
	
	public Polynomial add(Polynomial number1){
		Polynomial results = new Polynomial();
		
		int max1 = 0;
		for(int f = 0; f<100;f++){
			if((exponents[f]>max1) && (coefficients[f]!=0)){
				max1 = exponents[f];
			}
		}
		
		int max2 = 0;
		for(int l = 0; l<100;l++){
			if((number1.exponents[l]>max2) && (number1.coefficients[l]!=0)){
				max2 = number1.exponents[l];
			}
		}
		
		int j = Math.max(max1,max2)+1;
		double [] coefficientresult = new double[j];
		for(int m = 0; m < j ;m++){
			coefficientresult[exponents[m]] += coefficients[m];
		}
		for(int n = 0; n < j;n++){
			coefficientresult[number1.exponents[n]] += number1.coefficients[n];
		
		}
		int m = 0;
		int countnon = 0;
		for(int q = 0; q < coefficientresult.length; q++){
			if(coefficientresult[q]!=0){
				
				countnon=countnon+1;
			}
		}
		double [] coefficientsafter = new double[countnon];
		int [] pafter = new int[countnon];
		for(int k =0; k < j; k++){
			
			if(coefficientresult[k]!=0){
				coefficientsafter[m] = coefficientresult[k];
				pafter[m] = k;
				m=m+1;
			}
		}
		results.coefficients = coefficientsafter.clone();
		results.exponents = pafter.clone();
		return results;

	}
	public double evaluate(double x){
		double result=0;
		for(int i  = 0; i < coefficients.length; i++){
			result+= coefficients[i]*Math.pow(x,exponents[i]);
		}
		return result;
	}
	public boolean hasRoot(double m){
		if(this.evaluate(m)== 0){
			return true;
		}
		return false;
	}
	public Polynomial multiply(Polynomial number1){
		double [] checker = new double[100];
		Polynomial final1 = new Polynomial();
		for(int i = 0; i < coefficients.length; i++){
			for(int j = 0; j < number1.coefficients.length;j++){
				
					checker[exponents[i]+number1.exponents[j]] += coefficients[i]*number1.coefficients[j];
			}
		}
		int m = 0;
		
		for(int k =0; k < 100; k++){
			
			if(checker[k]!=0){
				m=m+1;
			}
		}
		int [] pow1 = new int[m];
		double [] coe = new double[m];
		int count = 0;
		for(int k =0; k < 100; k++){
			
			if(checker[k]!=0){
				coe[count] = checker[k];
				pow1[count] = k;
				
				count +=1;
			}
		}
		final1.coefficients = coe.clone();
		final1.exponents = pow1.clone();
		
		return final1;


	}
	public void saveToFile(String file_name) throws FileNotFoundException{
		
		int count = 0;
		PrintStream ps = new PrintStream(file_name);
		for(int j = 0; j < coefficients.length; j++){
			if(coefficients[j]!=0){
				count++;
				
				}
		}
	
		//String final1 = "";
		for(int i =0; i < count; i++){
			if(exponents[i]== 0 && i == 0){
				ps.print(Double.toString(coefficients[0]));
			}
			else{
				if(coefficients[i]>0){
					ps.print("+");
					ps.print(Double.toString(coefficients[i]));
					ps.print("x");
					ps.print(Integer.toString(exponents[i]));}
				else{
				
					ps.print(Double.toString(coefficients[i]));
					ps.print("x");
					ps.print(Integer.toString(exponents[i]));}
				}
			
			}
		
		
		//System.out.print(final1);
	
		
		ps.close();
	}
		



	
}


	
	
		