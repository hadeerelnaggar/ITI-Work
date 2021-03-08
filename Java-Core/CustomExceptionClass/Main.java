class Main{
	public static void main(String args[]){
		MyClass x;
		try{
			MyClass y=new MyClass(-19);
		}catch(MyException e){
			e.printStackTrace();
		}
		try{
			x=new MyClass(10);
			x.setAge(-2);
		}catch(MyException e){
			e.printStackTrace();
		}
		finally{
			System.out.println("finally");
		}
		try{
			x=new MyClass(10);
			x.calcAgeAfterYears(200);
		}catch(MyException e){
			e.printStackTrace();
		}
	}
}