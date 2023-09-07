package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_1965_상자넣기_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[]ans = new int[N];
        int max = 1;
        for(int i=0;i<N;i++){
            ans[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    ans[i] = Math.max(ans[i],ans[j]+1);
                }
            }
            max = Math.max(max,ans[i]);
        }
        System.out.println(max);
    }
}
