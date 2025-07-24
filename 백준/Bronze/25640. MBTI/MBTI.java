import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 진호의 MBTI 유형
        String jinhoMBTI = br.readLine();

        // 친구 수
        int n = Integer.parseInt(br.readLine());

        int sameCount = 0;
        for(int i=0; i<n; i++) {
            String friendMBTI = br.readLine();
            if(jinhoMBTI.equals(friendMBTI)) {
                sameCount++;
            }
        }

        // 결과 출력
        System.out.println(sameCount);
    }
}
