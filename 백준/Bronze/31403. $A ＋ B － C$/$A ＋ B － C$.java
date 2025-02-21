import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		
		int num = Integer.parseInt(a)+Integer.parseInt(b)-Integer.parseInt(c);
		int num2 = Integer.parseInt(a+b) - Integer.parseInt(c);
		bw.write(num+"\n");
		bw.write(num2+" ");
		bw.flush();
		bw.close();
	}

}
