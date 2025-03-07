import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] visited = new boolean[100001];
	public static void main(String[] args) throws IOException{
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		bfs(n,k);
	}
	public static void bfs(int n,int k) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {n,0});
		visited[n] = true;
		
		while(!q.isEmpty() && q.peek()[0] != k) {
			int[] temp = q.poll();
			
			if(temp[0]*2<=100000 && !visited[temp[0]*2]) {
				q.offer(new int[]{temp[0]*2,temp[1]+1});
				visited[temp[0]*2] = true;					
			}
			if(temp[0]-1>=0 && !visited[temp[0]-1]) {
				q.offer(new int[]{temp[0]-1,temp[1]+1});	
				visited[temp[0]-1] = true;					
			}
			if(temp[0]+1<=100000 && !visited[temp[0]+1]) {
				q.offer(new int[]{temp[0]+1,temp[1]+1});	
				visited[temp[0]+1] = true;					
			}
		}
		System.out.println(q.poll()[1]);
	}
}
