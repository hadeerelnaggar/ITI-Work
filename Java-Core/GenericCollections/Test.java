import java.util.ArrayList;
class Test{
	public static void main(String args[]){
		ArrayList<Rectangle> l=new ArrayList<>();
		ArrayList<Shape> s=new ArrayList<>();
		ArrayList<String> s1=new ArrayList<>();
		genericMethod(l);
		genericMethod(s1);
	}
	public static void genericMethod(ArrayList<? extends Shape> l){
		System.out.println("shape");
		for(int i=0;i<l.size();i++){
			System.out.println("shape");
		}
	}
}