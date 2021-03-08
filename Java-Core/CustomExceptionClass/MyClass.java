class MyClass{
	private int age;
	public MyClass(int a)throws MyException{
		if(a<0){
			throw new MyException();
		}
		age=a;
	}
	public void setAge(int a)throws MyException{
		if(a<0){
			throw new MyException();
		}
		age=a;
	}
	public int calcAgeAfterYears(int years)throws MyException{
		if(years>100){
			throw new MyException("so many years");
		}
		age+=years;
		return age;
	}
	
}