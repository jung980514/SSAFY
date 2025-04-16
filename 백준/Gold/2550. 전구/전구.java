import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		String[] s2 = br.readLine().split(" ");
		ArrayList<Integer> D = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
		    D.add(Integer.parseInt(s2[i])); 
		}
		int[] A = new int[n+1];
		for(int i=1;i<=n;i++) {
			A[i] = D.indexOf(Integer.parseInt(s[i-1]));
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<int[]> check = new ArrayList<int[]>();
		
		for(int i=1;i<=n;i++) {
			int pos = Collections.binarySearch(list, A[i]);
			if(pos<0)
				pos = -pos-1;
			if(pos==list.size()) {
				list.add(A[i]);
			}
			else {
				list.set(pos, A[i]);
			}
			check.add(new int[] {pos,Integer.parseInt(s[i-1])});
		}
		System.out.println(list.size());
		
		ArrayList<Integer> printout = new ArrayList<Integer>();
		int last = list.size()-1;
        for (int i=check.size()-1; i>=0; i--) {
            if (check.get(i)[0]==last) {
                printout.add(check.get(i)[1]);
                last--;
            }
        }
        
		Collections.sort(printout);
		for(int print : printout) {
			System.out.print(print+" ");
		}
	}
}