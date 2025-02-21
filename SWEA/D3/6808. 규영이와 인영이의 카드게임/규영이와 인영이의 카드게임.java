import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int win=0;
	static int lose=0;
	static int[] output;
	static boolean[] visited;
	static int[] inCards = new int[9];
	static int[] gyuCards = new int[9];
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			win=0;
			lose=0;
			boolean[] arr = new boolean[19];
			String[] gyuCard = br.readLine().split(" ");
			for(int j=0;j<9;j++) {
				gyuCards[j] = Integer.parseInt(gyuCard[j]);
			}
			for(int j=0;j<9;j++) {
				arr[gyuCards[j]-1] = true;
			}
			int idx=0;
			for(int j=0;j<18;j++) {
				if(!arr[j])
					inCards[idx++] = j+1;
			}
			output = new int[9];
			visited = new boolean[9];
			Permutation(0,9,9);
			System.out.println("#"+i+" "+win+" "+lose);
		}
	}
	public static void Permutation(int depth,int n, int r) {
		if(depth==r) {
			int inyoung=0;
			int gyuyoung=0;
			for(int i=0;i<9;i++) {
				if(gyuCards[i] > output[i]) {
					gyuyoung += gyuCards[i]+output[i];
				}
				else {
					inyoung += gyuCards[i]+output[i];
				}
			}
			if(inyoung>gyuyoung) lose++;
			if(inyoung<gyuyoung) win++;
		}
		for(int i=0;i<9;i++) {
			if(!visited[i]) {
				visited[i]= true;
				output[depth] = inCards[i];
				Permutation(depth+1,n,r);
				visited[i]=false;
			}
		}
	}
}