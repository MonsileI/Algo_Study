package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_18870_좌표압축_Silver_2 {
    static class Node implements Comparable<Node>{
        int value; int index;
        public Node(int value, int index) {
            this.value = value;
            this.index = index;

        }

        @Override
        public int compareTo( Node o) {
            return value - o.value;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Node[]arr = new Node[N];
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = new Node(num,i);
        }
        Arrays.sort(arr);
        int v = arr[0].value;
        int ans = 0;
        int[]ansArr = new int[N];
        for(int i=0;i<N;i++){
            if(v!=arr[i].value){
                v = arr[i].value;
                ans++;
            }
            ansArr[arr[i].index] = ans;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) sb.append(ansArr[i]+" ");
        System.out.println(sb.toString());
    }
}
