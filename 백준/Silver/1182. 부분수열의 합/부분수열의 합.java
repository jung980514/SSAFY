import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int result = 0;
	static int[] nums;
	public static void main(String[] args) throws IOException{
		String[] s1 = br.readLine().split(" ");
		int n = Integer.parseInt(s1[0]);
		int s = Integer.parseInt(s1[1]);
		String[] s2 = br.readLine().split(" ");
		nums = new int[n];
		for(int i=0;i<n;i++) {
			nums[i] = Integer.parseInt(s2[i]);
		}
		int sum=0;
		if(s==sum) result--;
		SumS(0,n,s,sum);
		System.out.println(result);
	}
	public static void SumS(int cnt,int n,int s,int sum) {
		if(cnt==n) {
			if(sum==s) result++;
			return;
		}
		
		SumS(cnt+1,n,s,sum+nums[cnt]);
		
		SumS(cnt+1,n,s,sum);		
	}
}