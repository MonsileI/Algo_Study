package Algorithm_foureenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_16564_히오스프로그래머_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int L = arr[0]; int R = 1000000001;
        while(L<=R){
            int mid = (L+R)/2;
            long sum = 0;
            for(int i=0;i<N;i++){
                if(arr[i]<mid) sum += (mid - arr[i]);
            }
            if(sum<=K){
                answer = mid;
                L = mid+1;
            }else{
                R = mid-1;
            }
        }
        System.out.println(answer);

    }
}
