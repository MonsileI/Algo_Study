package Algorithm_first_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_16953_A_B_Silver_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken()); int s = Integer.parseInt(st.nextToken());
        int answer = 1;
        boolean flag = false;
        while(f<s){
            if(s%2==0){
                s /=2;
            }else{
                String tmp = ""+s;
                if(tmp.charAt(tmp.length()-1)=='1'){
                    tmp = tmp.substring(0,tmp.length()-1);
                    s = Integer.parseInt(tmp);
                }else {
                    flag = true;
                    break;
                }
            }

            if(s<f){
                flag = true;
                break;
            }

            answer++;
        }
        if(flag) answer = -1;
        System.out.println(answer);

    }
}
