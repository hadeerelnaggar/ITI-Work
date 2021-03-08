#include <stdio.h>
#include <conio.h>

void main(void){
	char firstname[100];
	char lastname[100];
	char fullname[200];
    clrscr();
	printf("Enter first name");
	gets(firstname);
	printf("Enter second name");
	gets(lastname);
	strcat(fullname,firstname);
	strcat(fullname," ");
	strcat(fullname,lastname);
	puts(fullname);
	getch();




}