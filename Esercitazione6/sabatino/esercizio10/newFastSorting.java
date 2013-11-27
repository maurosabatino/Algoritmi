package sabatino.esercizio10;

public class newFastSorting {
	
	/**MergeSort*/
	public static void 	MergeSortNoMergeOnSorted(int[]a){
		int n = a.length;
		int[]aux = new int[n];
		MergeSortNoMergeOnSorted(a,0,n-1,aux);
	}
	private static void 	MergeSortNoMergeOnSorted(int[]a,int fst,int lst,int[]aux){
		if(fst<lst){
			int m=(fst+lst)/2;
			MergeSortNoMergeOnSorted(a,fst,m,aux);
			MergeSortNoMergeOnSorted(a,m+1,lst,aux);
			if(a[m]>a[m+1])MergeNoMergeOnSorted(a,fst,m,lst,aux);
		}
	}
	
	private static void 	MergeNoMergeOnSorted(int[]a,int fst,int mid,int lst,int[]c){
	int i=fst,j=mid+1,k=fst;
	while(i<=mid && j<=lst){
		if(a[i]<=a[j]) c[k++]=a[i++];
		else c[k++]=a[j++];
	}
	for(int h= mid,l=lst;h>=i;) a[l--]=a[h--];
	for(int r = fst;r<k;r++) a[r]=c[r];
}
	
	
	
	/**QuickSort*/
	
	public static void QuickSortHoare(int[]array){
		if (array ==null || array.length==0)return;
		int n = array.length;
		QuickSortHoare(array,0,n-1);
	}
	public static void QuickSortHoare(int[]array,int fst,int lst){
		if(fst>=lst) return;
		int p = QuickSortHoarePartition(array,fst,lst);
		QuickSortHoare(array,fst,p);
		QuickSortHoare(array,p+1,lst);
	}
	
	public static int QuickSortHoarePartition(int[]array,int fst,int lst){
		int pivot = array[fst];
		int i=fst-1;
		int j=lst+1;
		while(i<j){
			i++;while(array[i]<pivot) i++;
			j--;while(array[j]>pivot) j--;
			if(i<j)swap(array,i,j);
		}
		return j;
	}
	
	
	/**HeapSort*/
	static void hSort(int[]a){
		trasformaInHeap(a);
		for(int i = a.length-1;i>0;i--)
		estraiMassimo(a,i);
	}
	static void estraiMassimo(int[]a, int i){
		swap(a,i,0);
		moveDown(a,0,i);
	}
	static void trasformaInHeap(int[]a){
		int n = a.length;
		for(int j = (n-2)/2;j>=0;j--)
			moveDown(a,j,n);
	}
	static void moveDown(int[] a,int i, int lun){
		int elem = a[i];
		int j;
		while((j=2*i+1)<lun){
			if(j+1<lun && a[j+1]>a[j]) j++;
			if(elem>=a[j])break;
			a[i] = a[j];
			i=j;
		}
		a[i] = elem;
	}
	
	public static void swap(int[]a,int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
