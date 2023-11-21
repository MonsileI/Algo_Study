package Algorithm_eighteenth_week_2023_11.복습;
import java.io.*;
public class bj_5430_AC_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC  = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){

            char[]orders = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.replaceAll("\\[","").replaceAll("\\]","");
            String[]tmp = str.split(",");
            int[]arr = new int[N];
            for(int i=0;i<N;i++)arr[i] = Integer.parseInt(tmp[i]);

            int dNum = 0;
            for(int i=0;i<orders.length;i++) if(orders[i]=='D') dNum++;
            if(dNum>N) {
                sb.append("error\n");
                continue;
            }
            int o = orders.length;
            int L = 0; int R = N-1; int idx = 0;
            for(int i=0;i<o;i++){
                char ch = orders[i];
                if(ch=='D'){
                    if(idx==L){
                        idx++;
                        L++;
                    }else{
                        idx--;
                        R--;
                    }
                }else{
                    if(idx==L)idx = R;
                    else idx = L;
                }
            }
            sb.append("[");
            if(idx==L){
                for(int i=L;i<R+1;i++){
                    if(i==R){
                        sb.append(arr[i]);
                        break;
                    }
                    sb.append(arr[i]+",");
                }
            }else{
                for(int i=R;L-1<i;i--) {
                    if(i==L){
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
