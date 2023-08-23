package Algorithm_third_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_1005_ACMCraft_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            st= new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            List<List<Integer>>list = new ArrayList<>();
            int[]edgeCount = new int[N+1];
            int[]money = new int[N+1];
            int answer = 987654321;
            for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int [] answerArr = new int[N+1];
            for(int i=1;i<N+1;i++) answerArr[i] = money[i] = Integer.parseInt(st.nextToken());

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list.get(from).add(to);
                edgeCount[to]++;
            }
            int target = Integer.parseInt(br.readLine());
            Queue<Integer> q= new ArrayDeque<>();
            for(int i=1;i<N+1;i++) if(edgeCount[i]==0) q.offer(i);
            if(edgeCount[target]==0){
                answer = money[target];
                sb.append(answer+"\n");
                continue;
            }

            while(!q.isEmpty()){
                int num = q.poll();

                for(Integer next : list.get(num)){
                    edgeCount[next]--;
                    answerArr[next] = Math.max(answerArr[num]+money[next],answerArr[next]);
                    if(edgeCount[next]==0){
                        q.offer(next);
                    }
                }
            }

            sb.append(answerArr[target]+"\n");
        }
        System.out.println(sb.toString());
    }
}
