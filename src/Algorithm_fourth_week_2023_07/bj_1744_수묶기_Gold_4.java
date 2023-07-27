package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_1744_수묶기_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr=  new int[N];
        int tmp = 0;
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            tmp += arr[i];
        }
        Arrays.sort(arr);
        int max = tmp;
        int sum = 0;
        int idx = 0;
        for(int i=0;i<N-1;i += 2){
            if(arr[i]<=0 && arr[i+1]<=0){
                sum += (arr[i]*arr[i+1]);
                idx = i + 2;
            }else if(arr[i]<=0 && 0<arr[i+1]){
                sum += arr[i];
                idx = i+1;
                break;
            }else if(0<arr[i]){
                idx = i;
                break;
            }
        }

        for(int i=N-1;idx<=i;i -=2 ){
            if(i==idx){ sum += arr[i]; break;}
            if(arr[i-1]==1&&arr[i]!=1) {
                sum += arr[i];
                sum++;
                continue;
            }else if(arr[i-1]==1&&arr[i]==1){
                sum += 2;
                continue;
            }
            sum += arr[i] * arr[i-1];
        }
        max = Math.max(sum,max);
        System.out.println(max);
    }
}
