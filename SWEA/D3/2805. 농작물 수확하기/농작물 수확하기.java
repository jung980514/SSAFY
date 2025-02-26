import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			for(int j=0;j<n;j++) {
				char[] s = br.readLine().toCharArray();
				//j가 농작물의 중간보다 작을때
				if(j<(n-1)/2) {
					// 중간값-j <= X <= 중간값+j 안의 값을 다 더해줘야한다
					for(int k=(n-1)/2-j;k<=(n-1)/2+j;k++) {
						sum+=s[k]-'0';
					}
				}
				else if(j==(n-1)/2) {
					// 중간값일때는 전부다 더해줘야한다
					for(int k=0;k<n;k++) {
						sum+=s[k]-'0';
					}
				}
				else {
					// 중간값-(n-1-j) <= X <= 중간값+(n-1-j) 안의 값을 다 더해줘야한다
					for(int k=(n-1)/2-(n-j-1);k<=(n-1)/2+(n-j-1);k++) {
						sum+=s[k]-'0';
					}
				}
			}
			System.out.println("#"+i+" "+sum);
		}
	}
}