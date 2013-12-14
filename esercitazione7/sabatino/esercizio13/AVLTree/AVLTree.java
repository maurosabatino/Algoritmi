package sabatino.esercizio13.AVLTree;



public class AVLTree implements Dictionary{
	Node root;
	
	
	@Override
	public ObjectWhitKey get(int key) {
		return get(key,root);
	}
	public ObjectWhitKey get(int key,Node node){
		if(node ==null) return null;
		if(key<node.value.key()) return get(key,node.left);
		else if(key>node.value.key()) return get(key,node.right);
		else return node.value;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ObjectWhitKey put(ObjectWhitKey element) {
		
		root = put(element,root);
		return root.value;
	}
	public Node put(ObjectWhitKey element,Node node) {
		if(node==null){
			System.out.println("sono nella root, key: "+element.key());
			node = new Node(element);
		}else if(element.key()<node.value.key()){
			System.out.println("sono a sinistra");
			node.left=put(element,node.left);
			if((height(node.left)-height(node.right)) == 2){
				if(element.key() > node.left.value.key())node.left=S(node.left);
					node = R(node);
			}
		}else if(element.key() > node.value.key()) {
			System.out.println("sono a destra");
			node.right=put(element,node.right);
			if((height(node.right)-height(node.left)) == 2){
				if(element.key() < node.right.value.key()) node.right=R(node.right);
				node = S(node);
			}
		}
		node.height = (max(height(node.left),height(node.right))+1);
		return node;
	}
	

	@Override
	public ObjectWhitKey remove(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ObjectWhitKey max() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectWhitKey min() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Node R(Node d){
		Node s ;
		s =d.left;
		d.left=s.right;
		s.right=d;
		d.height=max(height(d.left),height(d.right))+1;
		s.height=max(height(s.left),height(s.right))+1;
		return s;
	}
	public Node S(Node s){
		Node d;
		d=s.right;
		s.right=d.left;
		d.left=s;
		s.height=max(height(s.left),height(s.right))+1;
		d.height=max(height(d.left),height(d.right))+1;
		return d;
	}
	
	public int height(Node node){
		if(node==null) return -1;
		else return node.height;
	}

	 public static int max (int lhs, int rhs) {
		 return lhs > rhs ? lhs : rhs;
	 }
	 

}
