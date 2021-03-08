#include <iostream.h>
#include <conio.h>
#include <string.h>

void selectionSort(int *arr,int size);
void bubbleSort(int *arr,int size);
void mergeSort(int *arr,int size);
void merge(int *arr,int *l,int leftsize,int *r,int rightsize);
void swap(int &x,int &y);
void selectionSortStr(char **arr,int size);


int main(){
	clrscr();
	int arr[6]={5,3,7,90,68,2};
	mergeSort(arr,6);
	for(int i=0;i<6;i++){
		cout<<arr[i]<<endl;
	}
	char *arr1[]={"hadeer","farah","mariam","hagar"};
	selectionSortStr(arr1,4);
	for(i=0;i<4;i++){
		cout<<arr1[i]<<" ";
	}
    cout<<endl;

	getch();
	return 0;

}
void swap(int &a,int &b){
	int temp=a;
	a=b;
	b=temp;

}

void selectionSort(int *arr,int size){
	for(int i=0;i<size-1;i++){
	int index=i;
		for(int j=i+1;j<size;j++){
			if(arr[index]>arr[j]){
				index=j;
			}

		}

		swap(arr[index],arr[i]);
	}

}

void bubbleSort(int *arr,int size){
	int j=0;
	int sorted=0;
	while(!sorted){
		sorted=1;
		for(int i=0;i<(size-1)-j;i++){
			if(arr[i]>arr[i+1]){
				swap(arr[i],arr[i+1]);
				sorted=0;
			}

		}
		j++;
	}


}
void mergeSort(int *arr,int size){
	if(size==1){
		return;
	}
	int mid=size/2;
	int *left=new int[mid];
	int *right=new int [size-mid];
	for(int i=0;i<mid;i++) left[i]=arr[i];
	for(i=mid;i<size;i++) right[i-mid]=arr[i];
	mergeSort(left,mid);
	mergeSort(right,size-mid);


	merge(arr,left,mid,right,size-mid);

	delete [] left;
	delete [] right;

	return;
}

void merge(int *arr,int *left,int leftsize,int *right,int rightsize){
	int i=0;
	int j=0;
	int k=0;

	while(i<leftsize && j<rightsize){
		if(left[i]<=right[j]){
			arr[k++]=left[i];
			i++;
		}
		else if(right[j]<left[i]){
			arr[k++]=right[j];
			j++;

		}

	}

	while(i<leftsize) arr[k++]=left[i++];
	while(j<rightsize) arr[k++]=right[j++];


}

void selectionSortStr(char **arr,int size){
	for(int i=0;i<size;i++){
		int index=i;
		for(int j=i+1;j<size;j++){
			if(strcmp(arr[index],arr[j])>0){
				index=j;
			}

		}
		char *temp=arr[index];
		arr[index]=arr[i];
		arr[i]=temp;


	}


}