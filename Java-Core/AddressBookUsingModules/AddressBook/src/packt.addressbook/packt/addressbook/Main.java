package packt.addressbook;

import packt.addressbook.model.*;
import packt.addressbook.util.*;
import java.util.*;

class Main{
	public static void main(String args[]){
		List<Contact> contacts=ContactUtil.getContacts();
		System.out.println(contacts);
	}
}