import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			int[][] map = new int[n][n];
			int max=0;
			for(int j=0;j<n;j++) {
				String[] arr = br.readLine().split(" ");
				for(int k=0;k<n;k++) {
					map[j][k] = Integer.parseInt(arr[k]);
				}
			}
			for(int a=0;a<n-m+1;a++) {
				for(int b=0;b<n-m+1;b++) {
					int fly = 0;
					for(int j=a;j<a+m;j++) {
						for(int k=b;k<b+m;k++) {
							fly +=map[j][k];
						}
					}
					if(max<fly) max=fly;
				}
			}
			System.out.println("#"+i+" "+max);
		}
	}
}