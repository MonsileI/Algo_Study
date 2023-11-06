package Algorithm_sixteenth_week_2023_10.복습;
import java.util.*;
import java.io.*;
public class bj_1946_신입사원_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =null;
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[][]arr = new int[N][2];
            for(int i=0;i<N;i++){
                st =new StringTokenizer(br.readLine()," ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            //성적
            Arrays.sort(arr,(o1,o2)-> o1[1]-o2[1]);
            int min = arr[0][0];
            int ans = 0;
            for(int i=0;i<N;i++){
                if(arr[i][0]>min) ans++;
                min = Math.min(min,arr[i][0]);
            }
            sb.append(N-ans+"\n");
        }
        System.out.println(sb.toString());
    }
}
