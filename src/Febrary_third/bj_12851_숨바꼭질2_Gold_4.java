package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_12851_숨바꼭질2_Gold_4 {


    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{N,0});
        boolean[]visited = new boolean[100001];
        int answer = 987654321;
        int cnt = 0;
        boolean flag = true;
        while(!q.isEmpty()){

            int[]c = q.poll();
            int loc = c[0];
            int sec = c[1];

            if(sec>answer) continue;

            if(loc==K){
                if(flag){
                    flag = false;
                    answer = sec;
                    cnt++;
                }else if(answer==sec) cnt++;

                continue;
            }
            visited[loc] = true;

            if(loc+1 < 100001){
                if(!visited[loc+1]) q.offer(new int[]{loc+1,sec+1});
            }
            if(-1 < loc-1){
                if(!visited[loc-1]) q.offer(new int[]{loc-1,sec+1});
            }
            if(loc*2 < 100001){
                if(!visited[loc*2]) q.offer(new int[]{loc*2,sec+1});
            }
        }


        System.out.println(answer+"\n"+cnt);


    }
}
