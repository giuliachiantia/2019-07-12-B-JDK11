package it.polito.tdp.food.model;

public class Adiacenza implements Comparable <Adiacenza> {
	
	String v;
	Double peso;
	public Adiacenza(String v, Double peso) {
		super();
		this.v = v;
		this.peso = peso;
	}
	public String getV() {
		return v;
	}
	public void setV1(String v) {
		this.v = v;
	}
	
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	@Override
	public int compareTo(Adiacenza o) {
		// TODO Auto-generated method stub
		return this.peso.compareTo(o.getPeso());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((v == null) ? 0 : v.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adiacenza other = (Adiacenza) obj;
		if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "v=" + v + ", peso=" + peso ;
	}
	

}
