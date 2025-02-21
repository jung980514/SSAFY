import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static int result;
	static int[] pib = new int[1001];
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		pib[1]=1;
		pib[2]=2;
		for(int i=3;i<=n;i++) {
			pib[i] = (pib[i-1]%10007+ pib[i-2]%10007)%10007;
		}
		System.out.println(pib[n]);
	}
}