import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] parent;
	static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if( a > b ) {
			parent[a] = b;
		}
		else {
			parent[b] = a;
		}
	}
	
	static int find(int n) {
		if(parent[n] != n)
			parent[n] = find(parent[n]);
		return parent[n];
	}
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			StringBuilder sb = new StringBuilder();
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			parent = new int[n+1];
			for(int j=1;j<=n;j++) {
				parent[j] = j;
			}
			for(int j=0;j<m;j++) {
				String[] s2 = br.readLine().split(" ");
				if(s2[0].equals("0")) {
					union(Integer.parseInt(s2[1]), Integer.parseInt(s2[2]));
				}
				else {
					if(find(Integer.parseInt(s2[1])) == find(Integer.parseInt(s2[2])))
						sb.append("1");
					else
						sb.append("0");
				}
			}
			System.out.println("#"+i+" "+sb.toString());
		}
	}
}
