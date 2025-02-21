import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b.compareTo(a)));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}
				else {
					System.out.println(pq.poll());
				}
			}
			else {
				pq.add(x);
			}
		}
	}
}