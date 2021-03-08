#include <iostream.h>
#include <conio.h>
template<class T>
class Node{

public:
	T data;
	Node *prev;
	Node *next;


	Node(){
		data=0;
		prev=NULL;
		next=NULL;
	}
	Node(T d){
		data=d;
		prev=NULL;
		next=NULL;

	}
	Node(T d,Node *p,Node *n){
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
template <class T>
class LinkedList{
	Node<T> *start;
	Node<T> *end;
	int size;
public:
	LinkedList(){
		start=end=NULL;
		size=0;
	}
	void appendNode(Node<T> *ele);
	void insertNode(Node<T> *ele);
	int getsize();
	Node<T>* search(T key);
	int deleteNode(T key);
	void freeList();
	int isEmpty();
	void printList();
	Node<T> * getfirst();
	Node<T> *getlast();
	Node<T> *peekfirst();
	Node<T> * peeklast();

};
template <class T>
Node<T> * LinkedList<T>::getfirst(){
	Node<T> *temp=start;
	deleteNode(start->data);
	return temp;
}
template <class T>
Node<T> * LinkedList<T>::getlast(){
	Node<T> *temp=end;
	deleteNode(end->data);
	return temp;
}
template <class T>
Node<T> * LinkedList<T>::peekfirst(){
	return start;
}
template <class T>
Node<T> * LinkedList<T>::peeklast(){
	return end;
}
template <class T>
void LinkedList<T>::appendNode(Node<T> *ele){
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
template <class T>
void LinkedList<T>::insertNode(Node<T> *ele){
	Node<T> *temp=start;
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
template <class T>
int LinkedList<T>::isEmpty(){
	return size==0;
}
template <class T>
Node<T>* LinkedList<T>::search(T key){
	Node<T> *temp=start;
	while(temp){
		if(temp->data==key)
			return temp;
		temp=temp->next;
	}
	return temp;
}
template <class T>
int LinkedList<T>::getsize(){
		return size;
}
template <class T>
int LinkedList<T>::deleteNode(T key){
	Node<T> *temp=search(key);
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
template <class T>
void LinkedList<T>::freeList(){
	while(start){
		deleteNode(start->data);
	}
}
template <class T>
void LinkedList<T>::printList(){
	Node<T> *temp=start;
	while(temp){
		cout<<temp->data<<endl;
		temp=temp->next;
	}
}
template <class T>
class Stack{
	LinkedList<T> l;
	int size;
public:
	Stack(){
		size=0;
	}
	Node<T> * pop();
	void push(Node<T> * n);
	Node<T> * peek();
	int getSize();
	int isEmpty();
	int isFull();


};
template <class T>
Node<T> * Stack<T>::pop(){
	if(isEmpty()) return NULL;
	size--;
	return l.getlast();
}
template <class T>
void Stack<T>::push(Node<T> * n){
	if(isFull()) return;
	l.appendNode(n);
	size++;
}

template <class T>
Node<T> * Stack<T>::peek(){
	return l.peeklast();
}
template <class T>
int Stack<T>::getSize(){
	return size;
}
template <class T>
int Stack<T>::isEmpty(){
	return (size==0);
}
template <class T>
int Stack<T>::isFull(){
	Node<T> *temp;
	if((temp=new Node<T>())){
		delete temp;
		return 0;
	}
	return 1;
}
void main(){
	clrscr();
	Stack <int>s;
	Node<int> *n1=new Node<int> (2);
	Node<int> *n2=new Node<int> (6);
	Node<int> *n3;
	s.push(n1);
	s.push(n2);
	n3=s.pop();
	cout<<n3->data<<endl;
	Stack<char> c;
	Node<char> *nc=new Node<char> ('u');
	Node<char> *nc1=new Node<char> ();
	c.push(nc);
	nc1=c.pop();
	cout<<nc1->data<<endl;

	getch();
}
