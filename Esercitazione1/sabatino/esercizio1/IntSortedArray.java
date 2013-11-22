package sabatino.esercizio1;


public class IntSortedArray {
	private int[]elements ;
	private int numElements;
	public IntSortedArray(int initialCapacity){
		elements = new int[initialCapacity];
		numElements=0;
	}
	
	public int size(){
		return numElements;
	}
	
	public int binarySearch(int x){
		int inf = 0;
		int sup = numElements-1;
		if(sup==-1 || x<elements[0]) return -1;
		if(x>elements[sup]) return -(numElements+1);
		while(inf<=sup){
			int i = (inf+sup)>>>1;
			if(x<elements[i]) sup = i-1;
			else if(x>elements[i]) inf=i+1;
			else return i;
		}
		return -(inf+1);
	}
	
	/*-----------------insert-------------------------*/
	public int insert(int x){
		int result=binarySearch(x);
		int inf =-(result+1);
		if(inf>=0){
			if(numElements==elements.length){
				reAlloc();
			}
		shiftRight(inf);
		elements[inf]=x;
		numElements=numElements+1;
		return inf;
		}else return -1;
	}
	
	
	public void shiftRight(int inf){
		for(int j=numElements-1;j>inf-1;j--){
			elements[j+1]=elements[j];
		}
	}
	
	public void reAlloc(){
	int[] copia = new int[numElements*2];
	for(int i=0;i<elements.length;i++){
		copia[i] = elements[i];
	}	
	elements=copia;
	}
	
	/*-------insert--------------------------------------*/
	
	public int get(int i){
		return elements[i];
	}
	public void print(){
		for(int i=0;i<numElements;i++){
			System.out.print(elements[i]+",");
		}
	}
}
