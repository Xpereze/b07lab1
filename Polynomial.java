public class Polynomial{
	double [] coefficients= new double[100];
	public Polynomial(){
		coefficients[0] = 0;
	}
	public Polynomial(double [] input){
		for(int i  = 0; i < input.length; i++){
			coefficients[i] = input[i];
		}
	}
	public Polynomial add(Polynomial number1){
		for(int j  = 0; j < coefficients.length; j++){
			coefficients[j] += number1.coefficients[j];
		}
		return this;
	}
	public double evaluate(double x){
		double result=0;
		for(int i  = 0; i < coefficients.length; i++){
			result+= coefficients[i]*Math.pow(x,i);
		}
		return result;
	}
	public boolean hasRoot(double m){
		if(this.evaluate(m)== 0){
			return true;
		}
		return false;
	}
}


	
	
		