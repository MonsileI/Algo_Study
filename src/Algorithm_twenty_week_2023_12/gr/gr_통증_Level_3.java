package Algorithm_twenty_week_2023_12.gr;
import java.util.*;
import java.io.*;
public class gr_통증_Level_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        int ans = 0;
        while(0<N){
            if(N%max==0) {
                ans += N/max;
                N = 0;
                break;
            }
            ans++;
            N -= min;
        }
        if(N==0) System.out.println(ans);
        else System.out.println(-1);
    }
}
