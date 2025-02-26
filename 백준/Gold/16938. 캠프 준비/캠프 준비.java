import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] problem;
	static int n;
	static int l;
	static int r;
	static int x;
	static int result;
	public static void main(String[] args) throws IOException{
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		l = Integer.parseInt(s[1]);
		r = Integer.parseInt(s[2]);
		x = Integer.parseInt(s[3]);
		String[] s2 = br.readLine().split(" ");
		problem = new int[n];
		for(int i=0;i<n;i++) {
			problem[i] = Integer.parseInt(s2[i]);
		}
		SelectProblem(0,0,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
		System.out.println(result);
	}
	public static void SelectProblem(int cnt,int sum,int count,int min,int max) {
		if(sum>r) {
			return;
		}
		if(cnt==n) {
			if(count>=2 && sum>=l && max-min>=x) {
				result++;
			}
			return;
		}
		SelectProblem(cnt+1,sum+problem[cnt],count+1,Math.min(min,problem[cnt]),Math.max(max,problem[cnt]));
		
		SelectProblem(cnt+1,sum,count,min,max);
		
	}
}