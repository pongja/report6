public class BST {

	public static void main(String args[]) {

		BinarySearchTree bsT = new BinarySearchTree();
		bsT.insertBST('G');
		bsT.insertBST('I');
		bsT.insertBST('H');
		bsT.insertBST('D');
		bsT.insertBST('B');
		bsT.insertBST('M');
		bsT.insertBST('N');
		bsT.insertBST('A');
		bsT.insertBST('J');
		bsT.insertBST('E');
		bsT.insertBST('Q');

		System.out.printf("\nBinary Tree >>> ");
		bsT.printBTS();

		System.out.printf("Is There \"A\"? >>> ");
		TreeNode p1 = bsT.searchBST('A');
		if(p1 != null)
			System.out.printf("Searching Success! Searched key: %c \n",  p1.data);
		else
			System.out.printf("Searching fail!! There is no %c \n", p1.data);

		System.out.printf("Is There \"Z\"? >>> ");
		TreeNode p2 = bsT.searchBST('Z');
		if(p2 != null)
			System.out.printf("Searching Success! Searched key: %c \n", p2.data);
		else
			System.out.printf("Searchingfail!! \n");	
	}
}

public class BST<Key extends Comparable<Key>, Value> {
	public Node<Key, Value> root;
	public Node<Key, Value> getRoot() {return root;}
	public BST(Key newId, Value newName) {
		root = new Node<Key, Value>(newId, newName);
	}

	public Value get(Key k) {return get(root k);}
	public Value get(Node<Key, Value> n, key k) {
		if(n == null) return null; 
		int t = n.getKey().compareTo(k);
		if(t > 0)
			return get(n.getLeft(), k);
		else if(t < 0) 
			return get(n.getRight(), k);
		else
			return (Value) n.getValue(); 
	}

	public void put(Key k, Value v) {root = put(root, k, v);}
	public Node<Key, Value> put(Node<Key, Value> n, key k, Value v) {

		if(n == null) return new Node<Key, Value>(k, v);
		int t = n.getKey().compareTo(k);
		if(t > 0) n.setLeft(put(n.getLeft(), k, v));
		else if(t < 0) n.setRight(put(n.getRight(), k,v));
		else n.setValue(v);
		return n;
	}

	public Key min() {
		if(root == null) return null;
		return (Key) min(root).getKey();
	}

	private Node<Key, Value> min(Node<Key, Value> n) {
		if(n.getLeft() == null) return n;
		return min(n.getLeft());
	}

	public void deleteMin() {
		if(root == null) System.out.println("empty ¨¡¢ç¢¬¢ç");
		root = deleteMin(root);
	}

	public Node<Key, Value> deleteMin(Node<Key, Value> n) {
		if(n.getLeft() == null) 
			return n.getRight();
		n.setLeft(deleteMin(n.getLeft()));
		return n;
	}

	public void deleteMax() {
		if(root == null) System.out.pritln("empty ¨¡¢ç¢¬¢ç");
		root = deleteMax(root);
	}

	private Node<key, Value> deleteMax(Node<Key, Value> n) {
		if(n.getRight() == null)
			return n.getLeft();
		n.setRight(deleteMax(n.getRight()));
		return n;
	}

	public void delete(Key k) {root = delete(root, k);}

	public Node<Key, Value> delete(Node<Key, Value> n, Key k) {
		if(n==null) return null;
		int t = n.getKey().compareTo(k);
		if(t > 0) n.setLeft(delete(n.getLeft(), k));
		else if(t < 0) n.setRight(delete(n.getRight(), k));
		else {
			if(n.getRight() == null) return n.getLeft(); 
			if(n.getLeft() == null) return n.getRight();
			Node<Key, Value> target = n; 
			n = min(target.getRight());
			n.setRight(deleteMin(target.getRight()));
			n.setLeft(target.getLeft());
		}
		return n;		
	}

	public void print(Node<Key, Value> root) {
		System.out.printf("\ninorder:\n");
		inorder(root);
	}

	public void inorder(Node<Key, Value> n) {
		if(n != null) {
			inorder(n.getLeft());
			System.out.print(n.getKey()+ " ");
			inorder(n.getRight());
		}
	}
}