#include <iostream.h>
#include <conio.h>
#include <graphics.h>
#include <stdio.h>

class Point{
	int x;
	int y;
public:
	Point(){
		x=0;
		y=0;

	}
	Point(Point &p){
		x=p.x;
		y=p.y;

	}
	Point(int a,int b){
		x=a;
		y=b;

	}
	~Point(){
		//cout<<"this is point destructor"<<endl;

	}
	void setpoint(int a,int b){
		x=a;
		y=b;

	}
	int getX(){
		return x;
	}
	int getY(){
		return y;
	}
	Point operator = (Point &p){
		x=p.x;
		y=p.y;
		return *this;

	}



};
class Line{
	Point start;
	Point end;
public:
	Line():start(),end(){
		//cout<<"line default constructor"<<endl;

	}
	Line(int x1,int y1,int x2,int y2):start(x1,y1),end(x2,y2){
		//cout<<"line 4 parameter constructor"<<endl;
	}
	Line(Line &l){
		start=l.start;
		end=l.end;
	}
	~Line(){
		//cout<<"line destructor"<<endl;

	}
	void draw(){
		line(start.getX(),start.getY(),end.getX(),end.getY());

	}
	Line& operator = (Line & x){
		start=x.start;
		end=x.end;
		return *this;

	}

};
class Rect{
	Point upleft;
	Point downright;
public:
	Rect():upleft(),downright(){


	}
	Rect(int x1,int y1,int x2,int y2):upleft(x1,y1),downright(x2,y2){
		//cout<<"line 4 parameter constructor"<<endl;
	}
	Rect(Rect &r){
		upleft= r.upleft;
		downright=r.downright;

	}
	void draw(){
		rectangle(upleft.getX(),upleft.getY(),downright.getX(),downright.getY());


	}

};
class Circle{
	Point centre;
	int rad;
public:
	Circle():centre(){
		rad=0;

	}
	Circle(int x,int y,int r):centre(x,y){
		rad=r;

	}
	Circle(Circle & c){
		centre=c.centre;
		rad=c.rad;

	}
	void draw(){
		circle(centre.getX(),centre.getY(), rad);
	}
};
class Pic{
	int nl,nc,nr;
	Line * pl;
	Rect * pr;
	Circle *pc;
public:
	Pic(){
		nl=nc=nr=0;
		pl=NULL;
		pr=NULL;
		pc=NULL;

	}
	Pic(int x,int y,int z,Line * a,Circle * b,Rect * c){
		nl=x;
		nc=y;
		nr=z;
		pl=a;
		pc=b;
		pr=c;
	}
	~Pic(){
		if(pr) delete [] pr;
		if(pl) delete [] pl;
		if(pc) delete [] pc;
	}
	void paint(){
		for(int i=0;pl&& i<nl;i++){
			pl[i].draw();

		}
		for(i=0;pc && i<nc;i++){
			pc[i].draw();

		}
		for(i=0;pr && i<nr;i++){
			pr[i].draw();
		}
	}


};


int main(){
	clrscr();
	 /* request auto detection */
	int gdriver = DETECT, gmode, errorcode;
	int xmax, ymax;

	/* initialize graphics and local variables */
	initgraph(&gdriver, &gmode, "D://BGI");

	/* read result of initialization */
	errorcode = graphresult();
	/* an error occurred */
	if (errorcode != grOk)
	{
		printf("Graphics error: %s\n", grapherrormsg(errorcode));
		printf("Press any key to halt:");
		getch();
		return 1;
	}

	xmax = getmaxx();
	ymax = getmaxy();
	Line * lines=new Line [3];
	Rect * rects=new Rect[1];
	Circle * circles= new Circle[2];
	lines[0]=Line(100,220,250,220);
	lines[1]=Line(100,220,120,150);
	lines[2]=Line(120,150,250,220);

	rects[0]=Rect(50,220,300,250);

	circles[0]=Circle(125,225,15);
	circles[1]=Circle(220,225,15);
	Pic p(3,2,1,lines,circles,rects);
	p.paint();



	getch();

}