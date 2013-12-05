package sabatino.esercizio13.searchTree;

public class SearchTree <K extends Comparable<K>,E extends ObjectWhitKey<K>>  implements Dictionary<K> {
	
	class Node<V extends Elem<K,E>>  {
		V elemKey;
		Node left;
		Node right; 
		int x, y, width, height;
		
		public Node(V elem) {
			this.elemKey = elem;
			left=right=null;
		}
		Node(V elemKey, int x, int y, int width, int height, Node left, Node right) {
	    this.elemKey = elemKey;
	    this.x = x;
	    this.y = y;
	    this.width = width;
	    this.height = height;
	    this.left = left;
	    this.right = right;
	  }
	}
	Node<E> root;
	
	public E put(E elem) {
		 if(root==null) {
			 root = new Node(elem);
			 return null;
		 }
		 else {
			 return put(elem,root);
		 }
	}
	
	private E put(E elem, Node node){
		E temp = null;
		if(elem.key().compareTo(node.elemKey.key())<0){
			if(node.left==null) {
				node.left= new Node(elem);
				return temp;
			}
			else return put(elem,node.left);
		}
		else if(elem.key().compareTo(node.elemKey.key())>0){
			if(node.right==null) {
				node.right= new Node(elem);
				return temp;
			}
			else return put(elem,node.right);
		}
		else{
			temp = node.elemKey;
			node.elemKey=elem;
			node.elemKey.key()elem=elem.key(); 
			return temp;
		}
	
	}

	public Elem<K> get(K key) {
		Node <K> temp;
		temp = findNode(key,root);
		 return temp.elemKey;
	}
	
	private Node<K> findNode(K key,Node <K> node){
		if(node!=null){
			if(key.compareTo(node.elemKey.key())<0)node = findNode(key,node.left);
			else if(key.compareTo(node.elemKey.key())>0)node = findNode(key,node.right);
			else return node;
		}
		return node;
	}


	public boolean isEmpty() {
		if(root == null)return true;
		return false;
	}

	

 //TODO remove
	public Elem<K> remove(K key) {	
		Elem<K> val = null; 
		val = remove(key,root).elemKey;
		return val;
	}
	
	private Node<K>  remove(K key,Node<K> node){
		if(node == null) return null;
		if(key.compareTo(node.elemKey.key())<0){
			if (node.left != null){
				System.out.println("sono passato da sinistra con elem: "+node.left.elemKey);
				node.left = remove(key,node.left);
			}
		}
		
		else if(key.compareTo(node.elemKey.key())>0){
		if(node.right != null){
			System.out.println("sono passato da destra con elem: "+node.right.elemKey);
			node.right =  remove(key,node.right);
		}
		}
			
		else{
			System.out.println("sono passato dal centro con elem: "+node.elemKey);
			if(node.left == null) node = node.right;
			else if(node.right == null) node = node.left;
			else{
				node.elemKey = min(node.right);
				node.right = deleteMin(node.right);
			}
		}
		return node;
	}
	private Elem<K> min(Node<K> node){
		while(node.left!=null) {
			node = node.left;
			System.out.print("qiesto è il minimo: "+node.elemKey);
		}
		return node.elemKey;
	}
	private  Node<K> deleteMin(Node<K> node){
		if(node.left==null) return node.right;
		node.left = deleteMin(node.left);
		return node; 
	}
	
	public int size() {
		
		return 0;
	}

	public void printInOrder() {
 	 if(root == null) System.out.println("albero vuoto");
    printInOrder(root);
    System.out.println();
 }

 protected void printInOrder(Node <K> node) {
 	if(node==null) return;
   printInOrder(node.left);
   System.out.println(node.elemKey.toString());
   printInOrder(node.right);
 }


@Override
public ObjectWhitKey<K> max() {
	// TODO Auto-generated method stub
	return null;
}







}
