package Algorithm_eleventh_week_2023_09.복습;

import java.util.*;

public class pr_등대_Level_3 {
    static int N;
    static int[][]L;
    static List<List<Integer>> list;
    static int answer;
    public static void main(String[] args) {
        int n = 10;
        int [][] lighthouse = {{4, 1},{5, 1},{5, 6},{7, 6},{1, 2},{1, 3},{6, 8},{2, 9},{9, 10}};
        N = n;
        L = lighthouse;
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<N-1;i++){
            list.get(L[i][0]).add(L[i][1]);
            list.get(L[i][1]).add(L[i][0]);
        }

        dfs(0,1);
        System.out.println(answer);
    }
    static int dfs(int parent, int now){

        if(list.get(now).size()==1&&list.get(now).get(0)==parent) return 1;

        int tmp = 0;
        for(int next : list.get(now)){
            if(next==parent) continue;
            tmp += dfs(now,next);
        }

        if(tmp==0) return 1;
        answer++;
        return 0;


    }
}
