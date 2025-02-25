import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] table;
	static boolean[] isSelected;
	static int result;
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			int n = Integer.parseInt(br.readLine());
			table = new int[n+1][n+1];
			for(int j=1;j<=n;j++) {
				String[] s = br.readLine().split(" ");
				for(int k=1;k<=n;k++) {
					table[j][k] = Integer.parseInt(s[k-1]);
				}
			}
			isSelected = new boolean[n];
			result = Integer.MAX_VALUE;
			Combination(0,0,n,n/2);
			System.out.println("#"+i+" "+result);
		}
	}
	public static void Combination(int depth,int start,int n,int r) {
		if(depth == r) {
			int A = 0;
			int B = 0;
			ArrayList<Integer> listA= new ArrayList<>();
			ArrayList<Integer> listB= new ArrayList<>();
			for(int i=0;i<isSelected.length;i++) {
				if(isSelected[i]) {
					listA.add(i+1);
				}
				else {
					listB.add(i+1);
				}
			}
			for(int i : listA) {
				for(int j : listA) {
					A+=table[i][j];
				}
			}
			for(int i : listB) {
				for(int j : listB) {
					B+=table[i][j];
				}
			}
			result = Math.min(result, Math.abs(A-B));
			return;
		}
		for(int i=start;i<n;i++) {
			isSelected[i] = true;
			Combination(depth+1, i+1, n, r);
			isSelected[i] = false;
		}
	}
}