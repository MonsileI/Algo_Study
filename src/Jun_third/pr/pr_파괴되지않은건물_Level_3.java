package Jun_third.pr;

import java.util.*;
public class pr_파괴되지않은건물_Level_3 {
    public static void main(String[] args) {
        int[][]map = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][]skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        int answer = 0;
        int N = map.length; int M = map[0].length;
        int[][]sumMap = new int[N+1][M+1];
        int size = skill.length;

        for(int i=0;i<size;i++){

            int act = skill[i][0];
            int fi = skill[i][0] ;
            int fj = skill[i][1] ;
            int si = skill[i][2] ;
            int sj = skill[i][3] ;
            int degree = skill[i][4];

            if(act==1){
                sumMap[fi][fj] -= degree;
                sumMap[fi][sj] += degree;
                sumMap[si][fj] += degree;
                sumMap[si][sj] -= degree;
            }else{
                sumMap[fi][fj] += degree;
                sumMap[fi][sj] -= degree;
                sumMap[si][fj] -= degree;
                sumMap[si][sj] += degree;
            }
        }

        for(int i=1;i<N+1;i++){
            int sum = 0;
            for(int j=1;j<M+1;j++){
                sum += sumMap[i][j];
                sumMap[i][j] = sum;
            }
        }
        for(int i=1;i<M+1;i++){
            int sum=0;
            for(int j=1;j<N+1;j++){
                sum+= sumMap[j][i];
                sumMap[j][i] = sum;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(0<sumMap[i+1][j+1] + map[i][j]) answer++;
            }
        }

        System.out.println(answer);

    }
}
