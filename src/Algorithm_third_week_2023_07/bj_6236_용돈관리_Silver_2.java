package Algorithm_third_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_6236_용돈관리_Silver_2 {
    static int N,M,Max,arr[];
    static int answer;

    static int check(int num){
        int tmp = num;
        int cnt = 0;
        for(int i =0;i<N;i++){
            tmp -= arr[i];
            if(tmp<0){
                tmp -= arr[i];
                tmp = num+tmp;
                cnt++;
            }
        }
        return cnt;
    }

    static void Lower(){
        int L = Max; int R = 2000000000;
        while(L<=R){
            int mid = (L+R)/2;
            if(check(mid)<=M){
                answer = mid;
                R = mid-1;
            }else {
                L = mid+1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());  M = Integer.parseInt(st.nextToken());
        Max = 0; answer = 0;
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(Max<arr[i]) Max = arr[i];
        }
        Lower();
        System.out.println(answer);
    }
}
