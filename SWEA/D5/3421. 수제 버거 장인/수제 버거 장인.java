import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] constraint;
	static int N;
	static int M;
	static int count;
	static boolean[] isConnected;
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			String[] s1 = br.readLine().split(" ");
			N = Integer.parseInt(s1[0]);
			M = Integer.parseInt(s1[1]);
			constraint = new int[M+1][2];
			for(int j=1;j<=M;j++) {
				String[] s2 = br.readLine().split(" ");
				constraint[j][0] = Integer.parseInt(s2[0]);
				constraint[j][1] = Integer.parseInt(s2[1]);				
			}
			isConnected = new boolean[N+1];
			count = 0;
			Subset(1);
			sb.append("#"+i+" "+count+"\n");
		}
		System.out.print(sb.toString());
	}
	public static void Subset(int cnt) {
		for(int i=1;i<=M;i++) {
			if(isConnected[constraint[i][0]] && isConnected[constraint[i][1]])
				return;
		}
		if(cnt==N+1) {
			count++;
			return;
		}
		
		isConnected[cnt] = true;
		Subset(cnt+1);
		isConnected[cnt] = false;
		Subset(cnt+1);		
	}
}