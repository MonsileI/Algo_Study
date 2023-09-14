package Algorithm_eleventh_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_22862_가장짝연속한부분수열large_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N= Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]OArr = new int[N];
        int[]EArr = new int[N];
        int o =0;
        int e =0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num%2==0) e++;
            else o++;
            OArr[i] = o;
            EArr[i] = e;
        }
        int L = 0; int R = 0;
        int answer = 0;

        if(N==1&&EArr[0]==1){
            answer = 1;
        }else{
            while(R<N){
                int cnt = OArr[R] - OArr[L];
                if(cnt<=M){
                    int ent = EArr[R] - EArr[L];
                    if(L==0&&EArr[L]==1) ent++;
                    answer = Math.max(answer,ent);
                    R++;
                }else {
                    L++;
                }
            }
        }

        System.out.println(answer);

    }
}
