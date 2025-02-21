import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		List<String> words = new ArrayList();
		for (int i=0;i<N;i++) {
			String st = br.readLine();
			if(!words.contains(st)) words.add(st);
		}
		Collections.sort(words);
		words.sort((o1,o2)->(o1.length()-o2.length()));
		String [] word =words.toArray(new String[0]);
		for(int i=0;i<word.length;i++) {
			bw.write(word[i]+"\n");
		}
		bw.flush();
		bw.close();
	}
}
