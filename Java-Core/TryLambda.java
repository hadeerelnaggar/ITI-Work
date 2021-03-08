import java.util.function.Function;
class TryLambda{
	public static void main(String args[]){
		System.out.println(convertCelsuis(15,(n)-> (n*9/5)+32));
	}
	public static int convertCelsuis(int celsuis,Function<Integer,Integer> fun){
		return fun.apply(celsuis);
	}
}