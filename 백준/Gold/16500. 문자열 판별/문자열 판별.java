import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Set<String> dict = new HashSet<>();
        int maxLen = 0; // 가장 긴 단어
        
        for(int i=0;i<n;i++){
            String s2 = br.readLine();
            dict.add(s2);
            if(s2.length()>maxLen) 
            	maxLen = s2.length();
        }

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;  

        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=maxLen;j++){
            	// i보다 길면 중단
                if(j>i) 
                	break;  
                // 이전 위치에서 만들 수 없다면 스킵
                if(!dp[i-j]) 
                	continue;       
                
                // s[i-j ~ i] 가 사전에 있으면 가능 표시 후 탈출
                if(dict.contains(s.substring(i-j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        System.out.println(dp[s.length()]?1:0);
    }
}