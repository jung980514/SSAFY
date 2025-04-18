import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[1000001];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		for(int i=4;i<=n;i++) {
			//2와 3으로 나눠질때
			if(i%2==0 && i%3==0)
				//1로 뺸 값일때, 2로 나눈 값일때, 3으로 나눈 값일때 연산수 +1
				dp[i] = Math.min(Math.min(dp[i-1]+1,dp[i/2]+1),dp[i/3]+1);
			//2로만 나눠질때
			else if(i%2==0){
				//1로 뺸 값일때, 2로 나눈 값일때 연산수 +1
				dp[i] = Math.min(dp[i-1]+1,dp[i/2]+1);
			}
			//3으로만 나눠질때
			else if(i%3==0) {
				//1로 뺸 값일때,3으로 나눈 값일때 연산수 +1
				dp[i] = Math.min(dp[i-1]+1,dp[i/3]+1);
			}
			//2와 3으로 안나눠질때
			else {
				//1로 뺸 값일때 연산수 +1
				dp[i] = dp[i-1] +1;
			}
		}
		System.out.println(dp[n]);
	}
}
