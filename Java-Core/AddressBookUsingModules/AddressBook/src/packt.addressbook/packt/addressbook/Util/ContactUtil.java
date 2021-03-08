package packt.addressbook.util;

import java.util.*;
import packt.addressbook.model.*;
import java.util.ArrayList;

public class ContactUtil{
	public static List<Contact> getContacts(){
		List<Contact> contacts=new ArrayList<>();
		contacts.add(new Contact("con1","hadeer","elnaggar","02839292","8392892","hsjs@hs.com"));
		contacts.add(new Contact("con2","hagar","farouk","02199292","8392892","hsaaajs@hs.com"));
		contacts.add(new Contact("con3","farah","walid","04839292","8323892","hsjnxjzs@hs.com"));
		contacts.add(new Contact("con4","mariam","jaafar","02134292","8192892","hsjjjss@hs.com"));
		contacts.add(new Contact("con5","soha","aboelkhair","02839222","8345892","hksk@hs.com"));
		contacts.add(new Contact("con6","ashraf","elnaggar","028393492","8396792","hkds@hs.com"));
		return contacts;
	}
}