package March_Second;

import java.util.*;
import java.io.*;
public class bj_2961_도영이가만맛있는음식_Silver_2 {
    static int[]a;
    static int[]b;
    static int N;
    static int answer;
    static int[]tmp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        a = new int[N];
        b = new int[N];

        answer = 987654321;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        comb(0,0,1,0);
        if(N==1) answer = Math.abs(a[0]-b[0]);
        System.out.println(answer);
    }

    static void comb(int depth,int start,int first,int second){

        if(depth==N){
           if(start !=0 ) answer = Math.min(answer,Math.abs(first-second));
           return;
        }

        comb(depth+1,start+1,first*a[start],second+b[start]);
        comb(depth+1,start,first,second);




    }
}
