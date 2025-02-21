import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());  
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (set.contains(name)) {  
                result.add(name);
            }
        }

        Collections.sort(result); 
        sb.append(result.size()).append("\n");

        for (String name : result) {
            sb.append(name).append("\n");
        }

        System.out.print(sb);
    }
}