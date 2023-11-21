package Algorithm_eighteenth_week_2023_11.복습;
import java.util.*;
import java.io.*;
public class bj_2565_전깃줄_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]map = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            map[i][0] = a;
            map[i][1] = b;
        }
        Arrays.sort(map,(o1,o2)->-(o1[0]-o2[0]));
        //가장 긴 감소하는 부분수열
        int[]lis = new int[N];
        int max = 0;
        for(int i=0;i<N;i++){
            lis[i] = 1;
            for(int j=0;j<i;j++){
                if(map[i][1]<map[j][1]){
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
            max = Math.max(max,lis[i]);
        }

        System.out.println(N-max);

    }
}
