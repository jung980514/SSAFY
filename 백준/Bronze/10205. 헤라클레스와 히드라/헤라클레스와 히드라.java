import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(br.readLine());
        for(int t=1;t<=K;t++) {
            System.out.println("Data Set " + t + ":");
            int h = Integer.parseInt(br.readLine());
            String actions = br.readLine();
            for(int i=0;i<actions.length();i++) {
                char action = actions.charAt(i);
                if(action=='c') {
                    h += 1; // 머리 하나 자르면 +1
                } else if(action=='b') {
                    h -= 1; // 자르고 불지지면 -1
                }
            }
            System.out.println(h);
            if(t!=K) System.out.println();
        }
    }
}
