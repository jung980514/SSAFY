import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n+1];
        int[] D = new int[n+1]; 

        String[] s = br.readLine().split(" ");
        for (int i=1; i <=n; i++) {
            A[i] = Integer.parseInt(s[i-1]);
        }

        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(A[1]);
        D[1] = 1;

        for (int i=2; i<=n; i++) {
            int num = A[i];
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) pos = -pos-1; 

            if (pos == lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num);
            }

            D[i] = pos + 1;
        }

        System.out.println(lis.size());
        
        int idx = lis.size();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=D.length-1;i>0;i--) {
        	if(D[i]==idx) {
        		list.add(A[i]);
        		idx--;
        	}
        }
        Collections.sort(list);
        
        for(int i : list) {
        	System.out.print(i+" ");
        }
    }
}
