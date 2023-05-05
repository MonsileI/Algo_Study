package April_Fourth;

import java.util.*;
import java.io.*;

public class bj_11403_경로찾기_Silver_1 {

    static int[][] arr;
    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null; N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int [][]result = new int[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++){
                if(arr[i][j]==1) result[i][j] = 1;
                else{
                     if(bfs(i,j)) result[i][j] = 1;
                     else result[i][j] = 0;
                }
            }
        }

        for(int [] i : result) System.out.println(Arrays.toString(i));
    }
    static boolean bfs(int start,int end){

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        boolean[]visited= new boolean[N];
        visited[start] = true;

        while(!q.isEmpty()){

            int now = q.poll();
            if(now==end) return true;

            for(int i=0;i<N;i++){
                if(i==now)continue;
                int num = arr[now][i];
                if(num==1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return false;
    }
}
