import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<N;i++) {
        	String[] s = br.readLine().split(" ");
        	if(s[0].equals("push")) {
        		//push
        		stk.add(Integer.parseInt(s[1]));
        	}
        	else if (s[0].equals("pop")) {
        		//pop
        		if(stk.isEmpty()) {
        			sb.append("-1\n");
        		}
        		else {
        			sb.append(stk.pop()+"\n");
        		}
        	}
        	else if (s[0].equals("size")) {
        		//size
        		sb.append(stk.size()+"\n");
        	}	
        	else if (s[0].equals("empty")) {
        		//empty
        		if(stk.isEmpty()) sb.append("1\n");
        		else	sb.append("0\n");
        	}
        	else if (s[0].equals("top")){
        		//top
        		if(stk.isEmpty()) sb.append("-1\n");
        		else	sb.append(stk.peek()+"\n");
        	}
        }
        System.out.println(sb.toString());
    }
}
