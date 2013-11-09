package esercizio5;

public class InsertionSort implements SortingAlgorithm{	
	@Override	
	public void sort(int[] a) {
		int n=a.length;
		for(int i=1;i<n;i++){
			int x = a[i];
			int j=i;
			while(j>0 && x<a[j-1]){
				a[j] = a[j-1];
				j--;
			}
			a[j] = x;
		}
		
	}		
}
