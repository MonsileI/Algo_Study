package Algorithm_thirteenth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_16869_뮤탈리스크_Gold_4 {
    static int N;
    static int answer;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        //9 3 1
        if(N==1){
            answer = arr[0]/9;
            if(arr[0]%9!=0) answer++;
        }else{
            Arrays.sort(arr);
            answer = Integer.MAX_VALUE;
            if(N==2) dfs(arr[0],arr[1],0,0);
            else dfs(arr[0],arr[1],arr[2],0);
        }
        System.out.println(answer);
    }
    static void dfs(int a,int b,int c,int depth){
        //경우의 수 : 012 021 102 120 210 201
        if(answer<=depth) return;
        if(a<1 && b<1 && c<1){
            answer = depth;
            return;
        }

        if(a<0){
            if(b<0){
                dfs(a,b,c-9,depth+1);
            }
            else if(c<0){
                dfs(a,b-9,c,depth+1);
            }
            else{
                dfs(a,b-9,c-3,depth+1);
                dfs(a,b-3,c-9,depth+1);
            }
        }else if(b<0){
            if(a<0){
                dfs(a,b,c-9,depth+1);
            }
            else if(c<0){
                dfs(a-9,b,c,depth+1);
            }
            else{
                dfs(a-9,b,c-3,depth+1);
                dfs(a-3,b,c-9,depth+1);
            }
        }else if(c<0){
            if(a<0){
                dfs(a,b-9,c,depth+1);
            }else if(b<0){
                dfs(a-9,b,c,depth+1);
            }
             else{
                dfs(a-9,b-3,c,depth+1);
                dfs(a-3,b-9,c,depth+1);

            }
        }else{
            dfs(a-9,b-3,c-1,depth+1);
            dfs(a-9,b-1,c-3,depth+1);
            dfs(a-3,b-9,c-1,depth+1);
            dfs(a-1,b-9,c-3,depth+1);
            dfs(a-1,b-3,c-9,depth+1);
            dfs(a-3,b-1,c-9,depth+1);

        }

    }
}
