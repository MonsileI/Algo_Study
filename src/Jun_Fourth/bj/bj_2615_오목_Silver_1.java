package Jun_Fourth.bj;

import java.util.*;
import java.io.*;
public class bj_2615_오목_Silver_1 {
    static int[][]map;
    static boolean[][]visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        map = new int[19][19];

        for(int i=0;i<19;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<19;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer  = 0;
        int [] loc = new int[2];
        visited = new boolean[19][19];
        OuterLoop:
        for(int i=0;i<19;i++){
            for(int j=0;j<19;j++){
                if(map[i][j]!=0){
                    //가로체크
                    if(garo(i,j)) {
                        loc[0] = i;
                        loc[1] = j;
                        answer = map[i][j];
                        break OuterLoop;
                    }
                    //세로체크
                    if(sero(j,i)){
                        loc[0] = i;
                        loc[1] = j;
                        answer = map[i][j];
                        break OuterLoop;
                    }
                    //대각체크
                    if(degac(i,j)){
                        loc[0] = i;
                        loc[1] = j;
                        answer = map[i][j];
                        break OuterLoop;
                    }
                }
            }
        }
        loc[0]++;loc[1]++;
        System.out.println(answer +"\n"+ loc[0]+" "+loc[1]);

    }
    static boolean degac(int i,int j){

        int dol = map[i][j];

        for(int g=1;g<5;g++){
            int ni = i + g;
            int nj = j + g;
            if(19<ni || 19 <nj) return false;
            if(map[ni][nj]!=dol) return false;
        }
        if(i+5<19 && j+5<19 && map[i+5][j+5]==dol) return false;
        return true;
    }
    static boolean sero(int i,int j){

        int dol = map[i][j];

        for(int g=1;g<5;g++){
            int ni = i + g;
            if(19<ni) return false;
            if(map[ni][j]!=dol) return false;
        }
        if(i+5<19 && map[i+5][j]==dol) return false;
        return true;
    }
    static boolean garo(int i,int j){

        int dol = map[i][j];

        for(int g=1;g<5;g++){
            int nj = j + g;
            if(19<nj) return false;
            if(map[i][nj]!=dol) return false;
        }
        if(j+5<19 && map[i][j+5]==dol) return false;
     return true;
    }

}
