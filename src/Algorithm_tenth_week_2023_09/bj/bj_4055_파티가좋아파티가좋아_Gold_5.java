package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_4055_파티가좋아파티가좋아_Gold_5 {


    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            int[][]arr = new int[N][2];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            int sum = 1;
            Arrays.sort(arr,(o1,o2)-> o1[0]==o2[0] ? o1[1]-o2[1] : o1[0] - o2[0]);
            int start = arr[0][0]; int end = arr[0][1];
            int cnt = 0;
            System.out.println(Arrays.deepToString(arr));
            for(int i=1;i<N;i++){
                int s = arr[i][0];
                int e = arr[i][1];
                if(s==start&&end==e){
                    if(cnt==0) {
                        cnt  = 1;
                        sum++;
                    }else{
                        cnt = 0;
                    }
                }else if(end<=start) {
                    sum++;
                    end = e;
                    start = s;
                }
            }
            sb.append(sum);
        }
        System.out.println(sb.toString()+"\n");
    }
}
