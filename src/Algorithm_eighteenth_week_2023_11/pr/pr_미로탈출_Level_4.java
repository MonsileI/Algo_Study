package Algorithm_eighteenth_week_2023_11.pr;
import java.util.*;
public class pr_미로탈출_Level_4 {

    static class Node implements Comparable<Node>{
        int to; int weight; boolean flag; boolean[]visited;

        public Node(int to, int weight,boolean flag,boolean[]visited) {
            this.to = to;
            this.weight = weight;
            this.flag = flag;
            this.visited = visited;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static List<List<Node>> listFirst;
    static List<List<Node>> listSecond;
    static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int N = n;
        listFirst = new ArrayList<>();
        listSecond = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>(); //트랩을 위한 맵
        for(int i=0;i<traps.length;i++) map.put(traps[i],i);
        for(int i=0;i<N+1;i++){
            listFirst.add(new ArrayList<>());
            listSecond.add(new ArrayList<>());
        }
        int M = roads.length;
        for(int i=0;i<M;i++){
            int a = roads[i][0];
            int b = roads[i][1];
            int w = roads[i][2];
            listFirst.get(a).add(new Node(b,w,true,new boolean[traps.length]));
            listSecond.get(b).add(new Node(a,w,true, new boolean[traps.length])); //여기서 flag는 큰 의미가 없을듯?
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0,true,new boolean[traps.length])); //처음엔 정상 상태
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.to==end) return now.weight;
            boolean flag = now.flag;
            if(map.containsKey(now.to)) {
                if(!now.visited[map.get(now.to)]){
                    now.visited[map.get(now.to)] = true;
                    flag = !flag;
                }else flag = true;

            }
            //정상
            if(flag){
                for(Node next : listFirst.get(now.to))pq.offer(new Node(next.to,now.weight+next.weight,true,now.visited));

            }else{
                for(Node next : listSecond.get(now.to)) pq.offer(new Node(next.to,now.weight+ next.weight,false,now.visited));
            }
        }
        return  0;
    }

    public static void main(String[] args) {
        int n = 4; int start = 1; int end = 4; int[][]roads = {{1, 2, 1},{3, 2, 1},{2, 4, 1}}; int[]traps = {2,3};
        System.out.println(solution(n,start,end,roads,traps));

    }
}
