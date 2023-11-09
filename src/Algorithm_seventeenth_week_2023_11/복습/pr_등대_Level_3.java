package Algorithm_seventeenth_week_2023_11.복습;
import java.util.*;
public class pr_등대_Level_3 {

    static List<List<Integer>> list;
    static int N;
    static int[][]L;
    static int ans;
    public static void main(String[] args) {
        int n = 10;
        int [][] lighthouse = {{4, 1},{5, 1},{5, 6},{7, 6},{1, 2},{1, 3},{6, 8},{2, 9},{9, 10}};
        N = n;
        L = lighthouse;
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<lighthouse.length;i++){
            list.get(lighthouse[i][0]).add(lighthouse[i][1]);
            list.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }

        dfs(1,0);
        System.out.println(ans);
    }
    static int dfs(int now,int parent){

        if(list.get(now).size()==1&&list.get(now).get(0)==parent) return 1; //리프 노드란 뜻
        int tmp = 0;
        for(int next : list.get(now)){
            if(next==parent) continue;
            tmp += dfs(next,now);
        }

        if(tmp==0) return 1;
        ans++;
        return 0;
    }
}
