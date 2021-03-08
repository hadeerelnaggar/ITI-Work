class OccurenceInString{
	public static void main(String args[]){
		String sentence = "hh shdbs hdjs kfj yyy hsa jj hh lkd hdjs yyy omskd jdhs jj ww jj hsgd";
		String word = "yyy";
		int noOfOccrences=0;
		int noOfOccrences1=0;
		String splited[]=sentence.split(" ");
		for(int i=0;i<splited.length;i++){
			if(splited[i].equals(word)){
				noOfOccrences++;
			}
		}
		System.out.println(noOfOccrences);
		while(sentence.contains(word)){
			noOfOccrences1++;
			sentence=sentence.replaceFirst(word," ");
		}
		System.out.println(noOfOccrences1);
		
	}
	
}