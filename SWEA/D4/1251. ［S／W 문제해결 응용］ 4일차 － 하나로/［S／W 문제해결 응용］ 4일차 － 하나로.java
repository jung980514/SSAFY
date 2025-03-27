import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] parent;
	static double[][] islands;
	static double e;
	static double cost;
	static PriorityQueue<Edge> graph;
	static class Edge{
		int x;
		int y;
		double cost;
		
		public Edge(int x, int y, double cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	
	static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if(a>b) parent[a] = b;
		else parent[b] = a;
	}
	
	static int find(int x) {
		if(parent[x] != x)
			return parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void kruskal() {
		while(!graph.isEmpty()) {
			Edge edge = graph.poll();
			if(find(edge.x) != find(edge.y)) {
				cost += e * Math.pow(edge.cost,2);
				union(edge.x,edge.y);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			int n = Integer.parseInt(br.readLine());
			parent = new int[n+1];
			islands = new double[n][2];
			for(int j=1;j<=n;j++) {
				parent[j] = j;
			}
			String[] x = br.readLine().split(" ");
			String[] y = br.readLine().split(" ");
			e = Double.parseDouble(br.readLine());
			for(int j=0;j<n;j++) {
				islands[j][0] = Integer.parseInt(x[j]);
				islands[j][1] = Integer.parseInt(y[j]);
			}
			graph = new PriorityQueue<>((a,b)->Double.compare(a.cost, b.cost));
			for(int j=0;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					double dist = Math.sqrt(Math.pow(islands[j][0]-islands[k][0],2)+ Math.pow(islands[j][1]-islands[k][1],2));
					graph.add(new Edge(j+1,k+1,dist));
				}
			}
			cost = 0;
			kruskal();
			System.out.println("#"+i+" "+Math.round(cost));
		}
	}
}
