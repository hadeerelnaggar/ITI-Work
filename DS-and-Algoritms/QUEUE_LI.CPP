#include <iostream.h>
#include <conio.h>
class Node{

public:
	int data;
	Node *prev;
	Node *next;


	Node(){
		data=0;
		prev=NULL;
		next=NULL;
	}
	Node(int d){
		data=d;
		prev=NULL;
		next=NULL;

	}
	Node(int d,Node *p,Node *n){
		data=d;
		prev=p;
		next=n;
	}
	Node(Node &n){
		data=n.data;
		prev=n.prev;
		next=n.next;
	}

};
class LinkedList{
	Node *start;
	Node *end;
	int size;
public:
	LinkedList(){
		start=end=NULL;
		size=0;
	}
	Node *getStart(){
		return start;
	}
	Node * getEnd(){
		return end;
	}
	void setStart(Node *n){
		start=n;
	}
	void setEnd(Node *n){
		end=n;
	}
	void appendNode(Node *ele);
	void insertNode(Node *ele);
	int getsize();
	Node* search(int key);
	int deleteNode(int key);
	void freeList();
	int isEmpty();
	void printList();
	Node * getfirst();
	Node *getlast();
	Node *peekfirst();
	Node * peeklast();

};
Node * LinkedList::getfirst(){
	Node *temp=start;
	deleteNode(start->data);
	return temp;
}

Node * LinkedList::getlast(){
	Node *temp=end;
	deleteNode(end->data);
	return temp;
}

Node * LinkedList::peekfirst(){
	return start;
}

Node * LinkedList::peeklast(){
	return end;
}

void LinkedList::appendNode(Node *ele){
	if(!start){
		start=end=ele;
		size++;
		return;
	}
	ele->prev=end;
	end->next=ele;
	end=ele;
	size++;
	return;

}
void LinkedList::insertNode(Node *ele){
	Node *temp=start;
	while(temp && temp->data<ele->data){
		temp=temp->next;

	}
	if(!temp)
		appendNode(ele);
	else if(temp==start){
		ele->next=start;
		start->prev=ele;
		start=ele;
		size++;
	}
	else{
		ele->next=temp;
		ele->prev=temp->prev;
		temp->prev->next=ele;
		temp->prev=ele;
		size++;
	}

}
int LinkedList::isEmpty(){
	return size==0;
}
Node* LinkedList::search(int key){
	Node *temp=start;
	while(temp){
		if(temp->data==key)
			return temp;
		temp=temp->next;
	}
	return temp;
}

int LinkedList::getsize(){
		return size;
}
int LinkedList::deleteNode(int key){
	Node *temp=search(key);
	if(!temp){
		return 0;
	}

	if(temp==start){
		start=start->next;
		start->prev=NULL;
		//delete temp;
		size--;
		return 1;
	}

	if(temp==end){
		temp->prev->next=NULL;
		end=temp->prev;
		delete temp;
		size--;
		return 1;
	}
	else{
		temp->prev->next=temp->next;
		temp->next->prev=temp->prev;
		size--;
		//delete temp;
		return 1;
	}
}
void LinkedList::freeList(){
	while(start){
		deleteNode(start->data);
	}
}
void LinkedList::printList(){
	Node *temp=start;
	while(temp){
		cout<<temp->data<<endl;
		temp=temp->next;
	}
}
class Queue{
	LinkedList l;
	int size;
public:
	Queue(){
		size=0;
	}
	void push(Node *n);
	Node * pop();
	Node * peek();
	int getSize();
	int isFull();
	int isEmpty();


};
void Queue::push(Node *n){
	if(!l.getStart()){
		l.setStart(n);
		l.setEnd(n);
	}
	else{
		l.appendNode(n);
	}
	size++;
}
Node * Queue::pop(){
	if(isEmpty()) return NULL;
	return l.getfirst();
}
Node * Queue::peek(){
	if(isEmpty()) return NULL;
	return l.peekfirst();
}
int Queue::getSize(){
	return size;
}
int Queue::isFull(){
	Node *temp;
	if((temp=new Node())){
		delete temp;
		return 0;
	}
	return 1;

}
int Queue::isEmpty(){
	return (size==0);
}
void main(){
	clrscr();
	Queue x;
	Node *n1=new Node(9);
	Node *n2=new Node(4);
	x.push(n1);
	x.push(n2);
	Node *res;
	res=x.pop();
	cout<<res->data<<endl;
	res=x.peek();
	cout<<res->data<<endl;
	getch();
}
