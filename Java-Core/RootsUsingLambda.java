import java.util.function.Function;
class RootsUsingLambda{
	public static void main(String args[]){
		QuadraticEquation q=new QuadraticEquation(1,6,1);
		Roots r=new Roots();
		r.root1=getroots(q,(x)->((-x.b+Math.sqrt((x.b*x.b)-4*x.a*x.c))/(2*x.a)));
		r.root2=getroots(q,(x)->((-x.b-Math.sqrt(x.b*x.b-4*x.a*x.c))/2*x.a));
		System.out.println("the roots are "+r.root1+" "+r.root2);
	}
	public static Double getroots(QuadraticEquation q,Function<QuadraticEquation,Double> fun){
		return fun.apply(q);
	}
}
class QuadraticEquation{
		double a;
		double b;
		double c;
		public QuadraticEquation(double x,double y,double z){
			a=x;
			b=y;
			c=z;
		}
}
class Roots{
	double root1;
	double root2;
	public Roots(double x,double y){
		root1=x;
		root2=y;
	}
	public Roots(){
		root1=0;
		root2=0;
	}
}


