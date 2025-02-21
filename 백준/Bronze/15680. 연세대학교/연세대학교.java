import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		char[] c = br.readLine().toCharArray();
		if(c[0]=='0') {
			System.out.println("YONSEI");
		}
		else {
			System.out.println("Leading the Way to the Future");
		}
	}
}