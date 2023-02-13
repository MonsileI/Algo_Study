package January_Fourth;

import java.io.*;
import java.util.*;

public class BJ_1865_웜홀_Gold_3_Re {

    static class Node {
        int to,weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int N,M,W,dist[];
    static List<List<Node>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for(int t=0;t<TC;t++){

            st = new StringTokenizer(br.readLine()," ");
            list = new ArrayList<>();
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
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

            dist = new int[N+1];

            Arrays.fill(dist,987654321);

            if(belman()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");

        }

        System.out.println(sb.toString());

    }

    static boolean belman() {

        dist[1] = 0;

        for (int i = 1; i < N ; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (Node next : list.get(j)) {
                    if (dist[next.to] > dist[j] + next.weight) {
                        dist[next.to] = dist[j] + next.weight;
                    }
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (Node next : list.get(i)) {
                if (dist[next.to] > dist[i] + next.weight) {
                    return true;
                }
            }
        }
        return false;
    }
}
