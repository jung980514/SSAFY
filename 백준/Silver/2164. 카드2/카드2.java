import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    public static void main(String[] args) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int flag =0;
        for(int i=1;i<=N;i++) {
        	q.offer(i);
        }
        
        while(q.size()>1) {
        	if(flag == 0) {
        		q.poll();
        		flag++;
        	}
        	else {
        		int i = q.peek();
            	q.poll();
            	q.offer(i);
            	flag--;
        	}
        }
        sb.append(q.poll());
        System.out.println(sb.toString());
    }
}
