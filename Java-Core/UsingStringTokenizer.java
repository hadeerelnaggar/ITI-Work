import java.util.StringTokenizer;

class UsingStringTokenizer{
	public static void main(String args[]){
		String sentence = "hh shdbs hdjs kfj yyy hsa jj hh lkd hdjs yyy omskd jdhs jj ww jj hsgd";
		String word = "yyy";
		StringTokenizer st = new StringTokenizer(sentence);
		int noOfOccurences=0;
		while(st.hasMoreTokens()){
			if(st.nextToken().equals(word)){
				noOfOccurences++;
			}
		}
		System.out.println(noOfOccurences);
	}
}