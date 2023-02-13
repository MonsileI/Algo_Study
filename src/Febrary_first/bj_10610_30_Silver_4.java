package Febrary_first;

import java.util.*;
import java.io.*;
public class bj_10610_30_Silver_4 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String tmp = String.valueOf(num);
        int size = tmp.length();
        int[]arr = new int[size];

        String answer = "";

        for(int i=0;i<size;i++) arr[i] = Integer.parseInt(tmp.charAt(i)+"");

        Arrays.sort(arr);
        int n = 0;
        for(int i=size-1;i>-1;i--) {
            n+= arr[i];
            answer += arr[i];
        }


        for(int i=size-1;i>-1;i--) {
            if(n%30==0) break;
            if(i==0){
                answer = "-1";
                break;
            }
            answer = answer.substring(0,i);
        }
        int ans = 0;
        if(answer.isEmpty()) ans = -1;
        else ans = Integer.parseInt(answer);

        System.out.println(ans % 30 == 0 ? ans : -1);
    }
}
