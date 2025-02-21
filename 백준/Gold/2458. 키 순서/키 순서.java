import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static int[] in;
	public static int[] out;
	public static boolean[] visited;
	public static int n;
	public static int count;
	public static int result;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		int T = Integer.parseInt(br.readLine());
//		for(int i=1;i<=T;i++) {
		String[] tokens = br.readLine().split(" ");
			n = Integer.parseInt(tokens[0]);
			for(int j=0;j<=n;j++) {
				graph.add(new ArrayList<>());
			}
			in = new int[n+1];
			out = new int[n+1];
			visited = new boolean[n+1];
			int m = Integer.parseInt(tokens[1]);
			for(int j=0;j<m;j++) {
				String[] s = br.readLine().split(" ");
				int first = Integer.parseInt(s[0]);
				int last = Integer.parseInt(s[1]);
				graph.get(first).add(last);
			}
			for(int j=1;j<=n;j++) {
				dfs(j);
				out[j] = count-1;
				count=0;
				visited = new boolean[n+1];
			}
			for(int j=1;j<=n;j++) {
				if(in[j]+out[j]==n-1) {
					result++;
				}
			}
			System.out.println(result);
//			System.out.println("#"+i+" "+result+"\n");
//		}
	}
	public static void dfs(int start) {
		visited[start] =true;
		count++;
		for(int node : graph.get(start)) {
			if(!visited[node]) {
				in[node]++;
				dfs(node);
			}
		}
	}

}