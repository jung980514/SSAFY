import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int[] max;
	public static void main(String[] args) throws IOException{
		for(int i=1;i<=10;i++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int start = Integer.parseInt(s[1]);
			visited = new boolean[101];
			graph = new ArrayList<>();
			max = new int[] {Integer.MIN_VALUE,-1};
			String[] call = br.readLine().split(" ");
			for(int j=0;j<=100;j++) {
				graph.add(new ArrayList<>());
			}
				
			for(int j=0;j<n;j+=2) {
				graph.get(Integer.parseInt(call[j])).add(Integer.parseInt(call[j+1]));
			}
			bfs(start);
			System.out.println("#"+i+" "+max[0]);
		}
	}
	public static void bfs(int start) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start,0});
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			if(max[1]<tmp[1]) {
				max[0] = tmp[0];
				max[1] = tmp[1];
			}
			else if(max[1]==tmp[1] && max[0]<tmp[0]) {
				max[0] = tmp[0];
				max[1] = tmp[1];
			}
			for(int node : graph.get(tmp[0])) {
				if(!visited[node]) {
					q.offer(new int[] {node,tmp[1]+1});
					visited[node] = true;
				}
			}
		}
	}
}
