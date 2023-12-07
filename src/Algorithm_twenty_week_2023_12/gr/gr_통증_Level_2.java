package Algorithm_twenty_week_2023_12.gr;
import java.util.*;
import java.io.*;
public class gr_통증_Level_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        int seven = 0;
        while(0<N){
            if(N%7==0){
                seven = N/7;
                break;
            }
            ans++;
            N--;
        }
        ans += seven/2;
        if(seven%2!=0) ans++;
        System.out.println(ans);
    }
}
