package sabatino.esercizio13.searchTree;

public class SearchTreeTest {

	public static void main(String[] args) {
		SearchTree<String> st = new SearchTree<String, Integer>();
		System.out.println("put: "+st.put("primo", 1));
		System.out.println("put: "+st.put("terzo", 3));
		System.out.println("put: "+st.put("sesto", 6));
		System.out.println("put: "+st.put("terzo", 8));
		System.out.println("get: "+st.get("terzo"));
		System.out.println("get: "+st.get("primo"));
		System.out.println("get: "+st.get("sesto"));
		System.out.println("remove: "+st.remove("terzo"));
		//System.out.println("get: "+st.get("sesto"));
	}

}
