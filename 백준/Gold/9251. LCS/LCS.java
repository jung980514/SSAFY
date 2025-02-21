import java.io.*;
import java.util.*;
	
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		String first = br.readLine();
		String second = br.readLine();
		int[][] dp = new int [first.length()+1][second.length()+1];
		for(int i=1;i<= first.length();i++) {
			for(int j=1;j<=second.length();j++) {
				if(first.charAt(i-1)== second.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		sb.append(dp[first.length()][second.length()]);
		System.out.println(sb.toString());
	}
}