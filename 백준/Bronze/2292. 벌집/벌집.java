import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int count = 1;
		if(N == 1) {
			bw.write("1");
		}
		else {
			for(int i=1;i<N;i++) {
				count += 6*i;
				if(count>=N) {
					count = i+1;
					break;
				}
			}
			bw.write(count+"");
		}
		bw.flush();
		bw.close();
	}
}
