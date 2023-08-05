package Algorithm_fifth_week_2023_07.bj;

import java.util.*;
import java.io.*;
public class bj_2491_수열_Silver_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 1;
        int maxCnt = 1;
        int minCnt = 1;
        for(int i=0;i<N-1;i++){
            if(arr[i]<=arr[i+1]) maxCnt++;
            else maxCnt = 1;
            answer = Math.max(maxCnt,answer);
            if(arr[i]>=arr[i+1]) minCnt++;
            else minCnt = 1;
            answer = Math.max(minCnt,answer);

        }
        System.out.println(answer);
    }
}
