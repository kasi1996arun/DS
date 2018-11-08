import java.util.*;
class Node{
	int value;
	Node next;
	Node(int value){
		this.value = value;
		this.next = null;
	}
}
class SingleLinkedList{
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
	static int findElement(Node head, int value){
		int index = -1;
		if(head != null){ 
			Node temp = head;
			while(temp != null){
				index++;
				if(temp.value == value){
					return index;
				}
				temp = temp.next;
			}
		}
		return index;
	}
	static Node delete(Node head, int value){
		int index = findElement(head, value);
		return deleteElementAtIndex(head, index);
	}
	static Node deleteElementAtIndex(Node head, int index){
		System.out.println("Index to be deleted = "+index);
		if(index >= 0){
			Node temp = head;
			Node prevNode = null;
			int currIndex = 0;
			while(temp != null){
				if(currIndex == index){
					System.out.println("prevNode = "+prevNode);
					if(prevNode == null){
						// System.out.println(head.value+" "+head.next.value);
						head = head.next;
						return head;
					}
					Node nextNode = temp.next;
					prevNode.next = nextNode;
					return head;
				}else{
					prevNode = temp;
					temp = temp.next;
					// return head;
				}
				currIndex++;
			}
			return head;
		}
		return head;
	}
	static int findLengthOfList(Node head){
		if(head == null)
			return 0;
		Node temp = head;
		int cnt = 0;
		while(temp != null){
			temp = temp.next;
			cnt++;
		}
		return cnt;
	}
	static Node createNode(int val){
		Node n = new Node(val);
		return n;
	}
	public static void main(String[] args) {
		Node head = createNode(10);
		insert(head, 20);
		insert(head, 30);
		System.out.println("Initial linked list : \n");
		printList(head);
		System.out.println("Deleting 20 : \n");
		head = delete(head, 20);
		printList(head);
		
		System.out.println("Insert 40 \n");
		insert(head, 40);
		System.out.println("Status :\n");
		printList(head);

		System.out.println("Size of linkedList");
		System.out.println(findLengthOfList(head));
		

		System.out.println("Deleting last index:\n");
		head = deleteElementAtIndex(head, findLengthOfList(head)-1);
		printList(head);

		System.out.println("Deleting first element:\n");
		head = deleteElementAtIndex(head, 0);
		printList(head);

		
	}
}