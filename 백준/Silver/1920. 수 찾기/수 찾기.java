import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] s1 = br.readLine().split(" ");
		int M = Integer.parseInt(br.readLine());
		String[] s2 = br.readLine().split(" ");
		int[] n = new int[N];
		int[] m = new int[M];
		for (int i=0;i<N;i++) {
			n[i] = Integer.parseInt(s1[i]);
		}
		for (int i=0;i<M;i++) {
			m[i] = Integer.parseInt(s2[i]);
		}
		Arrays.sort(n);
		for(int compare : m) {
			if(BinarySearch(n,compare)) {
				sb.append(1+"\n");
			}
			else {
				sb.append(0+"\n");
			}
		}
		System.out.println(sb.toString());
			
	}
    //Binary Search 만들기
	public static boolean BinarySearch(int[] list,int key){
		//lo와 hi 설정
        int lo = 0;
		int hi = list.length -1;
		boolean find = false;
		
		while(lo<=hi) {//lo가 hi보다 클때까지 반복
			int mid = (lo+hi)/2;//중간값 mid설정
			if(key<list[mid]) {
				hi = mid-1; //key값이 list[mid]값보다 작으면 hi를 mid보다 1작게 설정
			}
			else if(key == list[mid]) {
				find = true;//key값이 list[mid]값과 같다면 찾았으니 find=true로 변경
				break;
			}
			else {
				lo = mid+1;//key값이 list[mid]값보다 크면 lo를 mid보다 1크게 설정
			}
		}
		return find;
		
	}
}
