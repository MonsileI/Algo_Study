package Algorithm_repeat_week_first_2023_10.gr;

import java.util.*;
import java.io.*;
public class gr_구름스퀘어_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]arr = new int[N][2];
        StringTokenizer st =  null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)-> o1[1]==o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int ans = 1;
        int e = arr[0][1];
        for(int i=1;i<N;i++){
            if(e<arr[i][0]){
                e = arr[i][1];
                ans++;
            }
        }
        System.out.println(ans);
    }
}
