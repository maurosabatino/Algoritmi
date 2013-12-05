package sabatino.esercizio11;

public class IntrospectiveSort {
	
	public static void introSort(int[]a){
		int n = a.length;
		int log = 31 - Integer.numberOfLeadingZeros(n);
		qhs(a,0,n-1,2*log);
	}
	
	static void qhs(int[]a,int fst, int lst, int lev){
		//if(lst-fst< SOGLIA) isortAux(a,fst,lst);
		if(lev == 0){
			System.out.println("uso l'heapsort");
			hsortAux(a,fst,lst);
		}
		else{
			if(fst>=lst) return;
			int p = QuickSortHoarePartition(a,fst,lst);
			qhs(a,fst,p,lev);
			qhs(a,p+1,lst,lev);
		}
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
	
	static void hsortAux(int[]a,int fst,int lst){
		for(int j=(fst+lst-1)/2;j>=fst;j--)
			moveDownAux(a,fst,j,lst);
		for(int i = lst; i>fst; i--){
			swap(a,fst,i);
			moveDownAux(a,fst,i,lst);
		}
	}
	static void moveDownAux(int[]a, int fst, int i,int lst){
		int elem = a[i];
		int j=fst;
		while((j=2*i+1)<lst){
			if(j+1<lst && a[j+1]>a[j]) j++;
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
