package Algorithm_eighteenth_week_2023_11.gr;
import java.util.*;
import java.io.*;
public class gr_카드정리_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int ans = 0;
        for(int i=0;i<N;i+=2) ans += arr[i+1]-arr[i];
        System.out.println(ans);
    }
}
