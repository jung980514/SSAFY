import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> nameToIndex = new HashMap<>();
        String[] indexToName = new String[N + 1];
        
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToIndex.put(name, i);
            indexToName[i] = name;
        }
        
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            if (Character.isDigit(query.charAt(0))) {
                // 숫자 입력 -> 포켓몬 이름 출력
                int index = Integer.parseInt(query);
                bw.write(indexToName[index] + "\n");
            } else {
                // 이름 입력 -> 포켓몬 번호 출력
                bw.write(nameToIndex.get(query) + "\n");
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}