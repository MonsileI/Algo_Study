package Algorithm_fifth_week_2023_07.bj;

import java.util.*;
import java.io.*;
public class bj_1058_친구_Silver_1 {
    static int N;
    static List<List<Integer>> list;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<N;i++) list.add(new ArrayList<>());
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                char ch = str.charAt(j);
                if(ch=='Y') {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        for(int i=0;i<N;i++) answer = Math.max(answer,bfs(i));

        System.out.println(answer);
    }
    static int bfs(int num){
        int cnt = 0;
        Queue<int[]> q=  new ArrayDeque<>();
        boolean[]visited = new boolean[N];
        visited[num] = true;
        q.offer(new int[]{num,0});
        while(!q.isEmpty()){
            int [] c = q.poll();
            int now = c[0];
            int len = c[1];
            if(1<len) continue;
            for(int next : list.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    cnt++;
                    q.offer(new int[]{next,len+1});
                }
            }
        }
        return cnt;
    }
}
