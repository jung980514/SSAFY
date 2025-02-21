import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int[] arr;
	public static int[] output;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException{
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		arr = new int[n];
		output = new int[m];
		visited = new boolean[n];
		for(int i=1;i<n+1;i++) {
			arr[i-1] = i;
		}
//		System.out.println("순열");
		Permutation(0,n,m);
//		System.out.println("중복순열");
//		RepeatedPermutation(0, n, m);
//		System.out.println("조합");
//		Combination(0, 0, n, m);
//		System.out.println("중복 조합");
//		RepeatedCombination(0, 0, n, m);
	}
	public static void Permutation(int depth,int n,int r) {
		if(depth == r) {
			for(int result : output) {
				System.out.print(result+ " ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				Permutation(depth+1,n,r);
				visited[i] = false;
			}
		}
	}
	public static void RepeatedPermutation(int depth,int n,int r) {
		if(depth == r) {
			for(int result : output) {
				System.out.print(result+ " ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<n;i++) {
			output[depth] = arr[i];
			RepeatedPermutation(depth+1, n, r);
		}
	}
	public static void Combination(int start,int depth,int n,int r) {
		if(depth==r) {
			for(int result : output) {
				System.out.print(result+ " ");
			}
			System.out.println();
			return;
		}
		for(int i=start;i<n;i++) {
			output[depth] = arr[i];
			Combination(i+1, depth+1, n, r);
		}
	}
	
	public static void RepeatedCombination(int start,int depth,int n,int r) {
		if(depth==r) {
			for(int result : output) {
				System.out.print(result+ " ");
			}
			System.out.println();
			return;
		}
		for(int i=start;i<n;i++) {
			output[depth] = arr[i];
			RepeatedCombination(start, depth+1, n, r);
		}
	}
}