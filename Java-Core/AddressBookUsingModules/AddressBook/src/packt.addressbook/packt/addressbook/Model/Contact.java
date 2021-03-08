package packt.addressbook.model;

public class Contact{
	String id;
	String firstName;
	String lastName;
	String homePhone;
	String workPhone;
	String email;
	public Contact(String idno,String firstname,String lastname,String homephone,String workphone,String emaill){
		id=idno;
		firstName=firstname;
		lastName=lastname;
		homePhone=homephone;
		workPhone=workphone;
		email=emaill;
	}
	public Contact(){
		id="";
		firstName="";
		lastName="";
		homePhone="";
		workPhone="";
		email="";
	}
	@Override
	public String toString(){
		return id+" "+firstName+" "+lastName+" "+homePhone+"\n";
	}
}