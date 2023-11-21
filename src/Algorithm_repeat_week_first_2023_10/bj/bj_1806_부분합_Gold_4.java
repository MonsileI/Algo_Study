package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_1806_부분합_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 987654321;
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int L = 0; int R = 0;
        int slide = 0;
            while(true){
                if(slide<M){
                    if(R==N) break;
                    slide += arr[R++];
                }else{
                    ans = Math.min(ans,R-L);
                    slide -= arr[L++];
                }
            }
        System.out.println(ans==987654321 ? 0 : ans);
    }
}
