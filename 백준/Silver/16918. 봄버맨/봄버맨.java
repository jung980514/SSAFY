import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static char[][] map;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};	
	public static void main(String[] args) throws IOException{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		String[] rcn = br.readLine().split(" ");
		int r = Integer.parseInt(rcn[0]);
		int c = Integer.parseInt(rcn[1]);
		int n = Integer.parseInt(rcn[2]);
		map = new char [r][c];
		for(int i=0;i<r;i++) {
			char[] state = br.readLine().toCharArray();
			for(int j=0;j<c;j++) {
				map[i][j] = state[j];
			}
		}
		for(int i=1;i<=n;i++) {
			if(i==1) continue;
			else if(i%2==0) {
				for(int j=0;j<r;j++) {
					for(int k=0;k<c;k++) {
						if(map[j][k]=='.') {
							map[j][k] = 'O';
						}
						else if(map[j][k]=='O') {
							map[j][k] = '@';
						}
					}
				}
			}
			else if(i%2==1) {
				for(int j=0;j<r;j++) {
					for(int k=0;k<c;k++) {
						if(map[j][k]=='@') {
							map[j][k] = '.';
							for(int d=0;d<4;d++) {
								int nj = j + dx[d];
								int nk = k + dy[d];
								if(nj>=0 && nk>=0 && nj<r && nk<c && map[nj][nk]!='@') {
									map[nj][nk] = '.';
								}
							}
						}
					}
				}
			}
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]=='@') {
					System.out.print('O');
				}
				else {
					System.out.print(map[i][j]);
				}
			}
			System.out.println();
		}
	}

}
