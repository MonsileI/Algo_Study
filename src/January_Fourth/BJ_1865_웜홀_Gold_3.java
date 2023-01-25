package January_Fourth;

import java.util.*;
import java.io.*;
public class BJ_1865_웜홀_Gold_3 {

    static class Node{

        int to,weight;

        public Node( int to, int weight) {

            this.to = to;
            this.weight = weight;
        }

    }
    static int N,M,W,dist[];
    static List<List<Node>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        첫 번째 줄에는 테스트케이스의 개수 TC(1 ≤ TC ≤ 5)가 주어진다.
        그리고 두 번째 줄부터 TC개의 테스트케이스가 차례로 주어지는데 각 테스트케이스의
        첫 번째 줄에는 지점의 수 N(1 ≤ N ≤ 500), 도로의 개수 M(1 ≤ M ≤ 2500),
        웜홀의 개수 W(1 ≤ W ≤ 200)이 주어진다. 그리고 두 번째 줄부터 M+1번째 줄에
         도로의 정보가 주어지는데 각 도로의 정보는 S, E, T 세 정수로 주어진다. S와 E는 연결된 지점의 번호,
          T는 이 도로를 통해 이동하는데 걸리는 시간을 의미한다. 그리고 M+2번째 줄부터 M+W+1번째 줄까지 웜홀의 정보가
          S, E, T 세 정수로 주어지는데 S는 시작 지점, E는 도착 지점, T는 줄어드는 시간을 의미한다.
          T는 10,000보다 작거나 같은 자연수 또는 0이다.
        두 지점을 연결하는 도로가 한 개보다 많을 수도 있다. 지점의 번호는 1부터 N까지 자연수로 중복 없이 매겨져 있다.
        * */

        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){

            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list.get(from).add(new Node(to,weight));
                list.get(to).add(new Node(from,weight));
            }
            for(int i=0;i<W;i++){
                st = new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list.get(from).add(new Node(to,-weight));
            }

            if(belman()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");

        }
            System.out.println(sb.toString());

    }
        static boolean belman(){

        dist = new int[N+1];
        int max = 987654321;
        Arrays.fill(dist,max);
        dist[1] = 0;

        for(int i=1;i<N+1;i++){

            for(int j=1;j<N+1;j++){
                for(Node node : list.get(j)){
                    if(dist[node.to] > dist[j] + node.weight){
                         dist[node.to] = dist[j] + node.weight;
                    }
                }
            }
        }

        for(int j=1;j<N+1;j++){
            for(Node node: list.get(j)){
                if(dist[node.to] > dist[j] + node.weight ){
                    return true;
                }
            }
        }



        return false;

        }
}
