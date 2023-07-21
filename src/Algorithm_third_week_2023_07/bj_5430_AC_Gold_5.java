package Algorithm_third_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_5430_AC_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){

            String str = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            arrStr = arrStr.substring(1,arrStr.length()-1);
            int[]arr = new int[N];
            String tmp[] = arrStr.split("\\,");
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(tmp[i]);
            int size = str.length();
            int start = 0;
            int end = N-1;
            int idx = 0;
            boolean flag = true;
            if(N==0&&!str.contains("D")) {
                sb.append("[]").append("\n");
                flag= false;
            }
            else{
                for(int i=0;i<size;i++){
                    char ch = str.charAt(i);
                    if(ch=='R'){
                        if(idx==start) idx = end;
                        else idx = start;
                    }else{
                        if(idx==start){
                            start++;
                            idx = start;
                        }else{
                            end--;
                            idx = end;
                        }
                    }
                    if(idx<0||N-1<idx) {
                        if(i==size-1 && ch!='D') sb.append("[]").append("\n");
                        else sb.append("error").append("\n");
                        flag = false;
                        break;
                    }
                }
            }

            if(!flag) continue;
            else{
                sb.append("[");
                if(idx==start){
                    for(int i=idx;i<=end;i++){
                        if(i==end) sb.append(arr[i]).append("]").append("\n");
                        else sb.append(arr[i]).append(",");

                    }
                }else{
                    for(int i=end;start<=i;i--){
                        if(i==start) sb.append(arr[i]).append("]").append("\n");
                        else sb.append(arr[i]).append(",");

                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
