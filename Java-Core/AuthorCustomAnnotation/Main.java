import java.lang.reflect.*;
class Main{
	public static void main(String args[]){
		myMeth();
	}
	public static void myMeth(){
		Myclass ob=new Myclass();
		try{
			Class <?> c=ob.getClass();
			Author anno=c.getAnnotation(Author.class);
			System.out.println(anno.str());
			Method m = c.getMethod("setX");
			anno=m.getAnnotation(Author.class);
			System.out.println(anno.str());
			Constructor con=c.getConstructor();
			anno=(Author)con.getAnnotation(Author.class);
			System.out.println(anno.str());
			Field f=c.getDeclaredField("number");
			anno=f.getAnnotation(Author.class);
			System.out.println(anno.str());
		}catch(NoSuchMethodException exp){
			System.out.println("Method not found");
		}
		catch(NoSuchFieldException exp){
			System.out.println("Field not found");
		}
	}
	
}