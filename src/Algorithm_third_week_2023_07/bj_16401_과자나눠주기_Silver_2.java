package Algorithm_third_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_16401_과자나눠주기_Silver_2 {
    static int C,N,Max;
    static int arr[];
    static int answer;

    static int check(int num){
        int cnt = 0;
        int tmp = 0;
        for(int i=0;i<N;i++){
            if(arr[i]<num) continue;
            cnt += arr[i]/num;
        }
        return cnt;
    }
    static void upper(){
        int L = 1 ; int R = Max;
        while(L<=R){
            int mid = (L+R)/2;
            if(check(mid)<C){
                R = mid-1;
            }else{
                L = mid+1;
            }
        }
        answer = L-1;

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        Max = 0; answer = 0;

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]>Max) Max = arr[i];
        }
        Arrays.sort(arr);
        upper();
        System.out.println(answer);
    }
}
