package March_Second;

import java.util.*;
import java.io.*;
public class bj_2606_바이러스_Silver_3 {
    static int N;
    static List<List<Integer>> list;
    static boolean[]visited;

    static int answer = 0;

    public static void main(String[] args) throws Exception{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());

        StringTokenizer st = null;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }

        visited = new boolean[N+1];

        bfs(1);

        System.out.println(answer);
    }

    static void bfs(int start){

        visited[start] = true;

        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);

        while(!q.isEmpty()){

            int c = q.poll();

            for(Integer nextNum : list.get(c)){

                if(!visited[nextNum]){
                    visited[nextNum] = true;
                    answer++;
                    q.offer(nextNum);

                }

            }

        }

    }


}
