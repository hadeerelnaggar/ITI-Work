import java.math.BigDecimal;

class Complex<T extends BigDecimal,R extends BigDecimal>{
	T real;
	R imag;
	public Complex(T r,R i){
		real=r;
		imag=i;
	}
	public void add(Complex<T,R> c){
		real=(T)(real.add(c.real));
		imag=(R)(imag.add(c.imag));
	}
	public void subtract(Complex<T,R> c){
		real=(T)(real.subtract(c.real));
		imag=(R)(imag.subtract(c.imag));
	}
	public void multiply(Complex<T,R> c){
		real=(T)(real.multiply(c.real).add(((imag.multiply(c.imag)).multiply(new BigDecimal(-1)))));
		imag=(R)((real.multiply(c.imag)).add((imag.multiply(c.real))));
	}
	
	
}