import java.util.Scanner;

class Tree {

	GridNode root;

	public Tree() {
		root = null;

	}

	void postOrder(GridNode node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.key + "  ");
	}

	void inOrder(GridNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.key + "  ");
		inOrder(node.right);
	}

	void preOrder(GridNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.key + "  ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	void postOrder()  {     postOrder(root);  } 
    void inOrder()    {     inOrder(root);   } 
    void preOrder()   {     preOrder(root);  } 

/*
	public static void main(String[] args) {

		Tree bigTree = new Tree();
		bigTree.root = new Node(1);
		bigTree.root.left = new Node(2);
		bigTree.root.right = new Node(3); 
        bigTree.root.left.left = new Node(4); 
        bigTree.root.left.right = new Node(5); 

        System.out.println("Preorder traversal of binary tree is "); 
        bigTree.preOrder(bigTree.root); 
  
        System.out.println("\nInorder traversal of binary tree is "); 
        bigTree.inOrder(bigTree.root); 
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        bigTree.postOrder(bigTree.root); 


	}

}
*/
	
	public static void main(String[] args) {
		String str = "5 7 31 6 200 1 90 7";
		Scanner reader = new Scanner(str);
		int length = 0;
		while (reader.hasNextInt()) {
			reader.nextInt();
			length++;
		}
		int[] array = new int[length];
		
		Scanner scan = new Scanner(str);
		for (int i =0; i<length; i++) {
			array[i] = scan.nextInt();
		}
		Tree bigTree = new Tree();
		bigTree.root = new GridNode(array[0]);
		for (int i = 1; i < length; i++) {
			bigTree.place(array[i], bigTree.root);
		}
		System.out.println("Preorder traversal of binary tree is "); 
        bigTree.preOrder(bigTree.root); 
  
        System.out.println("\nInorder traversal of binary tree is "); 
        bigTree.inOrder(bigTree.root); 
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        bigTree.postOrder(bigTree.root); 
		
	}
	

	public void place(int num, GridNode node) {

		if (num < node.key) {
			if (node.left == null) {
				node.left = new GridNode(num);
				return;
			}
		place(num, node.left);
		}
		else {
			if (node.right == null) {
				node.right = new GridNode(num);
				return;
			}
		place(num, node.right);
		}
		
	}
}



