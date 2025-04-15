import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String[] s = br.readLine().split(" ");
		int m = Integer.parseInt(s[0]);
		int n = Integer.parseInt(s[1]);
		boolean[] num = new boolean[n+1];
		num[1]=true;
		for(int i=2;i<=n;i++) {
			if(!num[i]) {
				int prime = i;
				prime += i;
				while(prime<=n) {
					num[prime]=true;
					prime += i;
				}
			}
		}
		for(int i=m;i<=n;i++) {
			if(!num[i])
				System.out.println(i);
		}
	}
}
