import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] in;
	static int v,e;
	public static void main(String[] args) throws IOException{
		int T = 10;
		for(int t=1;t<=T;t++) {
			sb = new StringBuilder();
			String[] s = br.readLine().split(" ");
			v = Integer.parseInt(s[0]);
			e = Integer.parseInt(s[1]);
			graph = new ArrayList<>();
			in = new int[v+1];
			for(int i=0;i<=v;i++) {
				graph.add(new ArrayList<>());
			}
			String[] s2 = br.readLine().split(" ");
			for(int i=0;i<e*2;i+=2) {
				graph.get(Integer.parseInt(s2[i])).add(Integer.parseInt(s2[i+1]));
				in[Integer.parseInt(s2[i+1])]++;
			}
			sb.append("#").append(t).append(" ");
			TopologicalSort();
			System.out.println(sb.toString());
		}
	}
	public static void TopologicalSort() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i=1;i<=v;i++) {
			if(in[i]==0)
				q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			sb.append(tmp+" ");
			for(int node : graph.get(tmp)) {
				if(--in[node]==0)
					q.offer(node);
			}
		}
	}
}
