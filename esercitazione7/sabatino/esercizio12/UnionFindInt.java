package sabatino.esercizio12;

public class UnionFindInt implements UnionFind {
	
	private int[] parentOrNSize;
	private int count;
	
	UnionFindInt(int n){
		parentOrNSize = new int[n];
		count = n;
		for(int i = 0;i<n;i++)
			parentOrNSize[i]=i;
	}

	
	public int getCapacity() {
		return count;
	}

	
	public void setCapacity(int n) throws IllegalArgumentException {
		int[] nuovo = new int[n];
		for(int i = 0;i<count;i++)
			nuovo[i]=parentOrNSize[i];
		count = n;
		parentOrNSize = nuovo;
	}

	
	public int find(int e) {
		if(e<0 || e>=parentOrNSize.length)throw new IllegalArgumentException();
		while(e!= parentOrNSize[e])
			e = parentOrNSize[e];
		return e;
	}

	
	public boolean union(int a, int b) {
		int i = find(a);
		int j = find(b);
		if(i==j)return false;
			parentOrNSize[i]=j;
			count--;
			return true;
	}
	public static void main(String[]agrs){
		UnionFindInt uf = new UnionFindInt(10);
		uf.union(1, 2);
		uf.union(3, 4);
		System.out.println(uf.find(1));
		uf.union(2, 4);
		System.out.println(uf.find(1));
		uf.setCapacity(15);
		System.out.println(uf.find(1));
	}
	
}
