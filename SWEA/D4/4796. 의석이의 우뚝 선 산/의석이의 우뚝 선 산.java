import java.util.*;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=1;i<=T;i++) {
			int n = in.nextInt();
			int[] mountain = new int[n];
			for(int j=0;j<n;j++) {
				mountain[j] = in.nextInt();
			}
			int result = 0;
			for(int j=1;j<n;j++) {
				//이전값보다 현재값이 더 클때 시작
				if(mountain[j-1]<mountain[j]) {
					int idx = j;
					//mountain[idx]<mountain[idx+1]이면 
					//mountain[idx]>mountain[idx+1]이 나올때까지 계속 idx 증가
					while(idx<n-1 && mountain[idx]<mountain[idx+1]) {
						idx++;
					}
					//그 후 mountain[idx]>mountain[idx+1] 일때마다 결과값,idx 증가
					while(idx<n-1 && mountain[idx]>mountain[idx+1]) {
//						System.out.println(j+" "+(idx+2));
						result++;
						idx++;
					}
				}
			}
			System.out.println("#"+i+" "+result);
		}
	}
}