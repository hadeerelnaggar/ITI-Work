#include <iostream.h>
#include <conio.h>
#include <math.h>

struct complex{
private:
	int real;
	int imaginary;
public:
	complex(){
		real=0;
		imaginary=0;
		//cout<<"default"<<endl;
	}
	complex(int r,int imag){
		real=r;
		imaginary=imag;
		//cout<<"2 parameter"<<endl;
	}
	complex(int both){
		real=both;
		imaginary=both;
		//cout<<"1 parameter"<<endl;
	}

	complex(complex &c){
		real=c.real;
		imaginary=c.imaginary;
		//cout<<"this is copy constructor"<<endl;

	}

	int getreal(){
		return real;
	}
	int getimaginary(){
		return imaginary;
	}
	void setcomplex(){
		real=0;
		imaginary=0;

	}
	void setcomplex(int r,int i){
		real=r;
		imaginary=i;


	}
	void setcomplex(int both){
		real=imaginary=both;

	}
	complex add(complex x){
		complex temp;
		temp.real=real+x.real;
		temp.imaginary=imaginary+x.imaginary;
		return temp;
	}
	complex operator + (complex &s){
		complex sum(real+s.real,imaginary+s.imaginary);
		return sum;

	}
	complex operator + (int s){
		complex sum(real+s,imaginary);
		return sum;

	}
	complex subtract(complex x){
		complex temp;
		temp.real=this->real-x.real;
		temp.imaginary=this->imaginary-x.imaginary;
		return temp;
	}
	complex operator - (complex &s){
		complex sub(real-s.real,imaginary-s.imaginary);
		return sub;

	}

	void print(){
		if(imaginary>0){
			cout << real << " + " <<imaginary << "i";
		}
		else{
			cout << real << " - " <<fabs(imaginary) << "i";

		}

	}
	int operator== (complex &c){
		if(real!=c.real)
			return 0;
		if(imaginary!=c.imaginary)
			return 0;
		return 1;


	}
	int operator!= (complex &c){
		if(real==c.real)
			return 0;
		if(imaginary==c.imaginary)
			return 0;
		return 1;


	}

	// assignment operator not invoked

	complex& operator= (complex &c){
		real=c.real;
		imaginary=c.imaginary;
		//cout<<"operator"<<endl;
		return *this;

	}
	complex& operator+= (complex &c){
		real+=c.real;
		imaginary+=c.imaginary;
		return *this;

	}
	complex operator++(){
		real++;
		imaginary++;
		return *this;
	}
	complex operator++ (int dummy){
		complex x(*this);
		real++;
		imaginary++;
		return x;

	}
	complex operator--(){
		real--;
		imaginary--;
		return *this;
	}
	complex operator-- (int dummy){
		complex x(*this);
		real--;
		imaginary--;
		return x;

	}
	operator float(){
		return real;

	}
	friend complex operator+ (int x,complex &c);
	friend istream& operator>> (istream &in,complex &c);
	friend ostream& operator<< (ostream &out,complex &c);

	~complex(){
	  // cout << "destructor" <<endl;
	}


};

complex operator+ (int x,complex &c){
	complex temp(x+c.real,c.imaginary);
	return temp;


}
istream& operator>> (istream &in,complex &c){
	cout<<"Enter real number:";
	cin>>c.real;
	cout<<"\nEnter imaginary number:";
	cin>>c.imaginary;
	return in;

}
ostream& operator<< (ostream &out,complex &c){
	c.print();
	return out;

}

void main(){
	clrscr();
	complex x(2,4);
	complex * y=new complex(3,5);
	y->print();
	cout<<endl;
	complex z[2]={complex(3,4),complex(2,5)};
	for(int i=0;i<2;i++){
		cout<<z[i]<<endl;

	}
	complex *q = new complex[4];
	for(int j=0;j<4;j++){
		q[j]=complex(2,4);
		cout<<q[j]<<endl;

	}

	getch();

}