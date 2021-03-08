#include <stdio.h>
#include <conio.h>
#include <iostream.h>
#include <string.h>
int linearSearch(int *arr,int search,int size);
int binarySearch(int *arr,int low,int hi,int search);
int binarySearchiterative(int *arr,int size,int search);
int linearSearchstr(char **arr,char *search,int size);
int binarySearchstr(char **arr,int low,int hi,char *search);

int main(){
	clrscr();
	int arr[5]={1,4,2,7,5};
	int arr2[5]={1,2,3,4,5};
	cout<<linearSearch(arr,2,5)<<endl;
	cout<<linearSearch(arr,9,5)<<endl;
	cout<<binarySearch(arr2,0,5,4)<<endl;
	cout<<binarySearchiterative(arr2,5,8)<<endl;
	char * strings[3]={"aaa","bbb","ccc"};
	cout<<linearSearchstr(strings,"aaa",3)<<endl;

	cout<<binarySearchstr(strings,0,3,"sbb")<<endl;
	getch();
	return 0;
}
int linearSearch(int *arr,int search,int size){
	for(int i=0;i<size;i++){
		if(arr[i]==search){
			return i;
		}
	}
	return -1;

}

int binarySearch(int *arr,int low,int hi,int search){
	int mid=(low+hi)/2;
	if(arr[mid]==search){
		return mid;
	}
	if(low>hi){
		return -1;
	}
	if(search>arr[mid]){
		return binarySearch(arr,mid+1,hi,search);
	}
	if(search<arr[mid]){
		return binarySearch(arr,low,mid-1,search);
	}
    return -1;
}
int binarySearchiterative(int *arr,int size,int search){

	int lo=0;
	int hi=size;
	while(lo<hi){
		int mid=(lo+hi)/2;
		if(arr[mid]==search)
			return mid;
		if(arr[mid]>search)
			hi=mid-1;
		if(arr[mid]<search)
			lo=mid+1;

	}
	return -1;

}
int linearSearchstr(char **arr,char *search,int size){
	for(int i=0;i<size;i++){
		if(!strcmp(arr[i],search)){
			return i;
		}


	}
	return -1;
}
int binarySearchstr(char **arr,int low,int hi,char *search){
	int mid=(low+hi)/2;
	if(!strcmp(arr[mid],search)){
		return mid;
	}
	if(low>hi){
		return -1;
	}
	if(strcmp(arr[mid],search)>0){
		return binarySearchstr(arr,low,mid-1,search);
	}
	if(strcmp(arr[mid],search)<0){
		return binarySearchstr(arr,mid+1,hi,search);
	}
}
