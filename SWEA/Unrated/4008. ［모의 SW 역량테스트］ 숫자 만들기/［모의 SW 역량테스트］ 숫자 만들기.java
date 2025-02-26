import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	static int[] operator;
	static int[] operand;
	static ArrayList<Integer> realOperator;
	static boolean[] visited;
	static int maxResult;
	static int minResult;
	static int[] output;
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			int n = Integer.parseInt(br.readLine());
			String[] s1 = br.readLine().split(" ");
			operator = new int[4];
			operand = new int[n];
			realOperator = new ArrayList<>();
			for(int j=0;j<4;j++) {
				operator[j] = Integer.parseInt(s1[j]);
			}
			for(int j=0;j<4;j++) {
				int k = operator[j];
				if(k>0) {
					realOperator.add(j);
				}
			}
			String[] s2 = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				operand[j] = Integer.parseInt(s2[j]);
			}
			visited = new boolean[n];
			maxResult = Integer.MIN_VALUE;
			minResult = Integer.MAX_VALUE;
			output = new int[n-1];
			RepeatedPermutation(0,n-1,n-1,operand[0]);
			System.out.println("#"+i+" "+(maxResult-minResult));
		}
	}
	public static void RepeatedPermutation(int depth,int n,int r,int cal) {
		if(depth == r) {
			maxResult = Math.max(maxResult, cal);
			minResult = Math.min(minResult, cal);
	
			return;
		}
		for(int i=0;i<realOperator.size();i++) {
			if(operator[realOperator.get(i)]>0) {
				output[depth] = realOperator.get(i);
				operator[realOperator.get(i)]--;
				if(realOperator.get(i)==0) 
					RepeatedPermutation(depth+1,n,r,cal+operand[depth+1]);
				else if(realOperator.get(i)==1) 
					RepeatedPermutation(depth+1,n,r,cal-operand[depth+1]);					
				else if(realOperator.get(i)==2) 
					RepeatedPermutation(depth+1,n,r,cal*operand[depth+1]);					
				else if(realOperator.get(i)==3) 
					RepeatedPermutation(depth+1,n,r,cal/operand[depth+1]);	
				operator[realOperator.get(i)]++;
			}
		}
	}
}