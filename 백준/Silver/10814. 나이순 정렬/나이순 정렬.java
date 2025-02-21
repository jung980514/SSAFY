import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[][] s =new String[N][2];
		for(int i=0;i<N;i++) {
			String[] n = br.readLine().split(" ");
			s[i][0] = n[0];
			s[i][1] = n[1];
		}
		Arrays.sort(s,(o1,o2) -> {
			return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
		});
//		나이가 같으면 이름으로 정렬
//		Arrays.sort(s,(o1,o2) -> {
//			if(Integer.parseInt(o1[0])==Integer.parseInt(o2[0])) {
//				return (o1[1].charAt(0)-'0')-(o2[1].charAt(0)-'0');			
//			}
//			else {
//				return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
//			}
//		});
		for (int i=0;i<N;i++) {
			sb.append(s[i][0]+" "+ s[i][1]+"\n");
		}
		System.out.println(sb.toString());
	}
}
