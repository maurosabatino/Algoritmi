package sabatino.esercizio14;

public class Arco<V,E>{
	E info;
	V in;
	V fin;
	double weight;
	public Arco(E info,V in, V fin){
		this.info = info;
		this.in = in;
		this.fin = fin;
	}
	public Arco(E info,V in, V fin,double weight){
		this.info = info;
		this.in = in;
		this.fin = fin;
		this.weight = weight;
	}
}