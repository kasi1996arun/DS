import java.util.*;
class Stack{
	int[] array = null;
	int top ;
	Stack(){
		array = new int[1000];
		top = -1;
	}
	boolean push(int value){
		if(top -1 >= 1000){
			System.out.println("Stack size is already full");
			return false;
		}
		array[++top] = value;
		return true;
	}
	int pop(){
		if(top<0){
			System.out.println("Stack is empty");
			return -1;
		}
		int popedElement = array[top];
		top--;
		return popedElement;
	}
	int peek(){
		if(top < 0)
			System.out.println("Stack is empty");
		return array[top];
	}
	int size(){
		return top+1;
	}
	boolean isEmpty(){
		if(top < 0){
			return true;
		}
		return false;
	}
}
class BasicStackImplementation{
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(10);
		System.out.println(s.pop());
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		System.out.println("Peek element : "+s.peek());
		System.out.println(s.pop());
	}
}