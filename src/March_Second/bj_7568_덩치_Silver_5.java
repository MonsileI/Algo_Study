package March_Second;

import java.util.*;
import java.io.*;
public class bj_7568_덩치_Silver_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]num = new int[N][2];
        StringTokenizer st= null;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            num[i][0] = Integer.parseInt(st.nextToken());
            num[i][1] = Integer.parseInt(st.nextToken());
        }


        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            int idx = 1;
            int first = num[i][0]; int second = num[i][1];
            for(int j=0;j<N;j++){
                if(i==j) continue;
                if(first<num[j][0] && second<num[j][1]) idx++;
            }
            sb.append(idx+" ");
        }

        System.out.println(sb.toString());
    }
}
