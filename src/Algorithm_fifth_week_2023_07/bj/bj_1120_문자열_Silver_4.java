package Algorithm_fifth_week_2023_07.bj;

import java.util.*;
import java.io.*;
public class bj_1120_문자열_Silver_4 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String A = st.nextToken();
        String B = st.nextToken();
        int sizeA = A.length();
        int sizeB = B.length();
        int answer = 987654321;
        if(sizeA==sizeB){
            answer = 0;
            for(int i=0;i<sizeA;i++){
                char f = A.charAt(i); char s = B.charAt(i);
                if(f!=s) answer++;
            }
        }else{
            for(int i=0;i<sizeB-sizeA+1;i++){
                int cnt = 0;
                for(int j=0;j<sizeA;j++){
                    char f = A.charAt(j);
                    char s = B.charAt(i+j);
                    if(f!=s) cnt++;
                }
                answer = Math.min(answer,cnt);
            }
        }

        System.out.println(answer);
    }
}
