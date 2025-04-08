import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int[][] line = new int[n][2];
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			line[i][0] = Integer.parseInt(s[0]);
			line[i][1] = Integer.parseInt(s[1]);
		}
		//A 전깃줄을 기준으로 정렬 
		Arrays.sort(line,(a,b)->(a[0]-b[0]));
		ArrayList<Integer> list = new ArrayList<>();
		list.add(line[0][1]);
		
		for(int i=1;i<n;i++) {
			//list에 해당 값이 있는지 확인
			int pos = Collections.binarySearch(list, line[i][1]);
			if(pos<0) pos = -pos-1;
			//해당 값이 없거나 범위를 넘어가면 뒤에 추가
			if(pos==list.size())
				list.add(line[i][1]);
			//범위 안에 있다면 해당 위치값 변경
			else
				list.set(pos, line[i][1]);
		}
		System.out.println(n-list.size());
	}
}
