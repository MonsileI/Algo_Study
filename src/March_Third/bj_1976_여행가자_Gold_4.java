package March_Third;

import java.util.*;
import java.io.*;
public class bj_1976_여행가자_Gold_4 {

    static int N;
    static List<List<Integer>> list = new ArrayList<>();

    static int [] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) list.add(new ArrayList<>());
        visit = new int[M];
        StringTokenizer st = null;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int to = Integer.parseInt(st.nextToken());
                if(to==1){
                    list.get(i).add(j);
                }
            }
        }
        st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<M;i++) visit[i] = Integer.parseInt(st.nextToken())-1;
        String answer = "YES";
        for(int i=0;i<M-1;i++){

            boolean check = bfs(visit[i],visit[i+1]);
            if(!check) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);

    }

    static boolean bfs(int start, int end){

        if(start==end && list.get(start).size()==0) return false;

        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);

        boolean[]visited = new boolean[N];

        visited[start] = true;

        while(!q.isEmpty()){

            int now = q.poll();

            if(now==end) return true;

            for(Integer next : list.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        return false;
    }
}
