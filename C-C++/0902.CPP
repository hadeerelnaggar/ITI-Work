#include <iostream.h>
#include <conio.h>
#include <stdio.h>

class Geoshape{
protected:
	double dim1;
	double dim2;
public:
	Geoshape(){
		dim1=0;
		dim2=0;
	}
	Geoshape(double x,double y){
		dim1=x;
		dim2=y;
	}
	Geoshape(double x){
		dim1=dim2=x;
	}
	double get_dim1(){
		return dim1;
	}
	double get_dim2(){
		return dim2;
	}
	void set_dim1(double x){
		dim1=x;
	}
	void set_dim2(double y){
		dim2=y;
	}
	~Geoshape(){
	}
	double calc_area();
	void print_shape(){
		cout<<dim1<<" "<<dim2<<endl;
	}


};
class Rect:public Geoshape{
public:
	Rect():Geoshape(){

	}
	Rect(double x,double y):Geoshape(x,y){}
	Rect(double x):Geoshape(x){}
	double calc_area(){
		return dim1*dim2;
	}
};

class Triangle:public Geoshape{
public:
	Triangle():Geoshape(){

	}
	Triangle(double x,double y):Geoshape(x,y){}
	Triangle(double x):Geoshape(x){}
	double calc_area(){
		return 0.5*dim1*dim2;
	}


};
class Circle:protected Geoshape{
public:
	Circle():Geoshape(){

	}
	Circle(double x,double y):Geoshape(x,y){}
	Circle(double x):Geoshape(x){}
	double calc_area(){
		return 3.14*dim1*dim2;
	}
	void set_radius(double x){
		dim1=dim2=x;
	}

};

class Square:protected Rect{
public:
	Square():Rect(){

	}
	Square(double x,double y):Rect(x,y){}
	Square(double x):Rect(x){}
	double calc_area(){
		return dim1*dim2;
	}
	void set_square_dim(double x){
		dim1=dim2=x;
	}

};

int main(){
	clrscr();
	Circle c;
	c.set_radius(7);
	cout<<"area of circle is:"<<c.calc_area()<<endl;
	Triangle t;
	t.set_dim1(10);
	t.set_dim2(9);
	cout<<"area of triangle is:"<<t.calc_area()<<endl;
	Rect r;
	r.set_dim1(2);
	r.set_dim2(6);
	cout<<"area of rectangle is:"<<r.calc_area()<<endl;
	Square s;
	s.set_square_dim(5);
	cout<<"area of square is:"<<s.calc_area()<<endl;
	//cout<<"square dimentions is ";
	//	c.setdim_2(7);
	// s.set_dim2(5);
	//s.Rect::set_dim2(10);

	getch();
 	return 0;
}