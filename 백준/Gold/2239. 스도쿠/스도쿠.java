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
				    int boxNumber = ((i-1)/3)*3+((j-1)/3)+1;
				    boxvisited[boxNumber][map[i][j]] = true;
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
		int pos=((x-1)/3)*3+((y-1)/3)+1;
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