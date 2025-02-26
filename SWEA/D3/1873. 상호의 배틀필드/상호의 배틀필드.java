import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			String[] s1 = br.readLine().split(" ");
			int h = Integer.parseInt(s1[0]);
			int w = Integer.parseInt(s1[1]);
			char[][] map = new char[h][w];
			//tank x좌표,y좌표,바라보고있는 방향(1:위 2:아래 3:왼쪽 4:오른쪽)
			int[] tank = new int[3];
			for(int j=0;j<h;j++) {
				char[] line = br.readLine().toCharArray();
				for(int k=0;k<w;k++) {
					map[j][k] = line[k];
					if(map[j][k]=='^') {
						tank[0] = j;
						tank[1] = k;
						tank[2] = 1;
					}
					else if(map[j][k]=='v') {
						tank[0] = j;
						tank[1] = k;
						tank[2] = 2;
					}
					else if(map[j][k]=='<') {
						tank[0] = j;
						tank[1] = k;
						tank[2] = 3;
					}
					else if(map[j][k]=='>') {
						tank[0] = j;
						tank[1] = k;
						tank[2] = 4;
					}
				}
			}
			int n = Integer.parseInt(br.readLine());
			char[] input = br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				switch (input[j]) {
				case 'U':
					if(tank[0]-1>=0 && map[tank[0]-1][tank[1]]=='.') { 
						map[tank[0]-1][tank[1]] = '^';
						map[tank[0]][tank[1]] = '.';
						tank[0] -=1;
						tank[2] = 1;
					}
					else {
						map[tank[0]][tank[1]] = '^';
						tank[2] = 1;	
					}
					break;
				case 'D':
					if(tank[0]+1<h && map[tank[0]+1][tank[1]]=='.') { 
						map[tank[0]+1][tank[1]] = 'v';
						map[tank[0]][tank[1]] = '.';
						tank[0] +=1;
						tank[2] = 2;
					}
					else {
						map[tank[0]][tank[1]] = 'v';
						tank[2] = 2;
					}	
					break;
				case 'L':
					if(tank[1]-1>=0 && map[tank[0]][tank[1]-1]=='.') { 
						map[tank[0]][tank[1]-1]='<';
						map[tank[0]][tank[1]] = '.';
						tank[1] -=1;
						tank[2] = 3;							
					}
					else {
						map[tank[0]][tank[1]]='<';
						tank[2] = 3;							
					}
					break;
				case 'R':
					if(tank[1]+1<w && map[tank[0]][tank[1]+1]=='.') {
						map[tank[0]][tank[1]+1]='>';
						map[tank[0]][tank[1]] = '.';
						tank[1] +=1;
						tank[2] = 4;	
					}
					else {
						map[tank[0]][tank[1]]='>';
						tank[2] = 4;
					}
					break;
				case 'S':
					int sx = tank[0];
					int sy = tank[1];
					if(tank[2]==1) {
						while(sx>=0) {
							if(map[sx][sy]=='*') {
								map[sx][sy]='.';
								break;
							}
							if(map[sx][sy]=='#') {
								break;
							}
							sx--;
						}
					}
					else if(tank[2]==2) {
						while(sx<h) {
							if(map[sx][sy]=='*') {
								map[sx][sy]='.';
								break;
							}
							if(map[sx][sy]=='#') {
								break;
							}
							sx++;
						}
					}
					else if(tank[2]==3) {
						while(sy>=0) {
							if(map[sx][sy]=='*') {
								map[sx][sy]='.';
								break;
							}
							if(map[sx][sy]=='#') {
								break;
							}
							sy--;
						}
					}
					else if(tank[2]==4) {
						while(sy<w) {
							if(map[sx][sy]=='*') {
								map[sx][sy]='.';
								break;
							}
							if(map[sx][sy]=='#') {
								break;
							}
							sy++;
						}
					}
					break;
				}
			}
			sb.append("#").append(i).append(" ");
			for(int j=0;j<h;j++) {
				for(int k=0;k<w;k++) {
					sb.append(map[j][k]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}