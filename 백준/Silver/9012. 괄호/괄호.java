import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<N;i++) {
			String[] s = br.readLine().split("");
			Stack<Integer> stk = new Stack<Integer>();
			int flag = 0;
			for(String x : s) {
				if(x.equals("(")){
					stk.push(1);
				}
				else if(stk.empty()) {
					flag =1 ;
					break;
				}
				else {
					stk.pop();	
				}
			}
			if(flag==0 && stk.empty()) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb.toString());
	}
}
