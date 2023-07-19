package Algorithm_third_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_6236_용돈관리_Silver_2 {
    static int sum,N,M,Max,arr[];
    static int answer;

    static boolean check(int num){
        int tmp = num;
        int cnt = M;
        for(int i =0;i<N;i++){
            if(tmp-arr[i]<=0){
                tmp -= arr[i];
                tmp = num+tmp;
                cnt--;
            }
            if(cnt==-1) return false;
        }
        if(cnt!=0) return true;
        else if(cnt==0) return false;
        return false;
    }

    static void Lower(){
        int L = Max; int R = sum;
        while(L<R){
            int mid = (L+R)/2;
            if(check(mid)){
                R = mid-1;
            }else {
                L = mid+1;
            }
        }
        answer = L;
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
            sum += arr[i];
        }
        Lower();
        System.out.println(answer);
    }
}
