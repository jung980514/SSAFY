import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] parent;
	static int[][] graph;
	static long cost;
	static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if(a>b)
			parent[a] = b;
		else
			parent[b] = a;
	}
	static int find(int x) {
		if(parent[x] != x)
			return parent[x] = find(parent[x]);
		return parent[x];
	}
	static void kruskal() {
		for(int i=0;i<graph.length;i++) {
			if(find(graph[i][0]) != find(graph[i][1])) {
				cost += graph[i][2];
				union(graph[i][0],graph[i][1]);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			String[] s = br.readLine().split(" ");
			int v = Integer.parseInt(s[0]);
			int e = Integer.parseInt(s[1]);
			parent = new int[v+1];
			for(int j=1;j<=v;j++) {
				parent[j] = j;
			}
			graph = new int[e][3];
			for(int j=0;j<e;j++) {
				String[] s2 = br.readLine().split(" ");
				graph[j][0] = Integer.parseInt(s2[0]);
				graph[j][1] = Integer.parseInt(s2[1]);
				graph[j][2] = Integer.parseInt(s2[2]);
			}
			Arrays.sort(graph,(a,b)->a[2]-b[2]);
			cost = 0;
			kruskal();
			System.out.println("#"+i+" "+cost);
		}
	}
}
