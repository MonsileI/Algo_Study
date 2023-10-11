package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_1253_좋다_Gold_4 {
    static int []arr;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int answer = 0;
        for(int i=0;i<N;i++)  if(calc(i))answer++;
        System.out.println(answer);

    }
    static boolean calc(int idx){

        int L = 0; int R = N-1;
        int num = arr[idx];
        while(true){
            if(idx==L) L++;
            if(idx==R) R--;
            if(L>=R)break;
            int sum = arr[L]+arr[R];
            if(sum==num) return true;

            if(sum<num)L++;
            else R--;
        }
        return false;
    }
}
