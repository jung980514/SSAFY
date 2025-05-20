import java.io.*; 

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int total = 0;
        for(int i=0;i<N;i++){
            String[] parts = br.readLine().split(" ");
            int students = Integer.parseInt(parts[0]);
            int apples   = Integer.parseInt(parts[1]);
            total += apples % students;
        }
        System.out.print(total);
    }
}
