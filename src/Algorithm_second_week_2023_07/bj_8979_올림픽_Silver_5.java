package Algorithm_second_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_8979_올림픽_Silver_5 {
    static class Node implements Comparable<Node>{
        int idx,g,s,b;

        public Node(int idx, int g, int s, int b) {
            this.idx = idx;
            this.g = g;
            this.s = s;
            this.b = b;
        }

        @Override
        public int compareTo(Node o) {

            if(g==o.g){
                if(s==o.s){
                    if(b==o.b){
                        return idx-o.idx;
                    }else return -(b-o.b);
                }else return -(s-o.s);
            }else return -(g-o.g);

        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node[]arr = new Node[N];
        Node answer = new Node(0,0,0,0);
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");

            int idx = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            arr[i] = new Node(idx,gold,silver,bronze);
            if(idx==M){
                answer = new Node(idx,gold,silver,bronze);
            }
        }


        Arrays.sort(arr);

        int idx= 1;
        for(int i=0;i<N;i++){
            if(arr[i].idx==M) break;
            if(answer.g==arr[i].g && answer.s==arr[i].s && answer.b==arr[i].b)break;
            idx++;
        }
        System.out.println(idx);
    }
}
