package Algorithm_twenty_week_2023_12.복습;
import java.util.*;
import java.io.*;
public class bj_1439_뒤집기_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int ans = 0;
        int N = str.length();
        //0개수, 1개수 (떨어져 있는)
        int zero = 0; int one = 0;
        boolean flag = true; //1이라는 표시
        for(int i=0;i<N;i++){
            char ch = str.charAt(i);
            if(i==0){
                if(ch=='0') {
                    flag = false;
                    zero++;
                }
                else {
                    flag = true;
                    one++;
                }
                continue;
            }
            if(ch=='0'){
                if(flag) {
                    flag = !flag;
                    zero++;
                }
            }else{
                if(!flag){
                    flag = !flag;
                    one++;
                }
            }
        }
        System.out.println(Math.min(zero,one));
    }
}
