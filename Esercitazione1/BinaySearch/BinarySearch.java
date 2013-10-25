package BinaySearch;

public class BinarySearch {
	
	public static int find(int x, int[]a){
		int inf = 0;
		int sup = a.length-1;
		while(inf<=sup){
			int i = (inf+sup)/2;
			if(x<a[i])sup=i-1;
			else if(x>a[i])inf=i+1;
			else return i;
		}
		return -1;	
	}
		
	public static boolean isPresent(int x, int[]a){
		int inf = 0;
		int sup = a.length-1;
		while(inf<=sup){
			int i = (inf+sup)/2;
			if(x<a[i])sup=i-1;
			else if(x>a[i])inf=i+1;
			else return true;
		}
		return false;
	}
		
	public static int findRecursively(int x, int[]a){
		return findRecursively(x,a,0,a.length-1);
	}
	static int findRecursively(int x, int[]a, int inf, int sup){
		if(inf<=sup){
			int i = (inf+sup)/2;
			if(x<a[i])return findRecursively(x,a,inf,i-1);
			else if(x>a[i])return  findRecursively(x,a,i+1,sup);
			else return i;
		}
		return -1;
	}
}
