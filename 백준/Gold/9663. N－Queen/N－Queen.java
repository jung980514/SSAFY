import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[][] visited;
	static int result=0;
	static boolean[] column;
	static boolean[] diag1; //우상단->좌하단 대각선은 x+y값이 같다
	static boolean[] diag2;	 // 좌상단->우하단 대각선은 x-y값이 같다
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		column = new boolean[n];
		diag1 = new boolean[2*n-1];
		diag2 = new boolean[2*n-1];
		NQueen(0,n,0);
		System.out.println(result);
	}
	public static void NQueen(int cnt,int n,int row) {
		if(cnt == n) {
			result++;
			return;
		}
		for(int col=0;col<n;col++) {
			//같은 열이나 대각선이면 무시
			if(column[col] || diag1[row+col] || diag2[row-col+n-1])
				continue;
			
			//열 대각선 2개 true
			column[col] = true;
			diag1[row+col] = true;
			diag2[row-col+n-1] = true;
			
			//다음 행으로 이동
			NQueen(cnt+1,n,row+1);
			
			//백트래킹
			column[col] = false;
			diag1[row+col] = false;
			diag2[row-col+n-1] = false;
		}
		
	}
}