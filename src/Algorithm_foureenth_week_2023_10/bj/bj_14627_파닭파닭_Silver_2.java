package Algorithm_foureenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_14627_파닭파닭_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = 1; int R = 100000001;
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
        int tmp = 0;
        while(L<=R){
            int mid = (L+R)/2;
            long sum = 0;
            for(int i=0;i<N;i++){
                if(mid<=arr[i]) sum += (arr[i]/mid);
            }
            if(sum<K){
                R = mid-1;
            }else{
                if(sum==K) tmp = Math.max(tmp,mid);
                L = mid+1;
            }
        }
        long answer = 0;
        for(int i=0;i<N;i++) {
            answer += arr[i] % tmp;
        }
        System.out.println(answer);
    }
}
