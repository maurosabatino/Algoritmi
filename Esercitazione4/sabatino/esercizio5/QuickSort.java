package sabatino.esercizio5;

import java.util.Random;

public class QuickSort implements SortingAlgorithm{
	
	Random generatore = new Random();
		
	@Override
	public void sort(int[] a){
		if (a ==null || a.length==0)
      return;
		int n = a.length;
		qsort(a,0,n-1);	
	}
	/**
	 * questa è la versione del libro con il pivot al fondo
	 * */
	private void qsort(int[]a, int inf, int sup){
		if(inf<sup){
			int iPivot = inf+generatore.nextInt(sup-inf+1);
			scambia(a,sup,iPivot);
			int p = a[sup];
			int i = inf;
			int j = sup-1;
			while(i<=j){
				while(i<=j && a[i]<=p) i++;
				while(i<=j && a[j]>=p) j--;
				if(i<j)scambia(a,i,j);
			}
			scambia(a,i,sup);
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

 