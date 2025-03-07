import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		for(int i=1;i<=10;i++) {
			decrease(0,i,0,10);
		}
		if(n>=0) System.out.println(-1);
	}
	public static void decrease(int cnt,int length,long num,int select) { 
		if(cnt==length) {
			n--;
			if(n==-1) {
				System.out.println(num);
				System.exit(0);
			}
		}
		for(int i=0;i<select;i++) {
			decrease(cnt+1,length,num*10+i,i);
		}
	}
}
