package Jun_third.bj;

import java.util.*;
import java.io.*;
public class test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int nSize = 1;
        for(int i=0;i<N;i++) nSize += 2;
        int len = Integer.parseInt(br.readLine());
        int answer = 0;
        int cnt = 0;
        boolean flag = false; //'O';
        String str = br.readLine();
        char fir = 'O';
        for(int i=0;i<len;i++){
            char ch = str.charAt(i);
            if(flag) {
                if(ch=='O'){
                    flag = !flag;
                    cnt++;
                }else {
                    if(nSize<=cnt) answer += (cnt - nSize/2) +1;
                    flag = true;
                    cnt = 1;
                }

            }else{
                if(ch=='I'){
                    flag = !flag;
                    cnt++;
                }else {
                    if(nSize<=cnt) answer += (cnt - nSize/2) +1;
                    flag = false;
                    cnt = 0;
                }
            }
        }
        if(nSize<=cnt) answer += (cnt - nSize/2) +1;

        System.out.println(answer);
    }
}
