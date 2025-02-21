import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    public static void main(String[] args) throws IOException {
        StringBuilder sb= new StringBuilder();
    	int N = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        HashMap<String, Integer> cards = new HashMap<>();
        for(int i=0;i<N;i++) {
        	if(cards.containsKey(s1[i])) {
        		cards.put(s1[i],cards.get(s1[i])+1);
        	}
        	else {
        		cards.put(s1[i], 1);
        	}
        }
        int M = Integer.parseInt(br.readLine());
        String[] s2 = br.readLine().split(" ");
        for(int i=0;i<M;i++) {
        	System.out.print(cards.getOrDefault(s2[i],0)+" ");        		
        }  
    }
}
