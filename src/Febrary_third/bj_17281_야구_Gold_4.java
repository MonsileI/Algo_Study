package Febrary_third;

import java.util.*;
import java.io.*;

public class bj_17281_야구_Gold_4 {

    static int N;
    static int answer = 0;
    static int [][] scores;
    static int [] tmp;
    static boolean[]visited;
    static void dfs(int depth){

        if(depth==9){
            int idx = -1;
            int out = 0;
            int score = 0;


            for(int i=0;i<N;i++){
                int []man = new int [4]; // 1 2 3 4(홈)
                innerLoop:
                while(true){
                    idx++;
                    if(idx==9) idx=0;
                    int res = scores[i][tmp[idx]];
                   //아웃
                   if(res==0) out++;
                   else if(res==4){
                   //홈런
                        score++;
                        for(int j=1;j<4;j++) {
                            score += man[j];
                            man[j] = 0;
                        }
                    }else{
                       //다 res만큼 하고 싶은거임! 0부터 시작인거임!
                       //1루수부터 3루수까지 res만큼 옮겨준다.
                       for(int j=3;j>0;j--){
                           if(man[j]!=0){
                               if(j+res>=4) {
                                   score++;
                                   man[j] = 0;
                               }else{
                                   man[j+res] = 1;
                                   man[j] = 0;
                               }
                           }
                       }
                       man[res] = 1;
                    }
                   if(out==3) {
                        out = 0;
                        break innerLoop;
                   }
               }
            }
            answer = Math.max(answer,score);
            return;
        }

        for(int i=0;i<9;i++){
            if(i==3)continue;
            if(!visited[i]){
                visited[i] = true;
                tmp[i] = depth;
                dfs(depth+1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st= null;
        scores = new int[N][9];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<9;j++) scores[i][j] = Integer.parseInt(st.nextToken());
        }
        //타순 선정 //123456789번 애
        tmp = new int[9];
        visited = new boolean[9];
        visited[3] = true;
        tmp[3] = 0;

        dfs(1);

        System.out.println(answer);



    }
}
