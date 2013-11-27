package sabatino.esercizio9;

public class HeapSort {
	
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
