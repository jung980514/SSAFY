import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	static int white=0;
	static int blue=0;
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		ColorPaper(0,0,n);
		System.out.println(white+"\n"+ blue);
	}
	public static void ColorPaper(int startX,int startY,int n) {
		int color = map[startX][startY];
		boolean flag = false;
		A:for(int i=startX;i<startX+n;i++) {
			for(int j=startY;j<startY+n;j++) {
				if(color != map[i][j]) {
					flag = true;
					break A;
				}
			}
		}
		if(flag) {
			ColorPaper(startX,startY,n/2);
			ColorPaper(startX,startY+n/2,n/2);
			ColorPaper(startX+n/2,startY,n/2);
			ColorPaper(startX+n/2,startY+n/2,n/2);
			
		}
		else if(color==0) {
			white++; 
			return;
		}
		else if(color==1) {
			blue++;
			return;			
		}
	}	
}