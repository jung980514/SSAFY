import java.io.*;
import java.util.*;
/*
 * 메모리 11704KB 
 * 시간 72ms
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] cards;
	static int[] output = new int[3];
	static int m;
	static int result=0;
	public static void main(String[] args) throws IOException{
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		cards = new int[n];
		String[] s2 = br.readLine().split(" ");
		for(int i=0;i<n;i++) { //카드 입력받기
			cards[i] = Integer.parseInt(s2[i]);
		}
		//n개의 카드중에 3개 뽑기
		Combination(0,0,n,3,0);
		System.out.println(result);
	}
	public static void Combination(int depth,int start,int n,int r,int sum) {
		if(depth==r) {
			//합이 m을 넘지 않고 차이가 작으면 결과값에 sum 대입
			if(sum<=m && m-sum < m-result) result = sum;
			return;
		}
		for(int i=start;i<n;i++) {
			output[depth] = cards[i];
			Combination(depth+1,i+1,n,r,sum+cards[i]);
		}
	}
}