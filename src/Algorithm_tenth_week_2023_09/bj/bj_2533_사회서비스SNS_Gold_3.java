package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_2533_사회서비스SNS_Gold_3 {

    static int N;
    static List<List<Integer>> list;
    static boolean[]visited;
    static int answer;
    static int parents[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        StringTokenizer st = null;
        parents = new int[N+1];
        parents[1] = 0;
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);

        }
        calc(1,0);
        System.out.println(answer);
    }
    static int calc(int node,int parent){
        if(list.get(node).size()==1&&list.get(node).get(0)==parent) {
            return 1;
        }
        int tmp = 0;
        for(int next : list.get(node)){
            if(next==parent) continue;
            tmp += calc(next,node);
        }
        if(tmp==0) return 1;
        answer++;
        return 0;
    }
}
