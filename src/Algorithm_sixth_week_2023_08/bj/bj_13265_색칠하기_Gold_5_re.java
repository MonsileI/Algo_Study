package Algorithm_sixth_week_2023_08.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj_13265_색칠하기_Gold_5_re {

    static boolean[] visited;
    static boolean[] color;
    static int N;
    static List<List<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            visited = new boolean[N + 1];
            color = new boolean[N + 1];
            list = new ArrayList<>();
            for (int i = 0; i < N + 1; i++) list.add(new ArrayList<>());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list.get(from).add(to);
                list.get(to).add(from);

            }
            int cnt = 0;
            boolean flag = true;
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i < N + 1; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                color[i] = true;
                q.offer(i);
                while(!q.isEmpty()){
                    int c = q.poll();
                    for(int n : list.get(c)){
                        if(!visited[n]){
                            visited[n] = true;
                            color[n] = !color[c];
                            q.offer(n);
                        }
                    }
                }
            }
            OuterLoop:
            for(int i=1;i<N+1;i++){
                for(int n : list.get(i)){
                    if(color[n]==color[i]){
                        flag= false;
                        sb.append("impossible"+"\n");
                        break OuterLoop;
                    }
                }
            }
            if (flag) sb.append("possible" + "\n");

        }
        System.out.println(sb.toString());
    }
}
