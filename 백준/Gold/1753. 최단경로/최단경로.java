import java.io.*;
import java.util.*;

public class Main {
	public static class Node{
		int index;
		int cost;
		
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		
	}
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	public static boolean[] visited;
	public static int[] dist;
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int v = Integer.parseInt(s[0]);
		int e = Integer.parseInt(s[1]);
		int start = Integer.parseInt(br.readLine());
		for(int i=0;i<v+1;i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[v+1];
		dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=1;i<e+1;i++) {
			String[] uvw = br.readLine().split(" ");
			graph.get(Integer.parseInt(uvw[0]))
				.add(new Node(Integer.parseInt(uvw[1]),Integer.parseInt(uvw[2])));
		}
		Dijkstra(v,start);
		for(int i=1;i<v+1;i++) {
			if(dist[i]==Integer.MAX_VALUE) sb.append("INF\n");
			else	sb.append(dist[i]+"\n");
		}
		System.out.println(sb.toString());
	}
	public static void Dijkstra(int v,int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->(a.cost-b.cost));
		pq.offer(new Node(start,0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			int node = pq.poll().index;
			if(visited[node]) continue;
			visited[node] = true;
			
			for(Node n : graph.get(node)) {
				if(!visited[n.index] && dist[n.index]>dist[node]+n.cost) {
					dist[n.index] = dist[node]+n.cost;
					pq.offer(new Node(n.index,dist[n.index]));
				}
			}
		}
	}
}