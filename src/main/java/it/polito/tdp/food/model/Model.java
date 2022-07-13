package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	
	private FoodDao dao;
	private Graph<String, DefaultWeightedEdge> grafo;
	private double min;
	
	public Model() {
		this.dao= new FoodDao();
	}
	public List<String> getVertcici(int p){
		return dao.getCibi(p);
	}
	
	public String creaGrafo(int p) {
		
		this.grafo= new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		//aggiungo vertici
		Graphs.addAllVertices(this.grafo, dao.getCibi(p));
		
		//aggiungo archi
		for(Adiacenza a1:dao.getAdiacenze()) {
			for(Adiacenza a2:dao.getAdiacenze()) {
				if(!a1.equals(a2)) {
					if(this.grafo.vertexSet().contains(a1.getV()) && this.grafo.vertexSet().contains(a2.getV())){
						if(a1.getPeso()>a2.getPeso()) {
							Graphs.addEdgeWithVertices(this.grafo, a1.getV(), a2.getV(), (a1.getPeso()-a2.getPeso()));
						} else if(a1.getPeso()<=a1.getPeso()) {
							Graphs.addEdgeWithVertices(this.grafo, a2.getV(), a1.getV(), (a2.getPeso()-a1.getPeso()));
						}
				}
			}
			
				
			}
		}
		return String.format("Grafo creato (%d vertici, %d archi)\n", 
				this.grafo.vertexSet().size(), this.grafo.edgeSet().size());
	
	}
	public List<Adiacenza> getSuccessori(String c){
		this.min=99999.9;
		
		List<Adiacenza> result=new ArrayList<>();
		List<String> vicini=Graphs.successorListOf(this.grafo, c);
		for(String a:vicini) {
			double peso=this.grafo.getEdgeWeight(this.grafo.getEdge(c, a));
			if (peso<min) {
				min=peso;
				result.add(new Adiacenza(a,peso));
				}
			Collections.sort(result);
		}
		
		
		return result;
		
	}
	
}
