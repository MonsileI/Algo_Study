package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_7576_토마토_Gold_5 {
    static int N,M;
    static int[][]map;
    static Queue<int[]> q;
    static int zero;

    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        q = new ArrayDeque<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){

                    q.offer(new int[]{i,j});
                }else if(map[i][j]==0) zero++;

            }
        }
        int answer = 0;
        if(zero!=0) {
            while (true) {
                answer++;

                boolean flag = false;
                int size = q.size();
                //퍼뜨리기
                for (int t = 0; t < size; t++) {
                    int[] c = q.poll();
                    int i = c[0];
                    int j = c[1];
                    for (int d = 0; d < 4; d++) {
                        int ni = i + move[d][0];
                        int nj = j + move[d][1];
                        if (ni < 0 || nj < 0 || N - 1 < ni || M - 1 < nj) continue;
                        if (map[ni][nj] == 0) {
                            flag = true;
                            map[ni][nj] = 1;
                            zero--;
                            q.offer(new int[]{ni, nj});
                        }
                    }
                }
                if (zero == 0) break;
                if (!flag&&zero!=0) {
                        answer = -1;
                        break;
                }
            }
        }
        System.out.println(answer);
    }
}
