package Jun_First.bj;

import java.util.*;
import java.io.*;
public class bj_2559_수열_Silver_3 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        int slide = 0;
        int max = 0;
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++) slide += arr[i];
        max =slide;
        for(int i=0;i<N-M;i++) {
            slide -= arr[i];
            slide += arr[i+M];
            max = Math.max(max,slide);
        }
        System.out.println(max);




    }

}
