package graph;

public class Graph {
	
	//No of vertices
	int v;
	int[][] edgeWeights;
	
	boolean isDirected;
	
	Graph(int v, boolean isDir){
		this.v=v;
		this.edgeWeights = new int[v][v];
		this.isDirected = isDir;
	}
	
	//Using adjacency matrix representation
	public void addEdge(int src, int dest, int weight) {
		this.edgeWeights[src][dest]=weight;
	}
	
	public int[][] getEdgeWeights(){
		return this.edgeWeights;
	}
	
	public void initEdgeWeights(int k) {
		for(int i=0;i<this.v;i++) {
			for(int j=0;j<this.v;j++) {
				if(i==j) {
					this.edgeWeights[i][i]=0;
				}else {
					this.edgeWeights[i][j]=k;
				}
			}
		}
	}
}
