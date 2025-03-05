import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map = new int[10][10];
	static boolean[][] rowvisited = new boolean[10][10];
	static boolean[][] colvisited = new boolean[10][10];
	static boolean[][] boxvisited = new boolean[10][10];
	public static void main(String[] args) throws IOException{
		for(int i=1;i<=9;i++) {
			char[] c = br.readLine().toCharArray();
			for(int j=1;j<=9;j++) {
				map[i][j] = c[j-1]-'0';
				if(map[i][j]!=0) {
					rowvisited[i][map[i][j]] = true;
					colvisited[j][map[i][j]] = true;	
					if(i<=3) {
						if(j<=3)
							boxvisited[1][map[i][j]] = true;
						else if(j<=6)
							boxvisited[4][map[i][j]] = true;
						else
							boxvisited[7][map[i][j]] = true;
					}
					else if(i<=6) {
						if(j<=3)
							boxvisited[2][map[i][j]] = true;
						else if(j<=6)
							boxvisited[5][map[i][j]] = true;
						else
							boxvisited[8][map[i][j]] = true;
					}
					else {
						if(j<=3)
							boxvisited[3][map[i][j]] = true;
						else if(j<=6)
							boxvisited[6][map[i][j]] = true;
						else
							boxvisited[9][map[i][j]] = true;
					}
				}
			}
		}
		Sdoku(1,1);
		
	}
	public static void Sdoku(int x,int y) {	
		if(x==10 && y==1) {
			print();
			System.exit(0);			
		}
		int pos;
		if(x<=3) {
			if(y<=3)
				pos = 1;
			else if(y<=6)
				pos = 4;
			else
				pos = 7;
		}
		else if(x<=6) {
			if(y<=3)
				pos = 2;
			else if(y<=6)
				pos = 5;
			else
				pos = 8;
		}
		else {
			if(y<=3)
				pos = 3;
			else if(y<=6)
				pos = 6;
			else
				pos = 9;
		}
		if(map[x][y]==0) {
			for(int i=1;i<=9;i++) {
				if(!rowvisited[x][i] && !colvisited[y][i] && !boxvisited[pos][i]) {
					map[x][y] = i;
					rowvisited[x][i] = true;
					colvisited[y][i] = true;
					boxvisited[pos][i] = true;
					if(y<9) {
						Sdoku(x,y+1);			
					}
					else {
						Sdoku(x+1,1);
					}
					map[x][y] = 0;
					rowvisited[x][i] = false;
					colvisited[y][i] = false;
					boxvisited[pos][i] = false;
				}
			}
		}
		else {
			if(y<9) {
				Sdoku(x,y+1);			
			}
			else {
				Sdoku(x+1,1);
			}
		}
	}
	private static void print() {
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
}