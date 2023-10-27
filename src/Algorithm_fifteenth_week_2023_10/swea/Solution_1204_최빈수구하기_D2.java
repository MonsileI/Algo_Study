package Algorithm_fifteenth_week_2023_10.swea;
import java.util.*;
import java.io.*;
public class Solution_1204_최빈수구하기_D2 {

    static class Node implements Comparable<Node>{
        int num; int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return cnt==o.cnt ? -(num-o.num) : -(cnt - o.cnt) ;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =null;
        for(int t=0;t<TC;t++){
            sb.append("#").append(br.readLine()+" ");
            Node[]arr = new Node[101];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<101;i++) arr[i] = new Node(i,0);
            for(int i=0;i<1000;i++){
                int num = Integer.parseInt(st.nextToken());
                arr[num].cnt++;
            }
            Arrays.sort(arr);
            sb.append(arr[0].num+"\n");
        }
        System.out.println(sb.toString());
    }
}
