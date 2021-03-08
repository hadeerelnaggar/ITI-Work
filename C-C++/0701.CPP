#include <iostream.h>
#include <conio.h>
class stack{
private:
	int top;
	int size;
	int *ptr;
	static int counter;
public:
	stack(){
		top=0;
		size=10;
		ptr=new int [size];
		counter++;
		cout<<"this is the default constructor"<<endl;

	}
	stack(int n){
		top=0;
		size=n;
		ptr=new int [size];
		counter++;
		cout<<"this is constructor with one parameter" <<endl;

	}
	stack(stack &s){
		top=s.top;
		size=s.size;
		ptr=new int[size];
		for(int i=0;i<size;i++){
			ptr[i]=s.ptr[i];
		}
		cout<<"this is copy constructor"<<endl;

	}

	~stack(){
		delete [] ptr;
		counter--;
		cout <<"this is destructor" << endl;
	}
	int isfull(){
		return (top==size);

	}
	int isempty(){
		return (top==0);
	}
	int push(int n){
		if(isfull()){
			return 0;
		}
		ptr[top]=n;
		top++;
		return 1;

	}
	static int getcounter(){
		return counter;
	}

	int pop(int &n){
		if(isempty()){
			return 0;

		}
		top--;
		n=ptr[top];
		return 1;


	}
	stack& operator = (stack &s){
		top=s.top;
		size=s.size;
		ptr=new int[size];
		for(int i=0;i<size;i++){
			ptr[i]=s.ptr[i];
		}
		cout<<"operator"<<end;
		return *this;


	}
	friend void viewcontent(stack s);


};

int stack::counter = 0;

void viewcontent(stack s){
	for(int i=0;i<s.top;i++){
		cout<<"element number "<<i+1<<" is "<<s.ptr[i]<<endl;
	}


}

void main(){
	clrscr();
	int num;
	stack s1(2);
	cout<< "number of objects is " << stack::getcounter() << endl;
	cout<< "number of objects is " << stack::getcounter() << endl;
	s1.push(5);
	s1.push(14);
	s1.push(10);
    cout<<"s1 is"<<endl;
	viewcontent(s1);
	stack s2;
	s2=s1;
	cout<<"s2 is"<<endl;
	viewcontent(s2);

	getch();


}

