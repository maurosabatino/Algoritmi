package sabatino.testVari;

public class Test {
	
	public static void main(String[]args){
		Cronometro c = new Cronometro();
		int[] array = RandomArrays.randomIntArray(2000000);
		c.start();
		QuickSortMidToExamine(array);
		c.stop();
		System.out.println("lunghezza: "+array.length+" tempo: "+c.getElapsedTime()+" ordinato: "+ordinato(array,array.length));
	}
	
	
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
	
	
	

	public static void QuickSortMidToExamine(int[]a){
		if (a ==null || a.length==0)
      return;
		int n = a.length;
		QuickSortMidToExamine(a,0,n-1);
	}
	private static void QuickSortMidToExamine(int[]a,int inf, int sup){
		if(inf>=sup) return;
		int p = QuickSortMidToExaminePartition(a,inf,sup);
		QuickSortMidToExamine(a,inf,p-1);
		QuickSortMidToExamine(a,p+1,sup);
	}
	private static int QuickSortMidToExaminePartition(int[]a,int inf, int sup){
		int pivot = a[inf];
		int i = inf+1;
		int j = sup;
		while(i<=j){
			if(a[i]<pivot)	i++;
			else swap(a,i,j--);
		}
		swap(a,inf,j);
		return j ;	
	}
	
	static boolean ordinato(int a[],int n) {
  	for(int i = 1; i < n-1; i++) if(a[i-1] > a[i]) return false;
	return true;
  }
	
	
	public static void swap(int[]a,int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
