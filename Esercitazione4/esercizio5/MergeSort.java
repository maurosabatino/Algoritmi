package esercizio5;

public class MergeSort implements SortingAlgorithm{

	@Override
	public void sort(int[] a) {
		int n = a.length;
		int [] aux = new int[n];
		msort(a,0,n-1,aux);
		
	}
	private static void msort(int[]a,int first,int last,int[]b){
		if(first<last){
			int m =(first+last)/2;
			msort(a,first,m,b);
			msort(a,m+1,last,b);
			merge(a,first,m,last,b);
		}
	}
	private static void merge(int[]a,int fst,int mid,int lst,int[]c){
		int i=fst,j=mid+1,k=fst;
		while(i<=mid && j<=lst){
			if(a[i]<=a[j]) c[k++]=a[i++];
			else c[k++]=a[j++];
		}
		for(int h= mid,l=lst;h>=i;) a[l--]=a[h--];
		for(int r = fst;r<k;r++) a[r]=c[r];
	}

}
