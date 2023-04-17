package April_Second;

import java.util.*;
import java.io.*;
public class bj_16435_스네이크버드_Silver_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);


        for(int i=0;i<N;i++){
            if(arr[i]<=L) { L++;}
            else break;
        }
        System.out.println(L);
    }
}
