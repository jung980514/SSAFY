import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		for(int i=1;i<=10;i++) {
			int[][] ladder = new int[100][100];
			int x = 0;
			int y = 0;
			int n = Integer.parseInt(br.readLine());
			for(int j=0;j<100;j++) {
				String[] s = br.readLine().split(" ");
				for(int k=0;k<100;k++) {
					ladder[j][k] = Integer.parseInt(s[k]);
					if(ladder[j][k]==2) {
						x = j;
						y = k;
					}
				}
			}
			while(x>0) {
				if(y-1>=0 && ladder[x][y-1]==1) {
					while(y-1>=0 && ladder[x][y-1]==1) {
						y--;
					}
				}
				else if(y+1<100 && ladder[x][y+1]==1) {
					while(y+1<100 && ladder[x][y+1]==1) {
						y++;
					}
				}
				x--;
			}
			System.out.println("#"+i+" "+y);
		}
	}
}