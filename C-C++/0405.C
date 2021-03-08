#include <stdio.h>
#include <conio.h>

void printstr(char ** strarr,int arrsize);

void main(void){

	char ** strarr;
	int strnum;
	int i;
	clrscr();
	printf("please enter number of strings:");
	scanf("%d",&strnum);
	strarr=(char **) malloc(strnum * sizeof(char *));
	for(i=0;i<strnum;i++){
		int strsize;
		printf("please enter string %d size",i+1);
		scanf("%d",&strsize);
		strarr[i]=malloc(strsize * sizeof(char)+1);
		printf("please enter string number %d",i+1);
		scanf("%s",strarr[i]);

	}
	printstr(strarr,strnum);


	getch();

}


void printstr(char ** strarr,int arrsize){
	int i;
	for(i=0;i<arrsize;i++){
		printf("string number %d is %s \n",i+1,strarr[i]);

	}





}