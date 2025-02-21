import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int m = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            String command = s[0];

            switch (command) {
                case "add":
                    set.add(Integer.parseInt(s[1]));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(s[1]));
                    break;    
                case "check":
                    sb.append(set.contains(Integer.parseInt(s[1])) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    int num = Integer.parseInt(s[1]);
                    if (set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;
                case "all":
                    set.clear();
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.print(sb);
    }
}