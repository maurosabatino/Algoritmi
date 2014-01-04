package sabatino.esercizio14.NoGeneric;

public class Arco{
	String info;
	int in;
	int fin;
	double weight;
	public Arco(String info,int in, int fin){
		this.info = info;
		this.in = in;
		this.fin = fin;
	}
	public Arco(String info,int in, int fin,double weight){
		this.info = info;
		this.in = in;
		this.fin = fin;
		this.weight = weight;
	}
}