package sabatino.esercizio12;

public interface UnionFind {
	int find(int e);

	int getCapacity();

	void setCapacity(int n) throws IllegalArgumentException;

	boolean union(int a, int b);
}
