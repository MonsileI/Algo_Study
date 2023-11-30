package Algorithm_nineteenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_1182_부분수열의합_Silver_2 {
    static int N,S,ans;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        for(int i=0;i<N;i++)arr[i] =Integer.parseInt(st.nextToken());
        comb(0,0);
        System.out.println(ans);
    }
    static void comb(int flag,int cnt){
        if(cnt==N){
            if(flag==0) return; //아무것도 선택하지 않은 경우 //초기값인 0
            int sum =0;
            for(int i=0;i<N;i++) if(((1<<i)&flag)>0) sum+=arr[i];
            if(sum==S)ans++;
            return;
        }
        comb(flag,cnt+1);
        flag = (1<<cnt) | flag;
        comb(flag,cnt+1);
    }
}
