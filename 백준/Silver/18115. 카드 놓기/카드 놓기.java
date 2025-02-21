import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    public static void main(String[] args) throws IOException {
        StringBuilder sb= new StringBuilder();
    	Deque<Integer> dq = new LinkedList<>();
    	int N = Integer.parseInt(br.readLine());
    	String[] s = br.readLine().split(" ");
    	int count=1;
    	for(int i=N-1;i>=0;i--) {
    		if(s[i].equals("1")) {
    			dq.offerFirst(count);
    		}
    		else if(s[i].equals("2")) {
    			Integer first = dq.peekFirst();
    			dq.pollFirst();
    			dq.offerFirst(count);
    			dq.offerFirst(first);
    		}
    		else {
    			dq.offerLast(count);
    		}
    		count++;
    	}
    	for(Integer n : dq) {
    		sb.append(n+" ");
    	}
    	System.out.println(sb.toString());
    }
}
