package graph;

public class AllPairsShortestPath_FloydWarshall {

	public static void main(String[] args) {
		Graph g = new Graph(4,true);
		g.initEdgeWeights(Integer.MAX_VALUE);
		g.addEdge(0, 1, 5);
		g.addEdge(0, 3, 10);
		g.addEdge(1, 2, 3);
		g.addEdge(2, 3, 1);
		
		//Find all pairs shortest path
		floydWarshall(g);
	}
	
	
	/*
	 * Ref: https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
	 * Floyd warshall algo doesn't work for negative cycles
	 * Detect negative cycles when a path with same src & dest
	 * has negative weights & improves
	 */
	public static void floydWarshall(Graph g) {
		int n = g.v;
		int[][] dist=g.edgeWeights;
		//Choosing each vertex 'k' as intermediate vertex
		for(int k=0;k<n;k++) {
			//Choosing each vertex 'i' as src
			for(int i=0;i<n;i++) {
				//Choosing each vertex 'j' as dest
				for(int j=0;j<n;j++) {
					/*Path goes through vertex k = dist[i][k]+dist[k][j]
					  Path doesn't go through vertex k = path considering vertices
					  till k-1 th vertex (which we update already since for loop 
					  starts from 0 and ended till k-1) = dist[i][j]*/
					if(dist[i][j] > dist[i][k]+dist[k][j]) {
						dist[i][j] = dist[i][k]+dist[k][j];
					}
				}
			}
		}
		
		if(checkForNegativeCycles(dist)) {
			System.out.println("This grah contains negative cycles..Hence Floyd Warshall algo doesnt work!!!");
		}else {
			printArr(dist);
		}
	}
	
	public static boolean checkForNegativeCycles(int[][] dist) {
		for(int i=0;i<dist.length;i++) {
			if(dist[i][i]<0) {
				return true;
			}
		}
		return false;
	}
	
	public static void printArr(int[][] a) {
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				if(a[i][j]==Integer.MAX_VALUE) {
					System.out.print("MAX:");
				}else {
					System.out.print(a[i][j]+":");
				}
			}
			System.out.println();
		} 
	}

}
