package Algorithm_seventeenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_1280_부분수열의2_Gold_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int L = 0; int R = 0;
        int ans = 0;
        int sum = arr[L];
        while(true){
            if(sum<=M){
                if(sum==M)ans++;
                if(R==N)break;
                sum += arr[R++];
            }else{
                sum -= arr[L++];
            }
        }
        System.out.println(ans);
    }
}
