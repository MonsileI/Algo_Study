package Algorithm_first_week_2023_07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_15650_N과M2_Silver_3 {
    static int N,len;
    static int[]tmp;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        tmp = new int[N];
        sb = new StringBuilder();
        comb(0,0);
        System.out.println(sb.toString());
    }

    static void comb(int depth,int start){

        if(depth==len){
            for(int i=0;i<len;i++) sb.append((tmp[i]+1)+" ");
            sb.append("\n");
            return;
        }

        for(int i=start;i<N;i++){

                tmp[depth] = i;
                comb(depth+1,i+1);

        }
    }

}
