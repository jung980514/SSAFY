import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int[] people = new int[n];
		String[] s = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			int zeroCount = 0;
			for(int j=0;j<n;j++) {
				if(Integer.parseInt(s[i])==zeroCount && people[j]==0) {
					people[j] = i+1;
					break;
				}
				if(people[j]==0)
					zeroCount++;
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(people[i]+" ");
		}
	}
}
