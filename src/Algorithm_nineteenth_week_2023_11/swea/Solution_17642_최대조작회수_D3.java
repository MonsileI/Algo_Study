package Algorithm_nineteenth_week_2023_11.swea;
import java.util.*;
import java.io.*;
public class Solution_17642_최대조작회수_D3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        StringTokenizer st = null;
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            if(a>b){
                sb.append("#"+t+" "+-1+"\n");
                continue;
            }
            long ans = 0;
            long num = Math.abs(a-b);
            if(num==1) {
                sb.append("#"+t+" "+-1+"\n");
                continue;
            }
            ans = (long)(num/2);
            sb.append("#"+t+" "+ans+"\n");
        }
        System.out.println(sb.toString());
    }
}
