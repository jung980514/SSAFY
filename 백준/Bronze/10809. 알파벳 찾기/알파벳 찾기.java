import java.io.*;
import java.util.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		int[] alpha = new int[26];
		
		for(int i=0;i<alpha.length;i++) {
			alpha[i] = -1;
		}
		
		for(int i=0;i<s.length();i++) {
			char word = s.charAt(i);
			if(alpha[(int)word-97] == -1) {
				alpha[(int)word-97] = i;				
			}
		}
		for (int i=0;i<alpha.length;i++) {
			bw.write(alpha[i]+" ");
		}
		bw.flush();
		bw.close();
	}

}
