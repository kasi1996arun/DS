import java.util.*;
class Node{
	int value;
	Node next;
	Node previous;
	Node(int value){
		this.value = value;
		this.next = null;
		this.previous = null;
	}
}
class DoublyLinkedList{
	static Node createNode(int val){
		Node n = new Node(val);
		return n;
	}
	static void printList(Node head){
		if(head != null){
			Node temp = head;
			while(temp != null){
				System.out.println(temp.value);
				temp = temp.next;
			}
		}
	}
	static void printReverse(Node head){
		if(head != null){
			Node lastElement = findLastElement(head);
			Node temp = lastElement;
			while(temp != null){
				System.out.println(temp.value);
				temp = temp.previous;
			}
		}
	}
	static Node findLastElement(Node head){
		if(head == null){
			return null;
		}
		Node temp = head;
		while(temp != null){
			if(temp.next == null){
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}
	static Node insert(Node head, int value){
		Node lastNode = findLastElement(head);
		Node newNode = createNode(value);
		if(lastNode != null){
			lastNode.next = newNode;
			newNode.previous = lastNode;
		}
		return head;
	}
	static Node reverseLinkedList(Node head){
		Node lastElementInList = findLastElement(head);
		Node reversedList = lastElementInList;
		Node temp = lastElementInList;
		Node reversedListHead = temp;
		while(temp != null){
			// System.out.println(temp.value);
			Node currNodeNext = temp.next;
			Node currNodePrevious = temp.previous;
			reversedList.next =  currNodePrevious;
			reversedList.previous = currNodeNext;
			// System.out.println(currNodeNext+" "+currNodePrevious);
			temp = currNodePrevious;
			// System.out.println(currNodePrevious);
			reversedList = reversedList.next;
		}
		return reversedListHead;
	} 
	static Node findElement(Node head, int value){
		if(head != null){
			Node temp = head;
			while(temp != null){
				if(temp.value == value){
					return temp;
				}
			}
		}
		return null;
	}
	static Node deleteNode(Node head, int value){
		if(head != null){
			Node temp = head;
			while(temp != null){
				if(temp.value == value){
					if(temp.value == head.value){
						Node answer = temp.next;
						answer.previous = null;
						return answer;
					}
					Node previousNode = temp.previous;
					Node nextNode = temp.next;
					previousNode.next = nextNode;
					if(nextNode != null){
						nextNode.previous = previousNode;
					}
					return head;
				}
				temp = temp.next;
			}
		}
		return head;
	}
	public static void main(String[] args) {
		Node head = createNode(10);
		head = insert(head, 20);
		head = insert(head, 30);
		head = insert(head, 40);
		head = insert(head, 50);

		printList(head);

		System.out.println("\n Print the list in reverse \n");

		printReverse(head);


		System.out.println("\n Reverse a doubly linked list \n ");

		Node reversedListHead = reverseLinkedList(head);

		printList(reversedListHead);

		System.out.println("\n Delete a node in doubly linked list \n");

		reversedListHead = deleteNode(reversedListHead, 50);

		printList(reversedListHead);
	}
}