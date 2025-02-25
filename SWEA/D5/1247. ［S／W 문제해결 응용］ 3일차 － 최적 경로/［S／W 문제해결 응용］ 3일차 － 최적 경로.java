import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<int[]> clients;
	static boolean[] visited;
	static int n;
	static int[] output;
	static int result;
	static int startX;
	static int startY;
	static int endX;
	static int endY;
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			clients = new ArrayList<>();
			n = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			startX = Integer.parseInt(s[0]);
			startY = Integer.parseInt(s[1]);
			endX = Integer.parseInt(s[2]);
			endY = Integer.parseInt(s[3]);		
			clients.add(new int[2]);
			for(int j=4;j<2*n+4;j+=2) {
				int x = Integer.parseInt(s[j]);
				int y = Integer.parseInt(s[j+1]);
				clients.add(new int[] {x,y});
			}
			visited = new boolean[n];
			output = new int[n];
			result = Integer.MAX_VALUE;
			
			Permutation(0,n,n);
			System.out.println("#"+i+" "+result);
		}
	}
	public static void Permutation(int depth,int n,int r) {
		if(depth == r) {
			int dist = 0;
			for(int i=0;i<n;i++) {
				if(i==0) {
					dist += Math.abs(clients.get(output[i])[0]-startX) + Math.abs(clients.get(output[i])[1]-startY);
				}
				if(i<n-1) {
					dist += Math.abs(clients.get(output[i])[0]-clients.get(output[i+1])[0]) + Math.abs(clients.get(output[i])[1]-clients.get(output[i+1])[1]);
				}
				if(i==n-1) {
					dist += Math.abs(clients.get(output[i])[0]-endX) + Math.abs(clients.get(output[i])[1]-endY);
				}
			}
			result = Math.min(result, dist);
			return;
		}
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				output[depth] = i+1;
				visited[i] = true;
				Permutation(depth+1,n,r);				
				visited[i] = false;
			}
		}
	}
}