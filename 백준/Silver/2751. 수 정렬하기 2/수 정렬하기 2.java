import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		List<Integer> num = new ArrayList<>();		
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(br.readLine());
			num.add(n);
		}
		Collections.sort(num);
		Object[] s = num.toArray();
		for(int i=0;i<N;i++) {
			bw.write(s[i]+"\n");			
		}
		bw.flush();
		bw.close();
	}
}
