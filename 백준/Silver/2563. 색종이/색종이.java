import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int[][] colorPaper = new int[n][2];
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			colorPaper[i][0] = Integer.parseInt(s[0]);
			colorPaper[i][1] = Integer.parseInt(s[1]);			
		}
		int[][] map = new int[100][100];
		for(int[] paper : colorPaper) {
			for(int i=paper[0]-1;i<paper[0]+9;i++) {
				for(int j=paper[1]-1;j<paper[1]+9;j++) {
					map[i][j] = 1;
				}
			}
		}
		int count = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j]==1)
					count++;
			}
		}
		System.out.println(count);
	}
}