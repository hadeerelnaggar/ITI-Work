import java.util.Random;
import java.util.Scanner;

class BinarySearch{
	public static void main(String args[]){
		Random rand=new Random();
		int arr[]=new int[1000];
		for(int i=0;i<1000;i++){
			arr[i]=Math.abs(rand.nextInt()%1000);
			System.out.println(arr[i]);
		}
		System.out.print("enter key:");
		//Scanner sc= new Scanner(System.in); 
		int key= 614;
		long time=System.nanoTime();
		bubbleSort(arr);
		int found=binarySearch(key,arr,0,1000-1);
		if(found==-1){
			System.out.println("item not found");
		}
		else{
			System.out.println("the found is "+arr[found]);
		}
		System.out.println("min value is "+arr[0]);
		System.out.println("max value is "+arr[999]);
		long searchTime=System.nanoTime()-time;
		System.out.println("time taken in search is "+searchTime+" nano seconds");
	}
	public static void bubbleSort(int arr[]){
		int j=0;
		boolean sorted=false;
		while(!sorted){
			sorted=true;
			for(int i=0;i<(arr.length-1)-j;i++){
					if(arr[i]>arr[i+1]){
						int temp=arr[i];
						arr[i]=arr[i+1];
						arr[i+1]=temp;
						sorted=false;
					}
			}
			j++;
		}
	}
	public static int binarySearch(int key,int arr[],int low,int high){
		int middle=high-low/2;
		if(arr[middle]==key)
			return middle;
		if(low>high)
			return -1;
		if(arr[middle]>key)
			return binarySearch(key,arr,low,middle-1);
		else
			return binarySearch(key,arr,middle+1,high);
	}
	
}