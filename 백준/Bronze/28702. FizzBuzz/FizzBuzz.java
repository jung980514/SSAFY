import java.io.*;
import java.util.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String[] s = new String[3];
		for(int i=0;i<3;i++) {
			s[i] = br.readLine();
		}
		for(int i=0;i<3;i++) {
			if((int)s[i].charAt(0)<65) {
				int num = Integer.parseInt(s[i]);

				if(i==0) {
					num+=3;
				}
				else if(i==1) {
					num+=2;
				}
				else {
					num+=1;
				}
				if(num%5==0 && num%3==0) {
					bw.write("FizzBuzz");
				}
				else if(num%3 == 0) {
					bw.write("Fizz");
				}
				else if(num%5 == 0) {
					bw.write("Buzz");
				}
				else {
					bw.write(num+"");
				}
				break;
			}
		}
		
		bw.flush();
		bw.close();
	}

}
