package Febrary_third;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj_9205_맥주마시면서걸어가기_Gold_5 {

    static int n;
    static int[] home;
    static int[][] shop;
    static int[] goal;
    static StringBuilder sb = new StringBuilder();;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st=  null;


        for(int t=0;t<TC;t++){
            //=============================인풋=========================
            n = Integer.parseInt(br.readLine());

            st= new StringTokenizer(br.readLine()," ");
            home = new int[2];
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());

            shop = new int[n][2];
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                shop[i][0] = Integer.parseInt(st.nextToken());
                shop[i][1] = Integer.parseInt(st.nextToken());
            }
            st= new StringTokenizer(br.readLine()," ");
            goal = new int[2];
            goal[0] = Integer.parseInt(st.nextToken());
            goal[1] = Integer.parseInt(st.nextToken());

            // ============================================================
            bfs();
        }
        System.out.println(sb.toString());
    }
    static void bfs(){

        Queue<int[]> q  = new ArrayDeque<>();
        int y = home[0];
        int x = home[1];
        int gi = goal[0];
        int gj = goal[1];

        boolean[]visited = new boolean[n];

        q.offer(new int[]{y,x});

        while(!q.isEmpty()){

            int[]c = q.poll();
            int i = c[0];
            int j = c[1];

            if((Math.abs(i-gi) + Math.abs(j-gj)) <= 1000){
                sb.append("happy").append("\n");
                return;
            }
            for(int d=0;d<n;d++){


                if(!visited[d]){

                    int ni = shop[d][0];
                    int nj = shop[d][1];

                    if((Math.abs(i-ni) + Math.abs(j-nj)) <= 1000){
                        visited[d] = true;
                        q.offer(new int[]{ni,nj,1000});
                    }
                }
            }
        }

        sb.append("sad").append("\n");
        return;
    }
}
