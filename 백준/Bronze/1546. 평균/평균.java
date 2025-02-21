import java.io.*;
import java.util.Arrays;
//import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		String m = br.readLine();
		int M = Integer.parseInt(m);
		String[] s = br.readLine().split(" ");
		int[] score = new int[s.length];
		for(int i=0;i<s.length;i++) {
			score[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(score);
		double max = score[M-1];
		double sum = 0.0;
		for(double i : score) {
			sum += i/max*100;
		}
		bw.write(sum/M+"");
		bw.flush();
		bw.close();
	}

}
