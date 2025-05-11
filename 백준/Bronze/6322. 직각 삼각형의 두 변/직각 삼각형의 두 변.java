import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line;
        int tc=1;
        while((line=br.readLine())!=null){
            String[] p=line.split(" ");
            double a=Double.parseDouble(p[0]), b=Double.parseDouble(p[1]), c=Double.parseDouble(p[2]);
            if(a==0&&b==0&&c==0) break;

            System.out.println("Triangle #"+tc++);

            if(a==-1){
                // a를 구해야 할 때: c^2 - b^2 > 0 이어야 함
                if(c*c-b*b<=0) System.out.println("Impossible.");
                else{
                    double s=Math.sqrt(c*c-b*b);
                    System.out.printf("a = %.3f%n", s);
                }
            }else if(b==-1){
                // b를 구해야 할 때: c^2 - a^2 > 0 이어야 함
                if(c*c-a*a<=0) System.out.println("Impossible.");
                else{
                    double s=Math.sqrt(c*c-a*a);
                    System.out.printf("b = %.3f%n", s);
                }
            }else if(c==-1){
                // c를 구해야 할 때: a^2 + b^2
                double s=Math.sqrt(a*a+b*b);
                System.out.printf("c = %.3f%n", s);
            }

            System.out.println();
        }
    }
}