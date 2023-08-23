package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_14889_스타트와링크_Silver_2 {
    static int N;
    static int [][]arr;
    static int []tmp;
    static int answer = 987654321;
    static int size;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        size = N/2;
        tmp = new int[size];
        comb(0,0);
        System.out.println(answer);
    }
    static void calc(){
        int []stmp = new int[size];
        int idx = 0;
        int sIdx = 0;
        for(int i=0;i<N;i++) {
            if(size-1<idx) stmp[sIdx++] = i;
            else if(tmp[idx]!=i) {
                stmp[sIdx++] = i;
            }else {
                idx++;
            }
        }
        int f = 0; int s = 0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i==j) continue;
                f += arr[tmp[i]][tmp[j]];
                s += arr[stmp[i]][stmp[j]];
            }
        }

        answer = Math.min(answer,Math.abs(f-s));

    }

    static void comb(int depth,int start){

        if(depth==size){
            calc();
            return;
        }

        for(int i=start;i<N;i++){
            tmp[depth] = i;
            comb(depth+1,i+1);
        }
    }

}
