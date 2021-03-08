#include <stdio.h>
#include <conio.h>
typedef struct {
	int id;
	char name [51];
	float salary;
	float bonus;

} Emp;

void showmenu();
void addEmployee(Emp * employees);
int searchemp(Emp * employees,int id);
void updateEmployee(Emp * employees);
void deleteEmployee(Emp * employees);
void showEmployees(Emp * employees);

int empcount=0;
int employeenum;

void main(void){
	int input;
	Emp * employees;
	clrscr();
	printf("Enter number of employees");
	scanf("%d",&employeenum);
	employees=(Emp *) malloc(employeenum * sizeof(Emp));
	while(1){
		showmenu();
		scanf("%d",&input);
		switch(input){
			case 1:
				clrscr();
				addEmployee(employees);
				printf("press any key to continue");
				getch();
				break;
			case 4:
				clrscr();
				showEmployees(employees);
				printf("press any key to continue");
				getch();
				break;
			case 0:
				return 0;
			case 2:
				clrscr();
				updateEmployee(employees);
				printf("press any key to continue");
				getch();
				break;
			case 3:
				clrscr();
				deleteEmployee(employees);
				printf("press any key to continue");
				getch();
				break;

		}
	}


	getch();


}

void showmenu(){
	clrscr();
	gotoxy(33,12);
	printf("0-Exit \n");
	gotoxy(33,13);
	printf("1-add Employee");
	gotoxy(33,14);
	printf("2-update Employee");
	gotoxy(33,15);
	printf("3-delete Employee");
	gotoxy(33,16);
	printf("4-display Employees");
	gotoxy(33,17);
	printf("choice:");
}

void showEmployees(Emp * employees){
	int i;
	if(empcount==0){
		printf("no available employees yet \n");
	}
	for(i=0;i<empcount;i++){
		printf("Employee id is %d \nEmployee name is %s \n",employees[i].id,employees[i].name);
		printf("Employee net salary is %f \n",employees[i].salary+employees[i].bonus);
		printf("----------------------------------------------------------- \n");
	}

}


void addEmployee(Emp * employees){
	float salary,bonus;
	if(empcount>=employeenum){
		printf("sorry the array of employees is full \n");
		return;
	}
	printf("Enter employee id:");
	scanf("%d",&employees[empcount].id);
	printf("Enter employee name:");
	flushall();
	gets(employees[empcount].name);
	printf("Enter employees salary:");
	flushall();
	scanf("%f",&salary);
	employees[empcount].salary=salary;
	printf("Enter employees bonus:");
	flushall();
	scanf("%f",&bonus);
	employees[empcount].bonus=bonus;
	empcount++;

}

int searchemp(Emp * employees,int id){
	int i;
	for(i=0;i<empcount;i++){
		if(employees[i].id==id){
			printf("hh");
			return i;
		}

	}
	return -1;



}

void updateEmployee(Emp * employees){
	int id,index;
	float salary,bonus;
	printf("Enter id of employee you want to update:");
	scanf("%d",&id);
	index=searchemp(employees,id);
	if(index==-1){
		printf("no employee found with this id \n");
		return;


	}
	printf("Employee id is %d \nEmployee name is %s \n",employees[index].id,employees[index].name);
	printf("Employee salary is %f \nEmployee bonus is %f \n",employees[index].salary,employees[index].bonus);
	printf("----------------------------------------------------------- \n");
	printf("Enter new name:");
	flushall();
	gets(employees[index].name);
	printf("Enter new salary:");
	flushall();
	scanf("%f",&salary);
	employees[index].salary=salary;
	printf("Enter new bonus:");
	flushall();
	scanf("%f",&bonus);
	employees[index].bonus=bonus;



}

void deleteEmployee(Emp * employees){
	int id,index,i;
	printf("Enter id of employee you want to delete:");
	scanf("%d",&id);
	index=searchemp(employees,id);
	if(index==-1){
		printf("no employee found with this id \n");
		return;


	}
	for(i=index;i<empcount;i++){
		employees[i]=employees[i+1];

	}
	empcount--;

}