import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] output;
	static int[] list;
	static HashSet<String> select;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int r = Integer.parseInt(s[1]);
		String[] s2 = br.readLine().split(" ");
		list = new int[n];
		for(int i=0;i<n;i++) {
			list[i] = Integer.parseInt(s2[i]);
		}
		Arrays.sort(list);
		output = new int[r];
		visited = new boolean[n];
		select = new HashSet<>();
		Permutation(0,n,r);
		System.out.println(sb.toString());
	}
	public static void Permutation(int depth,int n,int r) {
		if(depth==r) {
			StringBuilder temp = new StringBuilder();
            for (int num : output) {
                temp.append(num).append(" ");
            }
            String result = temp.toString().trim();
            
            if(!select.contains(result)) {
            	select.add(result);
            	sb.append(result).append("\n");
            }
			return;
		}
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				output[depth] = list[i];
				visited[i] = true;
				Permutation(depth+1,n,r);
				visited[i] = false;
			}
		}
	}
}