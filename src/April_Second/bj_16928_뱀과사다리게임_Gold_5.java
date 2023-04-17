package April_Second;

import java.util.*;
import java.io.*;
public class bj_16928_뱀과사다리게임_Gold_5 {

    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int sadari = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        int[][]sadariArr = new int[sadari][2];
        int[][]snakeArr = new int[snake][2];

        for(int i=0;i<sadari;i++){
            st=  new StringTokenizer(br.readLine()," ");
            sadariArr[i][0] = Integer.parseInt(st.nextToken());
            sadariArr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<snake;i++){
            st=  new StringTokenizer(br.readLine()," ");
            snakeArr[i][0] = Integer.parseInt(st.nextToken());
            snakeArr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[]visited = new int[101];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1,0});

        while(!q.isEmpty()){

            boolean flag = false;

            int []c = q.poll();
            int loc = c[0];
            int cnt = c[1];


            for(int i=0;i<sadari;i++) if(sadariArr[i][0]==loc) loc = sadariArr[i][1];
            for(int i=0;i<snake;i++) if(snakeArr[i][0] == loc) loc = snakeArr[i][1];


            if(loc==100) {
                visited[loc] = cnt;
                break;
            }

            for(int i=1;i<7;i++){
                int newLoc = loc + i;
                if(newLoc < 101) {
                    if(visited[newLoc]==0) {
                        visited[newLoc] = cnt;
                        q.offer(new int[]{newLoc, cnt + 1});
                    }
                }

            }

        }


        System.out.println(visited[100]);






    }
}
