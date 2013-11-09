package esercizio5;

import java.util.Random;

public class QuickSort implements SortingAlgorithm{
	Random generatore = new Random();
	@Override
	public void sort(int[] a) {
		int n = a.length;
		qsort(a,0,n-1);	
	}
	private void qsort(int[]a, int inf, int sup){
			int pivot = a[inf];
			scambia(a,sup,pivot);
			int p=a[sup];
			int i = inf;
			int j=sup-1;
			while(i<=j){	
				while(i<=j && a[j]>=p) i++;
				while(i<=j && a[j] >=p) j--;
				if(i<j) scambia (a,i,j);
			}
			scambia(a,i,sup);		
			if (inf <sup) {;
			qsort(a,inf,i-1);	
			qsort(a,i+1,sup);
			}
	}
	private void scambia(int[]a,int i,int j){
		int x=a[i];
		a[i]=a[j];
		a[j]=x;
	}
	
	
}

