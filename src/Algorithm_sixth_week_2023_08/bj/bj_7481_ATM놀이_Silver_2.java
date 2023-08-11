package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_7481_ATM놀이_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int[]arr = new int[2];
            arr[0] = f; arr[1] = s;
            int max = Math.max(f,s); int min = Math.min(f,s);
            int maxCnt = 0; int minCnt = 0;
            boolean[]po = new boolean[max];
            boolean flag = true;
            while(0<g){
                int mod = g%max;
                if(po[mod]) {
                    sb.append("Impossible\n");
                    flag= false;
                    break;
                }
                if(mod==0) {
                    maxCnt += g/max;
                    break;
                }else{
                    g -= min;
                    minCnt++;
                    po[mod] = true;
                }
            }
            if(!flag) continue;
            if(g<0) {
                sb.append("Impossible\n");
                continue;
            }
            if(max==f) sb.append(maxCnt+" "+minCnt+"\n");
            else sb.append(minCnt+" "+maxCnt+"\n");
        }
        System.out.println(sb.toString());
    }
}
