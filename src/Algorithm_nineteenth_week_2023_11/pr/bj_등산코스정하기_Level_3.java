package Algorithm_nineteenth_week_2023_11.pr;

import java.util.*;
public class bj_등산코스정하기_Level_3 {

    static class Node implements Comparable<Node>{
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    static List<List<Node>> list;
    static int N;
    static Map<Integer,Integer> sMap;
    static Map<Integer,Integer> gMap;
    static int INF = 987654321;
    static int ans = INF;
    static int[] solution(int n, int[][] paths, int[] gates, int[] summits){
        //산봉우리에서 게이트까지 가는 dijk, 이미 dist가 더 작으면 안함
        N = n;
        list = new ArrayList<>();
        sMap = new HashMap<>();
        gMap = new HashMap<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<paths.length;i++){
            int a = paths[i][0]; int b = paths[i][1]; int w = paths[i][2];
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        for(int i=0;i<summits.length;i++) sMap.put(summits[i],0);
        for(int i=0;i<gates.length;i++) gMap.put(gates[i],0);
        int []answer = {0,0};
        for(int i=0;i<summits.length;i++){
            int s = summits[i];
            for(int j=0;j<gates.length;j++){
                int g= gates[j];
                int num = djik(s,g);
                System.out.println(g+" "+s+" "+num);
                if(num<ans){
                    ans = num;
                    answer[0] = s;
                    answer[1] = num;
                }
            }
        }
        return answer;
    }
    static int djik(int s,int g){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[]dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[s] = 0;
        pq.offer(new Node(s,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.weight>ans) return INF;
            if(now.to==g) return now.weight;
            for(Node next : list.get(now.to)){
                if(gMap.containsKey(next.to)&&next.to!=g) continue;
                if(sMap.containsKey(next.to)&&next.to!=s) continue;
                int weight = Math.max(now.weight,next.weight);
                    if(dist[next.to]>weight){
                        dist[next.to] = weight;
                        pq.offer(new Node(next.to,weight));
                    }
                }
            }
        return INF;
    }

    public static void main(String[] args) {
        int n =6;
        int[][]paths = {{1, 2, 3},{2, 3, 5},{2, 4, 2},{2, 5, 4},{3, 4, 4},{4, 5, 3},{4, 6, 1},{5, 6, 1}};
        int []gates = {1,3};
        int []summits = {5};
        System.out.println(Arrays.toString(solution(n,paths,gates,summits)));
    }
}
