package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_12100_2048_Gold_2 {
    static int N,map[][];
    static int answer;
    static int[]tmp;
    static boolean[]visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        tmp = new int[5];
        visited = new boolean[5];
        perm(0);


    }

    static void calc(){
        int[][]tmpMap = new int[N][N];

        for(int i=0;i<N;i++) for(int j=0;j<N;j++) tmpMap[i][j] = map[i][j];

        int sum = 0;

        for(int d=0;d<5;d++){
            boolean[][]check = new boolean[N][N];
            switch(tmp[d]){
                //위로 올리기
                case 0:
                    for(int j=0;j<N;j++){
                        for(int i=0;i<N;i++){

                        }
                    }
                    break;
                //오른쪽으로 보내버리기
                case 1:

                    break;
                case 2:
                    for(int i=0;i<N;i++){
                        for(int j=N-1;-1<j;j++){

                        }
                    }
                    break;
                case 3:
                    for(int i=0;i<N;i++){
                        for(int j=0;j<N;j++){

                        }
                    }
                    break;
                case 4:
                    for(int i=0;i<N;i++){
                        for(int j=0;j<N;j++){

                        }
                    }
                    break;
            }
        }




    }
    static void perm(int depth){

        if(depth==4){
            calc();
            System.out.println(Arrays.toString(tmp));
            return;
        }

        for(int i=0;i<4;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = i;
                perm(depth+1);
                visited[i] = false;
            }
        }
    }
}
