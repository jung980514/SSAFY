import java.io.*;
import java.util.*;
	
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int[] liquid = new int[n];
		String[] s = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			liquid[i] = Integer.parseInt(s[i]);
		}
		int left = 0;
		int right = n-1;
		int[] result = new int[] {0,0,Integer.MAX_VALUE};
		
		while(true)	{
			if(left==right)
				break;
			int sum = liquid[left] + liquid[right];
			if(Math.abs(sum)<Math.abs(result[2]))
				result = new int[] {liquid[left],liquid[right],sum};
			if(sum<0) {
				left++;
			}
			else
				right--;
		}
		System.out.println(result[0] +" "+ result[1]);
	}
}
