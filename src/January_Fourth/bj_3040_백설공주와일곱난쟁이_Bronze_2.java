package January_Fourth;

import java.util.*;
import java.io.*;
public class bj_3040_백설공주와일곱난쟁이_Bronze_2 {
    static int arr[],tmp[];
    static boolean flag;
    static int sum;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        sum = 0;
        sb = new StringBuilder();
        for(int i=0;i<9;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        tmp = new int[2];
        flag = false;
        comb(0,0);
        System.out.println(sb.toString());
    }
    static void comb(int depth, int start){
        if(flag) return;
        if(depth==2){
            int minus = arr[tmp[0]] + arr[tmp[1]];
            if(sum-minus==100){
                flag = true;
                for(int i=0;i<9;i++){
                    if(i==tmp[0]||i==tmp[1]) continue;
                    sb.append(arr[i]).append("\n");
                }

            }
            return;
        }

        for(int i=start;i<9;i++){
            tmp[depth] = i;
            comb(depth+1,i+1);
        }
    }
}
