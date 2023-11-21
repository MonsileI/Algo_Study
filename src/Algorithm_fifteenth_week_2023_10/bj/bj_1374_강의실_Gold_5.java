package Algorithm_fifteenth_week_2023_10.bj;
import java.util.*;
import java.io.*;
public class bj_1374_강의실_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]arr = new int[N][3];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)->o1[1] == o2[1] ? o1[2] -o2[2] : o1[1] - o2[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0][2]);
        for(int i=1;i<N;i++){
            if(pq.peek()<=arr[i][1]) pq.poll();
            pq.offer(arr[i][2]);
        }
        System.out.println(pq.size());
    }
}
