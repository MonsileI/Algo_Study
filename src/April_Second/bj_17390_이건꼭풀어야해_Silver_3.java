package April_Second;

import java.util.*;
import java.io.*;
public class bj_17390_이건꼭풀어야해_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int sum = 0;
        for(int i=0;i<N;i++) {
            sum += arr[i];
            arr[i] = sum;
        }
        //(1 , 3 , 6 , 10 , 15)

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine()," ");
            int f = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken())-1;
            int result = 0;
            if(f!=0) sb.append(arr[s] - arr[f-1]).append("\n");
            else sb.append(arr[s]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
