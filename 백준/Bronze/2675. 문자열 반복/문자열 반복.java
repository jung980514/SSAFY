import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String a = br.readLine();
		for(int i=0;i<Integer.parseInt(a);i++) {
			String[] b = br.readLine().split(" ");
			String ans = new String();
			for(int j=0;j<b[1].length();j++) {
				for (int k=0;k<Integer.parseInt(b[0]);k++) {
					ans += (b[1].charAt(j));
				}
			}
			bw.write(ans+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
