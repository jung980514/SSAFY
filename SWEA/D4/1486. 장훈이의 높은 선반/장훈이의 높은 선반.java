import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int result;
	static int[] top;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			String[] s1 = br.readLine().split(" ");
			int n = Integer.parseInt(s1[0]);
			int b = Integer.parseInt(s1[1]);
			String[] s2 = br.readLine().split(" ");
			top = new int[n];
			for(int j=0;j<n;j++) {
				top[j] = Integer.parseInt(s2[j]);
			}
			result = Integer.MAX_VALUE;
			getHeight(0,n,b,0);
			System.out.println("#"+i+" "+result);
		}
	}
	public static void getHeight(int cnt,int n,int b,int height) {
		if(cnt==n) {
			if(height>=b)
				result = Math.min(result, height-b);
			return;
		}
		
		getHeight(cnt+1,n,b,height+top[cnt]);
		getHeight(cnt+1,n,b,height);		
	}
}