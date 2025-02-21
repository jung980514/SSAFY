import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] hamburger;
	static int n;
	static int limit;
	static int result;
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			limit = Integer.parseInt(s[1]);
			hamburger = new int[n+1][2];
			for(int j=1;j<n+1;j++) {
				//hamburger info 저장
				String[] info = br.readLine().split(" ");
				hamburger[j][0] = Integer.parseInt(info[0]);
				hamburger[j][1] = Integer.parseInt(info[1]);
			}
			result = 0;
			//부분집합
			Subset(0,0,0);
			sb.append("#"+i+" "+result+"\n");
		}
		System.out.println(sb.toString());
	}
	public static void Subset(int cnt, int score, int calory) {
		//calory가 제한값 넘으면 반환
		if(calory>limit) {
			return;
		}
		else if(cnt == n) {
			//다 돌았으면 최대 score 저장
			result = Math.max(result, score);
			return;
		}
		//뽑았을때
		Subset(cnt+1,score+hamburger[cnt+1][0],calory+hamburger[cnt+1][1]);
		//안뽑았을때
		Subset(cnt+1,score,calory);
	}
}