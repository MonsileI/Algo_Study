package Jun_First.bj;

import java.util.*;
import java.io.*;
public class bj_12847_꿀알바_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        long[]arr = new long[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Long.parseLong(st.nextToken());
        long max = 0;
        for(int i=0;i<M;i++) max += arr[i];

        long tmp = max;

        for(int i=0;i<N-M;i++){
            tmp -= arr[i];
            tmp += arr[M+i];
            max = Math.max(max,tmp);
        }
        System.out.println(max);
    }
}
