package Algorithm_sixteenth_week_2023_10.bj;
import java.io.*;
public class bj_5430_AC_Gold_5 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            char []order = br.readLine().toCharArray();
            int D = 0;
            for(int i=0;i<order.length;i++) if(order[i]=='D') D++;
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            if(D>N){
                sb.append("error\n");
                continue;
            }
            str =str.substring(1,str.length()-1).replaceAll(","," ");
            String[]tmp = str.split(" ");
            int[]arr = new int[N];
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(tmp[i]);
            int L  =0; int R = N-1;
            int idx = 0;
            for(int i=0;i<order.length;i++){
                char ch = order[i];
                if(ch=='R'){
                    if(idx==L) idx = R;
                    else idx = L;
                }else{
                    if(idx==L){
                        L++;
                        idx++;
                    }
                    else{
                        R--;
                        idx--;
                    }

                }
            }
            sb.append("[");
            if(idx==L){
                for(int i=L;i<=R;i++) {
                    if(i==R) {
                        sb.append(arr[i]);
                        break;
                    }
                    sb.append(arr[i]+",");
                }
            }else{
                for(int i=R;L<=i;i--) {
                    if(i==L) {
                        sb.append(arr[i]);
                        break;
                    }
                    sb.append(arr[i]+",");
                }
            }
            sb.append("]\n");
        }
        System.out.println(sb.toString());
    }
}
