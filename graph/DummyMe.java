package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
  
public class DummyMe {
	
	static class CheckPoint{
		int l,r,x,y;
		CheckPoint(int x, int y, int l, int r){
			this.l=l;this.r=r;this.x=x;this.y=y;
		}
	}
	
	static class Vertex{
		int x,y;
		Vertex(int x, int y){
			this.x=x;this.y=y;
		}
	}
	
	static List<CheckPoint> cp = new ArrayList<CheckPoint>();
	static List<List<Vertex>> allPaths;
	static boolean[][] iscp;
	static boolean[][] visited ;
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V= Integer.parseInt(sc.next());
		int K = Integer.parseInt(sc.next());;
		
		iscp = new boolean[V][V];
		allPaths = new ArrayList<>();
		for(int i=0;i<K;i++) {
			CheckPoint chec = new CheckPoint(
					Integer.parseInt(sc.next())-1,Integer.parseInt(sc.next())-1,
					Integer.parseInt(sc.next())-1,Integer.parseInt(sc.next())-1
					);
			cp.add(chec);
			iscp[chec.x][chec.y]=true;
		}
		sc.close();
		
		//Iterating over each source destination pair
		for(int i=0;i<K;i++) {
			for(int j=i+1;j<K;j++) {
				CheckPoint src = cp.get(i);
				CheckPoint dest = cp.get(j);
				visited = new boolean[V][V];
				//Check if they are same
				if(src.x!=dest.x && src.y!=dest.y) {
					int leftPoint = Math.max(src.l, dest.l);
					int rightPoint = Math.min(src.r, dest.r);
					if(leftPoint<=rightPoint) {
						
						leftVal = leftPoint;
						rightVal = rightPoint;
						findAllPaths(src,dest,visited);
						
					}
				}
			}
		}
		System.out.println("DONE.........");
		
	}
	
	public static void findAllPaths(CheckPoint src, CheckPoint dest,boolean[][] visited) {
		ArrayList<Vertex> path = new ArrayList<>();
		findUtil(src.x,src.y,dest.x,dest.y,path,visited);
	}
	
	
	static int leftVal;
	static int rightVal;
	
	
	public static void findUtil(int x, int y,int destX,int destY,ArrayList<Vertex> path,boolean[][] visited) {
		
		if(x==destX && y==destY) {
			path.add(new Vertex(x,y));
			//if(path.size()<= rightVal && path.size()>=leftVal) {
				printPath(path);
			//System.out.println("Length"+path.size()+" Left: "+leftVal+" Right: "+rightVal );
			allPaths.add(path);
			//}
			return ;
		}
		
		Vertex tempVertex = new Vertex(x,y);
		path.add(tempVertex);
		visited[x][y] = true;
		
		//System.out.print("U ");
		if(x-1>=0 && !visited[x-1][y] && !isCheckPoint(x-1,y,destX, destY) ) {
			findUtil(x-1,y,destX,destY,path,visited); //{return true;}
		}
		//System.out.print("D ");
		if(x+1<visited.length && !visited[x+1][y] && !isCheckPoint(x+1,y,destX, destY) ){
			findUtil(x+1,y,destX,destY,path,visited);//) {return true;}
		}
		//System.out.print("L ");
		if(y-1>=0 && !visited[x][y-1] && !isCheckPoint(x,y-1,destX, destY)) {
			findUtil(x,y-1,destX,destY,path,visited);//) {return true;}
		}
		//System.out.print("R ");
		if(y+1<visited.length && !visited[x][y+1] && !isCheckPoint(x,y+1,destX, destY)) {
			findUtil(x,y+1,destX,destY,path,visited);//) {return true;}
		}
		//path.remove(tempVertex);
		//visited[x][y]=false;
		//return ;
	}
	
	public static void printPath(List<Vertex> paths) {
		Iterator<Vertex> itr = paths.listIterator();
		while(itr.hasNext()) {
			Vertex vtemp = itr.next();
			System.out.print("("+(vtemp.x+1)+","+(vtemp.y+1)+")");
		}
		System.out.println();
	}
	
	public static boolean isCheckPoint(int a,int b,int destX,int destY) {
		if(a==destX && b==destY) {return false;}
		return iscp[a][b];
	}

}
