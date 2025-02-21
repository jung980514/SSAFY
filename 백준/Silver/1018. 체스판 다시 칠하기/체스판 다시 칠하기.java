import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		String[][] blackChess = new String[8][8];
		String[][] whiteChess = new String[8][8];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if((i%2==0 && j%2==0) || (i%2==1 && j%2==1)) {
					blackChess[i][j] = "B";
					whiteChess[i][j] = "W";	
				}
				else if((i%2==0 && j%2==1) || (i%2==1 && j%2==0)) {
					blackChess[i][j] = "W";
					whiteChess[i][j] = "B";
				}
			}
		}
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		String[][] square = new String[N][M];
		for(int i=0;i<N;i++) {
			square[i] = br.readLine().split("");
		}
		int cnt = 32;
		for(int i=0;i<N-7;i++) {
			for(int j=0;j<M-7;j++) {
				int blackCount = 0;
				int whiteCount = 0;				
				for(int r = i;r<8+i;r++) {
					for(int c=j;c<8+j;c++) {
						if(!(blackChess[r-i][c-j].equals(square[r][c]))) blackCount++;
						if(!(whiteChess[r-i][c-j].equals(square[r][c]))) whiteCount++;
					}
				}
				if(cnt> Math.min(blackCount, whiteCount)) {
					cnt = Math.min(blackCount, whiteCount);					
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb.toString());
	}
}
