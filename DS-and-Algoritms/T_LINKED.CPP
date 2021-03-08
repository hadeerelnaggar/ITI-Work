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

void main(){
	clrscr();

	Node<int> *n1=new Node<int> (6);
	Node<int> *n2=new Node<int> (4);
	Node<int> *n3=new Node<int> (9);
	Node <char> *n4=new Node<char>('w');
	Node<char> *n5=new Node<char>('x');
	LinkedList<char> c;
	c.insertNode(n4);
	c.appendNode(n5);
	c.printList();
	LinkedList<int> l;
	l.appendNode(n1);
	l.insertNode(n2);
	l.insertNode(n3);
	cout<<l.getsize()<<endl;
	//Node *q=l.search(6);
	l.deleteNode(6);
	//l.printList();
	cout<<l.getsize()<<endl;
	//cout<<q->data<<endl;
	getch();

}