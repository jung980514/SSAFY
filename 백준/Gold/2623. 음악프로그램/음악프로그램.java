import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] in;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<>());
		}
		in = new int[n+1];
		visited = new boolean[n+1];
		for(int i=0;i<m;i++) {
			String[] s2 = br.readLine().split(" ");
			for(int j=1;j<Integer.parseInt(s2[0]);j++) {
				graph.get(Integer.parseInt(s2[j])).add(Integer.parseInt(s2[j+1]));
				in[Integer.parseInt(s2[j+1])]++;
			}
		}
		int count=0;
		//Topological Sorting
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i=1;i<=n;i++) {
			//진입 차수 0인 노드 큐에 저장
			if(in[i]==0) {
				q.offer(i);	
				visited[i] =true;
			}
		}
		while(!q.isEmpty()) {
			int temp = q.poll();
			sb.append(temp+"\n");
			count++;
			//해당 노드와 연결된 간선 제거(연결된 노드 진입차수 -1)
			for(int node : graph.get(temp)) {
				in[node]--;
			}
			//진입차수가 0이고 방문하지않은 노드 큐에 저장
			for(int i=1;i<=n;i++) {
				if(in[i]==0 && !visited[i]) {
					q.offer(i);	
					visited[i] = true;
				}
			}
		}
		if(count==n) System.out.print(sb.toString());
		else System.out.println(0);
		
	}
}
