import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] parent;
	static void union(int x, int y) {
		int a = find(x);
		int b = find(y);

		if(a>b) {
			parent[a] = b;
		}
		else
			parent[b] = a;
	}
	static int find(int x) {
		if(parent[x]== x) return x;

		return parent[x] = find(parent[x]);
	}
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			parent = new int[n+1];
			for(int j=1;j<=n;j++)
				parent[j] = j;
			for(int j=0;j<m;j++) {
				String[] relation = br.readLine().split(" ");
				int x = Integer.parseInt(relation[0]);
				int y = Integer.parseInt(relation[1]);
				union(x,y);
			}
			HashSet<Integer> set = new HashSet<>();
			for(int j=1;j<=n;j++) {
				set.add(find(j));
			}
			System.out.println("#"+i+" "+set.size());
		}
	}
}
