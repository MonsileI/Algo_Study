package Algorithmeighteenth_week_2023_11.복습;
import java.util.*;
import java.io.*;
public class bj_12931_두배더하기_Gold_5 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        int[]arr = new int[N];
        int sum = 0; int ans = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        while(0<sum){
            int odd = 0;
            for(int i=0;i<N;i++){
                if(arr[i]%2==1) {
                    odd++;
                    arr[i]--;
                }
            }
            if(odd==0){
                for(int i=0;i<N;i++) arr[i] /= 2;
                ans++;
                sum /= 2;
            }else{
                ans += odd;
                sum -= odd;
            }
        }
        System.out.println(ans);
    }
}
