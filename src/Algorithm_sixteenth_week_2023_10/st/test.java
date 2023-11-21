package Algorithm_sixteenth_week_2023_10.st;
import java.util.*;

public class test {
    public static void main(String[] args) throws Exception {
       Scanner scan = new Scanner(System.in);
       int n = scan.nextInt();
       int answer = 0;
       while (true) {
           if (n%5==0) {answer += n/5; break;}
           n-=3; answer++;
           if (n<0) {answer = -1; break;}
           if (n==0) break;
       }
       System.out.print(answer);
    }
}
