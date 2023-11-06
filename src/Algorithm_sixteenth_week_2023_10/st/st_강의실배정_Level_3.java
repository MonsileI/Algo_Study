package Algorithm_sixteenth_week_2023_10.st;
import java.util.*;
import java.io.*;
public class st_강의실배정_Level_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  =Integer.parseInt(br.readLine());
        int[][]arr =new int[N][2];
        StringTokenizer st =null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)-> o1[1]-o2[1]);
        int ans = 1;
        int end = arr[0][1];
        for(int i=1;i<N;i++){
            if(end<=arr[i][0]){
                ans++;
                end = arr[i][1];
            }
        }
        System.out.println(ans);
    }
}
