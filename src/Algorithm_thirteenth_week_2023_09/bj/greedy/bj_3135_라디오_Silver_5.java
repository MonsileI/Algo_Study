package Algorithm_thirteenth_week_2023_09.bj.greedy;

import java.util.*;
import java.io.*;
public class bj_3135_라디오_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        int tmp = Math.abs(S-G);
        int answer = 0;
        int tmpNum = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(Math.abs(arr[i]-G)<=tmp){
                tmp = Math.abs(arr[i]-G);
                tmpNum = arr[i];
            }
        }
        if(tmp==0) answer = 1;
        else{
            if(tmp==Math.abs(S-G)) answer = Math.abs(S-G);
            else{
                answer++;
                answer += Math.abs(tmpNum-G);
            }
        }
        System.out.println(answer);
    }
}
