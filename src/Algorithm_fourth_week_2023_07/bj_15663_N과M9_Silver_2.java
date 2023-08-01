package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_15663_N과M9_Silver_2 {
    static int N,M,arr[];

    static boolean[]visited;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N]; visited = new boolean[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        perm(0,"");
        StringBuilder sb = new StringBuilder();
        for(String str : list)sb.append(str).append("\n");
        System.out.println(sb.toString());
    }
    static void perm(int depth,String tmp){

        if(depth==M){
            tmp = tmp.substring(0,tmp.length()-1);
            if(!list.contains(tmp)) list.add(tmp);
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                String newOne = tmp + arr[i]+" ";
                perm(depth+1,newOne);
                visited[i] = false;
            }
        }
    }
}
