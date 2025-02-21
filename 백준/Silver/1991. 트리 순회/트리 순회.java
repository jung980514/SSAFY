import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<int[]> graph = new ArrayList<int[]>();
	static int n;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		for(int i=0;i<=n;i++) {
			graph.add(new int[2]);
		}
		for(int i=1;i<=n;i++) {
			char[] ch = br.readLine().toCharArray();
			int parent = ch[0]- '0';
			int firstNode = ch[2]-'0';
			int secondNode = ch[4]-'0';
			if(Character.isAlphabetic(ch[2])) {
				graph.get(parent-16)[0] = (firstNode-16);
			}
			if(Character.isAlphabetic(ch[4])) {
				graph.get(parent-16)[1] = (secondNode-16);
			}			
		}
		visited = new boolean[n+1];
		preorder(1);
		System.out.println();
		visited = new boolean[n+1];
		inorder(1);
		System.out.println();
		visited = new boolean[n+1];
		postorder(1);
		
	}	
	public static void preorder(int i) {
		if(i<1) return;
		System.out.print((char) (i+64));
		preorder(graph.get(i)[0]);
		preorder(graph.get(i)[1]);		
	}
	public static void inorder(int i) {
		if(i<1) return;
		inorder(graph.get(i)[0]);
		System.out.print((char) (i+64));
		inorder(graph.get(i)[1]);
	}
	public static void postorder(int i) {
		if(i<1) return;
		postorder(graph.get(i)[0]);
		postorder(graph.get(i)[1]);
		System.out.print((char) (i+64));
	}
}