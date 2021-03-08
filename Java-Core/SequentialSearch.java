import java.util.Random;

class SequentialSearch{
	public static void main(String args[]){
		Random rand=new Random();
		int arr[]=new int[1000];
		for(int i=0;i<1000;i++){
			arr[i]=Math.abs(rand.nextInt()%1000);
			System.out.println(arr[i]);
		}
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		long time=System.nanoTime();
		for(int i=0;i<1000;i++){
			if(arr[i]<min)
				min=arr[i];
			if(arr[i]>max)
				max=arr[i];
		}
		long searchTime=System.nanoTime()-time;
		System.out.println("min is "+min);
		System.out.println("max is "+max);
		System.out.println("time taken in search is "+searchTime+" nano seconds");
		
		
	}
}