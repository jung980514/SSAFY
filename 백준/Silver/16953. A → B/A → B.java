import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		String[] s = br.readLine().split(" ");
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		int count=1;
		while(a<b) {
			if(b%10==1)
				b /=10;
			else if(b%2==0)
				b /=2;
			else
				break;
			count++;
		}
		if(a==b)
			System.out.println(count);
		else
			System.out.println(-1);
	}
}
