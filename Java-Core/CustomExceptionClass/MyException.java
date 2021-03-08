import java.io.IOException;
class MyException extends IOException{
	MyException(){
		super("invalid age exception");
	}
	MyException(String err){
		super(err);
	}
}