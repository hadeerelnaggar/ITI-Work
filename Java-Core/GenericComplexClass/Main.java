import java.math.BigDecimal;
class Main{
	public static void main(String args[]){
		Complex<BigDecimal,BigDecimal> c=new Complex(new BigDecimal(2.3),new BigDecimal(2.5));
		Complex<BigDecimal,BigDecimal> x=new Complex(new BigDecimal(5.5),new BigDecimal(4.3));
		System.out.println(c.real+" "+c.imag);
		c.add(x);
		System.out.println(c.real+" "+c.imag);
		c.subtract(x);
		System.out.println(c.real+" "+c.imag);
		c.multiply(x);
		System.out.println(c.real+" "+c.imag);
		
	}
}