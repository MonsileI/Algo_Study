package April_Fourth;

import java.util.*;
import java.io.*;
public class bj_1966_프린터큐_Silver_3 {

    static class Node{
        int idx;int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", value=" + value +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            Queue<Node> q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine()," ");

            int []arr = new int[N];
            for(int i=0;i<N;i++){
                int value = Integer.parseInt(st.nextToken());
                q.offer(new Node(i,value));
                arr[i] = value;
            }
            Arrays.sort(arr);
            int maxIdx = N-1;
            int answer = num;
            int order = 1;

            while(!q.isEmpty()){

                Node node = q.peek();
                int idx = node.idx;
                int value = node.value;


                if(value==arr[maxIdx]){
                    if(idx==num){
                        answer = order;
                        break;
                    }
                    q.poll();
                    order++;
                    maxIdx--;
                }else{
                    //다시 넣어주기
                    Node nextTimeBaby = node;
                    q.poll();
                    q.offer(nextTimeBaby);
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
