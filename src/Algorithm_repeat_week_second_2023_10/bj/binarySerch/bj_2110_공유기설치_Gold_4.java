package Algorithm_repeat_week_second_2023_10.bj.binarySerch;

import java.util.*;
import java.io.*;
public class bj_2110_공유기설치_Gold_4 {

    static int N,M,arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int L = 1; int R = arr[N-1]-arr[0]+1;
        while(L<R){
            int mid= (L+R)/2;
            //mid라는 최소 거리를 두고 공유기를 놓는다.
            //최소거리로 공유기를 놓아야 할 때, 놓아야 할 공유기가 M보다 크다면check(mid) > M
            //최소 거리를 늘려야 한다. (최소 거리를 찾는게 output)
            if(check(mid)>=M) L = mid+1;
            else R = mid;

        }
        System.out.println(L-1);
    }
    static int check(int mid){
        int cnt = 1;
        int range = arr[0];
        for(int i=1;i<N;i++){
            if(arr[i]-range>=mid){
                cnt++;
                range = arr[i];
            }
        }
        return cnt;
    }
}
