package May_Fifth.pr;

import java.util.*;

public class pr_미로탈출명령어_Level_3 {

    static int[][]move = {{1,0},{0,-1},{0,1},{-1,0}};

    static int R,C,K,N,M;
    static boolean flag;
    static char[]chMove = {'d','l','r','u'};
    static String answer = "";

    public static void main(String[] args) {

        int n = 3; int m =4; int x=2;int y=3;int r=3;int c=1;int k=5;
        x--; y--; r--; c--;//인덱스 조정
        N = n ; M = m ; R =r ; C = c;K = k;

        flag = false;
        dfs(0,x,y,"");

        answer = answer.isEmpty() ? "impossible" : answer;
        System.out.println(answer);

    }
    static void dfs(int depth,int i,int j,String str){

        if(flag || K< depth)return;

        if(i==R & j==C && depth==K){
            flag = true;
            for(int c=0;c<K;c++) answer = str;
            return;
        }

        for(int d=0;d<4;d++){

            int ni = i + move[d][0];
            int nj = j + move[d][1];

            if(ni<0||nj<0||N-1<ni||M-1<nj)continue;

            if(depth+1<=K) dfs(depth+1,ni,nj,str+chMove[d]);

        }
    }
}
