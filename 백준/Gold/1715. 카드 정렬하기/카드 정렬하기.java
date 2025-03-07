import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int result = 0;
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
		for(int i=0;i<n;i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		while(pq.size()>1) {
			int a = pq.poll();
			int b = pq.poll();
			pq.offer(a+b);
			result += a+b;
		}
		System.out.println(result);
	}
}
