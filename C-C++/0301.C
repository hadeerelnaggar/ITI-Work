#include <stdio.h>
#include <conio.h>
typedef struct{
		int id;
		char name [51];
		int age;
		float salary;
		float bonus;

	}Emp;

void displayEmp (Emp e);

Emp readEmp();

void main(void){
	Emp e={000,"",000,0.00,0.00};
	int input=0;
	clrscr();
	gotoxy(35,8);
	printf("1-Enter employee \n");
	gotoxy(35,9);
	printf("2-Display employee \n");
	gotoxy(35,10);
	printf("3-Exit \n");
	while(input!=3){
    	printf("Enter your choice");
		scanf("%d",&input);
		switch(input){
			case 1:
				e=readEmp();
				break;
			case 2:
				if(e.id==000){
					printf("you must enter employee first");
                    continue;
				}
				displayEmp(e);
				break;
			case 3:
				return 0;

		}
	}
	getch();

}
Emp readEmp(){
	Emp e;
	float salary;
	float bonus;
	printf("Enter employee id:");
	scanf("%d",&e.id);
	printf("Enter employee name:");
	flushall();
	scanf("%s",&e.name);
	printf("Enter employee salary:");
	scanf("%f",&salary);
	e.salary=salary;
	printf("Enter employee bonus:");
	scanf("%f",&bonus);
	e.bonus=bonus;
    return e;
}

void displayEmp (Emp e){
	printf("Employee id is:%d \n",e.id);
	printf("Employee name is: %s \n",e.name);
	printf("Employee net salary is: %f",e.salary+e.bonus);


}