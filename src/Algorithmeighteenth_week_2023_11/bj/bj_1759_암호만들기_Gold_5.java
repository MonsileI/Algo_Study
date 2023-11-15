package Algorithmeighteenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_1759_암호만들기_Gold_5 {
    static int N,M;
    static char[]arr;
    static char[]tmp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        arr = new char[M];
        tmp = new char[N];
        int idx = 0;
        for(int i=0;i<M*2;i+=2) arr[idx++] = str.charAt(i);
        Arrays.sort(arr);
        comb(0,0);
        System.out.println(sb.toString());
    }

    static boolean check(){
        int a=0;
        for(int i=0;i<N;i++){
            if(tmp[i]=='a'||tmp[i]=='e'||tmp[i]=='i'||tmp[i]=='o'||tmp[i]=='u')a++;
        }
        if(a<1) return false;
        else if(N-a<2) return false;

        return true;
    }
    static void comb(int depth,int start){
        if(depth==N){

            if(!check()) return;

            for(int i=0;i<N;i++){
                sb.append(tmp[i]);
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<M;i++){
            tmp[depth] = arr[i];
            comb(depth+1,i+1);
        }
    }
}
