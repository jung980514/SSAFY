import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int[] cnt = new int[42];
		for (int i=0;i<cnt.length;i++) {
			cnt[i]=0;
		}
		for (int i=0;i<10;i++) {
			int num = Integer.parseInt(br.readLine());
			cnt[num%42]++;
		}
		List<Integer> intList = new ArrayList<>();
		for (int i : cnt) {
			intList.add(i);
		}
		int zero = Collections.frequency(intList,0);
		bw.write((42-zero)+ "");
		bw.flush();
		bw.close();
	}
}
