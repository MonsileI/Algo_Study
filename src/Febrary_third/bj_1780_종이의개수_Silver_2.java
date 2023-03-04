package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_1780_종이의개수_Silver_2{

    static int N;
    static int[][]map;
    static int [] check;

    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st = null;
        check = new int[3]; //인덱스로 조정하자

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //맵을 9등분 해야됨 (4등분 아님)

        int size = N;

        dfs(size,0,0,map[0][0]); //시작지점

        System.out.println(check[0]+"\n"+check[1]+"\n"+check[2]);

    }


    static void dfs(int size,int y,int x,int shape){

        if(size==0) {
            check[shape+1]++;
            return;
        }
        boolean flag = false;

        innerLoop:
        for(int i=y;i<size+y;i++){
            for(int j=x;j<size+x;j++){
                if(map[i][j]!=shape){
                    flag = true;
                     break innerLoop;
                }
            }
        }


        if(!flag){
            check[shape+1]++;
            return;
        }else{
            //1라인
            dfs(size/3,y,x,map[y][x]);
            dfs(size/3,y,x+(size/3),map[y][x+(size/3)]);
            dfs(size/3,y,x+(size/3)*2,map[y][x+(size/3)*2]);
            //2라인
            dfs(size/3,y+(size/3),x,map[y+(size/3)][x]);
            dfs(size/3,y+(size/3),x+(size/3),map[y+(size/3)][x+(size/3)]);
            dfs(size/3,y+(size/3),x+(size/3)*2,map[y+(size/3)][x+(size/3)*2]);
            //3라인
            dfs(size/3,y+(size/3)*2,x,map[y+(size/3)*2][x]);
            dfs(size/3,y+(size/3)*2,x+(size/3)  ,map[y+(size/3)*2][x+(size/3)]);
            dfs(size/3,y+(size/3)*2,x+(size/3)*2,map[y+(size/3)*2][x+(size/3)*2]);

        }
    }
}
