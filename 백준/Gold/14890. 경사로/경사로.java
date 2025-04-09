import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int x = Integer.parseInt(s[1]);
		int[][] map = new int[n][n];
		int[][] counts = new int[n][n];
		int result=0;
		for(int i=0;i<n;i++) {
			String[] s2 = br.readLine().split(" ");
			for(int j=0;j<n;j++) 
				map[i][j] = Integer.parseInt(s2[j]);
		}
		//가로 개수 카운팅
		for(int i=0;i<n;i++) {
			int idx=0;
			int cur = map[i][0];
			counts[i][idx]++;
			for(int j=1;j<n;j++) {
				if(cur!=map[i][j]) {
					cur = map[i][j];
					idx++;
					counts[i][idx]++;
				}
				else {
					counts[i][idx]++;
				}
			}
		}
		//가로 활주로 건설 방법 세기
		for(int i=0;i<n;i++) {
			int idx=0;
			int cur = map[i][0];
			boolean flag = true;
			for(int j=1;j<n;j++) {
				//다음 값이 큰값이면 
				if(cur < map[i][j]) {
					//현재값 개수 / x 가 다음값-현재값보다 크다면
					if(map[i][j]-cur <= counts[i][idx]/x) {
						//개수를 그만큼 줄이고 다음값으로 이동
						//개수 줄이는 이유는 221112 경우에 겹쳐서 경사로 만들어지는 것을 방지하기위해서
						counts[i][idx] -= (map[i][j]-cur)*x;
						cur = map[i][j];
						idx++;
					}
					else {
						flag = false;
						break;
					}
				}
				//다음 값이 작은값이면
				else if(cur > map[i][j]) {
					idx++;
					//다음값 개수 / x 가 다음값-현재값보다 크다면
					if(cur-map[i][j] <= counts[i][idx]/x) {
						//개수를 그만큼 줄이고 다음값으로 이동
						//개수 줄이는 이유는 21112 경우에 겹쳐서 경사로 만들어지는 것을 방지하기위해서
						counts[i][idx] -= (cur-map[i][j])*x;
						cur = map[i][j];
					}
					else {
						flag = false;
						break;
					}
				}
			}
			if(flag) {
				result++;
			}
		}
		//세로일 경우도 똑같이 수행
		//세로 개수 카운팅
		counts = new int[n][n];
		for(int i=0;i<n;i++) {
			int idx=0;
			int cur = map[0][i];
			counts[i][idx]++;
			for(int j=1;j<n;j++) {
				if(cur!=map[j][i]) {
					cur = map[j][i];
					idx++;
					counts[i][idx]++;
				}
				else {
					counts[i][idx]++;
				}
			}
		}
		//세로 활주로 건설 방법 세기
		for(int i=0;i<n;i++) {
			int idx=0;
			int cur = map[0][i];
			boolean flag = true;
			for(int j=1;j<n;j++) {
				if(cur < map[j][i]) {
					if(map[j][i]-cur <= counts[i][idx]/x) {
						counts[i][idx] -= (map[j][i]-cur)*x;
						cur = map[j][i];
						idx++;
					}
					else {
						flag = false;
						break;
					}
				}
				else if(cur > map[j][i]) {
					idx++;
					if(cur-map[j][i] <= counts[i][idx]/x) {
						counts[i][idx] -= (cur-map[j][i])*x;
						cur = map[j][i];
					}
					else {
						flag = false;
						break;
					}
				}
			}
			if(flag) {
				result++;
			}
		}
		System.out.println(result);
	}
}
