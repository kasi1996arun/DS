import java.util.*;
class Node{
		int value;
		Node next;
		Node(int value){
			this.value = value;
			this.next = null;
		}
	}
class SingleLinkedListCycle{
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
	static void insert(Node head, int val){
		Node lastNode = findLastElement(head);
		Node newNode = createNode(val);
		lastNode.next = newNode;
	}
	static void findLoop(Node head){
		Node temp1= head;
		Node temp2 = head;
		while(temp2!=null && temp1!=null){
			if(temp1 == temp2){
				System.out.println("Yes");
				break;
			}else{
				temp1 = temp1.next;
				temp2 = temp2.next.next;
			}
		}
	}
	public static void main(String[] args) {
		Node head = createNode(10);
		insert(head, 20);
		insert(head, 30);
		insert(head, 40);
		insert(head, 50);
		insert(head, 60);

		System.out.println("Initial linked list : \n");
		printList(head);

		head.next.next.next.next.next.next = head.next;

		findLoop(head);
	}
}