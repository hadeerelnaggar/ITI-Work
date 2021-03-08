#include <stdio.h>
#include <conio.h>

void main(void){
	int arr[10];
	int i;
	int max=0;
	int min=1000;
	clrscr();
	for(i=0;i<10;i++){
		scanf("%d",&arr[i]);

	}
	for(i=0;i<10;i++){
		printf("%d",arr[i]);
	}
	for(i=0;i<10;i++){
		if(arr[i]>max){
			max=arr[i];
		}
		if(arr[i]<min){
			min=arr[i];
		}
	}
	printf("\nmax is:");
	printf("%d \n",max);
	printf("min is: %d",min);
	getch();



}