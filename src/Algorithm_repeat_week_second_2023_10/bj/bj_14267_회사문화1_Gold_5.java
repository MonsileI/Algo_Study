package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_14267_회사문화1_Gold_5 {
    static List<List<Integer>> list;
    static int[] idx;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        idx = new int[N+1];
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num!=-1){
                list.get(num).add(i);
            }
        }

        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            idx[num] += cnt;
        }
        dfs(1);
        StringBuilder sb= new StringBuilder();
        for(int i =1; i<N+1;i++) sb.append(idx[i]+" ");
        System.out.println(sb.toString());
    }
    static void dfs(int num){
        for(int next : list.get(num)){
            idx[next] += idx[num];
            dfs(next);
        }
    }
}
