import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String[] s = br.readLine().split(" ");
		String[] asc = {"1","2","3","4","5","6","7","8"};
		String[] des = {"8","7","6","5","4","3","2","1"};
		if (Arrays.equals(s, asc)) {
			bw.write("ascending");
		}
		else if(Arrays.equals(s, des)){
			bw.write("descending");
		}
		else {
			bw.write("mixed");
		}
		bw.flush();
		bw.close();
	}
}
