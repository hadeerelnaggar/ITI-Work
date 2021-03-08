#include <stdio.h>
#include <conio.h>
#include <iostream.h>
#include <string.h>


class Emp{
public:
	int id;
	char name[51];
	float salary;
	float bonus;
	Emp(){
		id=0;
		//name="hhh";
		salary=0;
		bonus=0;
	}

};

void takeArrInput(Emp * arr,int size);

void displayArr(Emp * arr,int size);
int searchByCode(Emp *arr,int size,int code);
int searchByName(Emp *arr,int size,char *name);
void bubbleSort(Emp *arr,int size);
void main(void){
	Emp * empArr;
	int size;
	clrscr();
	printf("Please enter number of Employees:");
	scanf("%d",&size);
	empArr=new Emp[size];
	takeArrInput(empArr,size);
	cout<<searchByCode(empArr,size,1)<<endl;
	cout<<searchByName(empArr,size,"hadeer")<<endl;
	displayArr(empArr,size);
    cout<<"------------------------------------------------"<<endl;
	bubbleSort(empArr,size);
    displayArr(empArr,size);
	//displayArr(empArr,size);

	getch();

}
int searchByCode(Emp *arr,int size,int code){
	for(int i=0;i<size;i++){
		if(arr[i].id==code){
			return i;
		}
	}
	return -1;

}
int searchByName(Emp *arr,int size,char *name){
	for(int i=0;i<size;i++){
		if(!strcmp(arr[i].name,name)){
			return i;
		}
	}
	return -1;

}

void takeArrInput(Emp * arr,int size){
	int i;
	float salary;
	float bonus;
	for(i=0;i<size;i++){
		printf("Enter Employee %d id:",i+1);
		scanf("%d",&arr[i].id);
		cout<<"enter employee name:";
		cin>> arr[i].name;
		printf("Enter Employee %d salary:",i+1);
		scanf("%f",&salary);
		arr[i].salary=salary;
		printf("Enter Employee %d bonus:",i+1);
		scanf("%f",&bonus);
		arr[i].bonus=bonus;

	}

}
void displayArr(Emp * arr,int size){
	int i;
	for(i=0;i<size;i++){
		printf("Employee number %d has is %d and net salary %f \n",i+1,arr[i].id,arr[i].salary+arr[i].bonus);

	}


}

void bubbleSort(Emp *arr,int size){
	int sorted=0;
	int j=0;
	while(!sorted){
		sorted=1;
		for(int i=0;i<(size-1)-j;i++){
			if(arr[i].id>arr[i+1].id){
				Emp temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
				sorted=0;
			}

		}

		j++;

	}


}
