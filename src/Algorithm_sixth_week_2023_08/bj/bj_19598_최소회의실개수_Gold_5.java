package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_19598_최소회의실개수_Gold_5 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int [][] arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)-> o1[0]==o2[0] ? -o1[1] - o2[1] : o1[0] - o2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0][1]);
        for(int i=1;i<N;i++){
            int end = pq.peek();
            if(end<=arr[i][0]) pq.poll();
            pq.offer(arr[i][1]);
        }
        System.out.println(pq.size());

    }
}
