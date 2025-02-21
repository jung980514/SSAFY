import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		bw.write(st.countTokens()+"");
		bw.flush();
		bw.close();
	}

}
