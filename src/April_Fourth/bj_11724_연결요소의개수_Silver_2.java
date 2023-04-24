package April_Fourth;

import java.util.*;
import java.io.*;
public class bj_11724_연결요소의개수_Silver_2 {
    static int N,M;
    static List<List<Integer>> list = new ArrayList<>();
    static int answer = 0;

    static Queue<Integer> q = new ArrayDeque<>();

    static boolean [] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        visited = new boolean[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to); list.get(to).add(from);
        }


        for(int i=1;i<N+1;i++){
            if(!visited[i]){
                answer++;
                bfs(i);
            }
        }
        System.out.println(answer);
    }
    static void bfs(int idx){

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(idx);

        while(!q.isEmpty()){
            int num = q.poll();
            for(int a : list.get(num)){
                if(!visited[a]){
                    visited[a] = true;
                    q.offer(a);
                }
            }
        }
    }
}