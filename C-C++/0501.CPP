#include <iostream.h>
#include <conio.h>
void swapByValue(int a,int b);
void swapByrefrence(int &a,int &b);
void swapByAddress(int *a,int *b);

void main(){
	clrscr();
	int firstnum=5,secondnum=10;
	cout << "number before swap is"<<firstnum<<" "<<secondnum<<endl;
	swapByValue(firstnum,secondnum);
	cout << "number after swap by value is"<<firstnum<<" "<<secondnum<<endl;
	swapByrefrence(firstnum,secondnum);
	cout << "number after swap by refrence is"<<firstnum<<" "<<secondnum<<endl;
	swapByAddress(&firstnum,&secondnum);
	cout << "number after swap by address is"<<firstnum<<" "<<secondnum<<endl;

	getch();

}

void swapByValue(int firstnum,int secondnum){
	int temp=firstnum;
	firstnum=secondnum;
	secondnum=temp;


}
void swapByrefrence(int &firstnum,int &secondnum){

	int temp=firstnum;
	firstnum=secondnum;
	secondnum=temp;



}
void swapByAddress(int *firstnum,int *secondnum){
	int temp=*firstnum;
	*firstnum=*secondnum;
	*secondnum=temp;


}