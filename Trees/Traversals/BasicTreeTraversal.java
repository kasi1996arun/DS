import java.util.*;
class Node{
	int value;
	Node left;
	Node right;
	Node(int value){
		this.value = value;
		this.left = this.right = null;
	}
}
class BasicTreeTraversal{
	static Node createNewNode(int value){
		Node newNode = new Node(value);
		return newNode;
	}
	static void printInOrder(Node rootNode){
		if(rootNode == null)
			return;
		printInOrder(rootNode.left);
		System.out.println(rootNode.value);
		printInOrder(rootNode.right);
	}
	static void printPreOrder(Node rootNode){
		if(rootNode == null)
			return;
		System.out.println(rootNode.value);
		printInOrder(rootNode.left);
		printInOrder(rootNode.right);
	}
	static void printPostOrder(Node rootNode){
		if(rootNode == null)
			return;
		printInOrder(rootNode.left);
		printInOrder(rootNode.right);
		System.out.println(rootNode.value);
	}
	static void printBFS(Node rootNode){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode);
		while(true){
		int size = queue.size();
		if(size == 0)
			break;
		while(size>0){
			Node currNode = queue.peek();
			System.out.println(currNode.value);
			Node leftNode = currNode.left;
			Node rightNode = currNode.right;
			queue.remove();
			if(leftNode != null)
				queue.add(leftNode);
			if(rightNode != null)
				queue.add(rightNode);
			size--;
			}
		}
	}
	static int heightOfTree(Node rootNode){
		if(rootNode == null)
			return 0; 
		int leftHeight = heightOfTree(rootNode.left);
		int rightHeight = heightOfTree(rootNode.right);
		if(leftHeight > rightHeight)
			return leftHeight+1;
		else
			return rightHeight+1;

	}
	static void printLevelOrderTraversal(Node rootNode){
		if(rootNode == null)
			return;
		int height = heightOfTree(rootNode);
		if(height == 1)
			System.out.println(rootNode.value);
		for(int i = 1;i<=height; i++){
			System.out.println("Nodes in Level "+ i+" :\n");
			printBFSIterative(rootNode, i);
		}
	}
	static void printBFSIterative(Node node, int level){
		if(node == null)
			return;
		if(level == 1)
			System.out.println(node.value);
		printBFSIterative(node.left, level-1);
		printBFSIterative(node.right, level-1);
	}
	public static void main(String[] args) {
		Node rootNode = createNewNode(10);
		rootNode.left = createNewNode(20);
		rootNode.right = createNewNode(30);
		rootNode.left.left = createNewNode(40);
		rootNode.left.right = createNewNode(50);
		rootNode.right.left = createNewNode(60);
		rootNode.right.right = createNewNode(70);

		System.out.println("BFS using queue \n");
		printBFS(rootNode);

		System.out.println("BFS using iterative method : \n");
		printLevelOrderTraversal(rootNode);

		System.out.println("DFS\nInOrder :\n");
		printInOrder(rootNode);

		System.out.println("PreOrder :\n");
		printPreOrder(rootNode);

		System.out.println("PostOrder :\n");
		printPostOrder(rootNode);

	}
}