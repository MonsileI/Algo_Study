package Algorithm_thirteenth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_12886_돌그룹_Gold_4 {
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        bfs(a,b,c);
        System.out.println(answer);

    }
    static void bfs(int aa,int bb,int cc){
        if((aa+bb+cc)%3!=0) return;
        boolean[][]visited = new boolean[1501][1501];
        visited[aa][bb] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{aa,bb,cc});
        while(!q.isEmpty()){
            int []cur = q.poll();
            int a = cur[0]; int b = cur[1]; int c = cur[2];
            if(a==b&&b==c){
                answer = 1;
                return;
            }

            if (a != b) {
                int na = a > b ? a - b : a * 2;
                int nb = a > b ? b * 2 : b - a;

                if (!visited[na][nb]) {
                    q.add(new int[]{na, nb, c});
                    visited[na][nb] = true;
                }
            }

            if (a != c) {
                int na = a > c ? a - c : a * 2;
                int nc = a > c ? c * 2 : c - a;

                if (!visited[na][nc]) {
                    q.add(new int[]{na, b, nc});
                    visited[na][nc] = true;
                }
            }

            if (b != c) {
                int nb = b > c ? b - c : b * 2;
                int nc = b > c ? c * 2 : c - b;

                if (!visited[nb][nc]) {
                    q.add(new int[]{a, nb, nc});
                    visited[nb][nc] = true;
                }
            }
        }

    }
}
