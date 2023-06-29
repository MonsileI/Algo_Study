package January_Fourth;

import java.util.*;
import java.io.*;
public class bj_26091_현대모비스_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int[]arr =new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int answer = 0;
        int L = 0; int R = N-1;
        while(L<R){
            int sum = arr[L] + arr[R];
            if(M<=sum) {
                answer++;
                L++;
                R--;
            }else{
                L++;
            }
        }
        System.out.println(answer);
    }
}
