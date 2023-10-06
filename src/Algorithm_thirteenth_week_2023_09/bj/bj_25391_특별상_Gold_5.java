package Algorithm_thirteenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_25391_특별상_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken()); //특별상
        int b = Integer.parseInt(st.nextToken()); //우수상
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)-> -(o1[1] -o2[1]));
        long answer = 0;
        for(int i=0;i<b;i++) {
            answer += arr[i][0];
        }
        int[]check = new int[N-b];
        int idx = 0;
        for(int i=b;i<N;i++) check[idx++] = arr[i][0];

        Arrays.sort(check);
        idx = check.length-1;
        while(0<a){
            answer += check[idx--];
            a--;
        }
        System.out.println(answer);

    }
}
