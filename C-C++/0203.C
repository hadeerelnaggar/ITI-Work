#include <stdio.h>
#include <conio.h>

void main(void){
	int x=1;
	int y=3;
	int n;
	int i,j;
	int count =0;
	clrscr();

	do{

		printf("Enter N");
		scanf("%d",&n);

	}while(n%2==0);

	i=n/2;
	j=0;

	gotoxy(x+(i*3),y+(j*3));
	printf("%d",++count);

	while(count<(n*n)){
		if(count%n!=0){
			i++;
			j--;
			if(j<0){
				j=n-1;
			}
			if(i>=n){
				i=0;
			}

		}
		else{
			j++;
			if(j>=n){
				j=0;
			}

		}

		gotoxy(x+(i*3),y+(j*3));
		printf("%d",++count);
	}


	getch();



}