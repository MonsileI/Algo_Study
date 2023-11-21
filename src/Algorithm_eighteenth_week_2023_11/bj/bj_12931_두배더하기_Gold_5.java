package Algorithm_eighteenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_12931_두배더하기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int sum = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        int ans = 0;
        while(0!=sum){

            int num = 0;
            for(int i=0;i<N;i++){
                if(arr[i]%2==1){
                    arr[i]--;
                    num++;
                }
            }
            if(num==0){
                for(int i=0;i<N;i++){
                    arr[i] /=2;
                }
                sum /= 2;
                ans++;
            }else{
                sum -= num;
                ans += num;
            }
        }
        System.out.println(ans);
    }
}
