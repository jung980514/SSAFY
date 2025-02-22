import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Set<Integer> num = new HashSet<>();
		int it = 0;
		String[] s =br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			num.add(Integer.parseInt(s[i]));
		}
		int[] n = new int[num.size()];
		for(Integer i : num) {
			n[it++] = i;
		}
		Arrays.sort(n);
		for(int i=0;i<N;i++) {
			sb.append(Arrays.binarySearch(n, Integer.parseInt(s[i]))).append(" ");
		}
		System.out.println(sb.toString());
	}
}