package Algorithm_eighteenth_week_2023_11.복습;
import java.util.*;
import java.io.*;

public class bj_2110_공유기설치_Gold_4 {
    static int N,M,arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int L = 0; int R = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            R = Math.max(R,arr[i]);
        }
        Arrays.sort(arr);

        while(L<R){
            int mid = (L+R)/2;
            if(check(mid)<M) R = mid;
            else L = mid+1;
        }
        System.out.println(L);

    }
    static int check(int mid){
        int tmp = 1;
        int before = arr[0];
        for(int i=1;i<N;i++){
            if(arr[i]-before > mid){
                before = arr[i];
                tmp++;
            }
        }
        return tmp;
    }
}
