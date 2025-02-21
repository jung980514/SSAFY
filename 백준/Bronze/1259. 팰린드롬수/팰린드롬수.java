import java.io.*;
//import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		while(true) {
			String s = br.readLine();
			if(s.equals("0")) break;
			char[] a = new char[s.length()];
			char[] b = new char[s.length()];
			
			for (int i = 0;i<s.length();i++) {
				a[i] = s.charAt(i);
				b[i] = s.charAt(s.length()-i-1);
			}
			String A = new String(a);
			String B = new String(b);
			if(A.equals(B)) {
				bw.write("yes\n");
			}
			else {
				bw.write("no\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
