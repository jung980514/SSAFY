import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] population;
	static ArrayList<Integer>[] graph;
	static int min = Integer.MAX_VALUE;
	static int n;
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		String[] pop = br.readLine().split(" ");
		population = new int[n];
		for(int i=0;i<n;i++) {
			population[i] = Integer.parseInt(pop[i]);
		}
		graph = new ArrayList[n];
		for(int i=0;i<n;i++) 
			graph[i]=new ArrayList<>();
		for(int i=0;i<n;i++) {
			String[] s2 = br.readLine().split(" ");
			int cnt = Integer.parseInt(s2[0]);
			for(int j=0;j<cnt;j++) {
				graph[i].add(Integer.parseInt(s2[j+1])-1);
			}
		}
		for(int i=1;i<=n/2;i++) {
			Comb(new boolean[n],n,i,0,0);
		}
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	public static void Comb(boolean[] selected, int n, int r, int cnt, int idx) {
		if(cnt==r) {
			ArrayList<Integer> A = new ArrayList<>();
			ArrayList<Integer> B = new ArrayList<>();
			for(int i=0;i<n;i++) {
				if(selected[i])A.add(i);
				else B.add(i);
			}
			if(isConnected(A) && isConnected(B)) {
				int popA=0;
				int popB=0;
				for(int a : A) {
					popA += population[a];
				}
				for(int b : B) {
					popB += population[b];
				}
				min = Math.min(min, Math.abs(popA-popB));
			}
			return;
		}
		if(idx==n) return;
		
		selected[idx]=true;
		Comb(selected,n,r,cnt+1,idx+1);
		selected[idx]=false;
		Comb(selected,n,r,cnt,idx+1);
		
	}
	public static boolean isConnected(ArrayList<Integer> lis) {
		if(lis.isEmpty()) return false;
		boolean[] visited = new boolean[n];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(lis.get(0));
		visited[lis.get(0)]=true;
		
		int count=1;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int node : graph[tmp]) {
				if(lis.contains(node) && !visited[node]) {
					q.offer(node);
					count++;
					visited[node] = true;
				}
			}
		}
		return count==lis.size();
		
	}
}
