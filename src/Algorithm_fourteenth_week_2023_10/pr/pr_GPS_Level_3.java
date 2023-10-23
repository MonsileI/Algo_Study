package Algorithm_fourteenth_week_2023_10.pr;

import java.util.*;
public class pr_GPS_Level_3 {
    static List<List<Integer>> list;
    static int N,K;
    static int [][]E;
    static int []G;
    static int answer = 987654321;
    public static void main(String[] args) {
        int n = 7;
        int m = 10;
        int [][] edge_list = {{1, 2},{1, 3},{2, 3},{2, 4},{3, 4},{3, 5},{4, 6},{5, 6},{5, 7},{6, 7}};
        int k = 6;
        int []gps_log = {1, 2, 3, 3, 6, 7};
        N = n; E = edge_list; G = gps_log;
        list = new ArrayList<>();
        for(int i=0;i<n+1;i++) {
            list.add(new ArrayList<>());
            list.get(i).add(i);
        }
        for(int i=0;i<m;i++) {
            list.get(edge_list[i][0]).add(edge_list[i][1]);
            list.get(edge_list[i][1]).add(edge_list[i][0]);
        }
        for(int i=0;i<k-1;i++){
            if(!list.get(gps_log[i]).contains(gps_log[i+1])){
                for(int j=1;j<N+1;j++){
                    if(j==gps_log[i]) continue;
                    for(int next : list.get(j)){
                        if(next==gps_log[i+1]){
                            dfs(j,i+2,1);
                        }
                    }
                }
            }
        }
        System.out.println(answer==987654321 ? 0 : answer);
    }
    static void dfs(int num,int depth,int cnt){

        if(answer<=cnt) return;

        if(K-1<depth){
            answer = Math.min(answer,cnt);
            return;
        }

        for(int next : list.get(num)) {
            if(next==G[depth]) dfs(num,depth+1,cnt);
            else dfs(num,depth+1,cnt+1);
        }


    }
}
