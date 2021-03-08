import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.*;
class WordDictionary{
	public static void main(String args[]){
		String str[]={"hadeer","hagar","farah","maha","mariam","dalia","soha","nura","hashem","saif","mohey","ashraf","elnaggar","rasha","raghda",
		"yousef","mohey","amira","salma","nada","ali"};
		List<String>wordsList=Arrays.asList(str);
		Map<Character,TreeSet<String>> dictionary=new TreeMap<>();
		for(int i=0;i<wordsList.size();i++){
			dictionary.putIfAbsent(wordsList.get(i).charAt(0),new TreeSet());
			TreeSet<String> tree=dictionary.get(wordsList.get(i).charAt(0));
			tree.add(wordsList.get(i));
			dictionary.put(wordsList.get(i).charAt(0),tree);
		}
		printAll(dictionary);
		printLetter(dictionary,'h');
	}
	public static void printAll(Map<Character,TreeSet<String>>map){
		map.forEach((k,v)->System.out.println("key "+k+":"+v));
	}
	public static void printLetter(Map<Character,TreeSet<String>>map,char letter){
		TreeSet<String> v=map.get(letter);
		if(v==null)
			System.out.println("this letter has no words");
		else
			System.out.println(v);
		
	}
}