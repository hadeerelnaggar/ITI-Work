import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE,ElementType.CONSTRUCTOR})
@interface Author{
	String str();
}