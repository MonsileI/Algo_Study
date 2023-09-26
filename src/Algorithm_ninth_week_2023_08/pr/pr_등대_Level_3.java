package Algorithm_ninth_week_2023_08.pr;

import java.util.*;
public class pr_등대_Level_3 {
    static int N,L[][];
    static List<List<Integer>> list;
    static int answer;

    public static void main(String[] args) {

        int n = 8;
        int[][] lightouse = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};
        N = n;
        L = lightouse;
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for (int i = 0; i < N - 1; i++) {
            list.get(L[i][0]).add(L[i][1]);
            list.get(L[i][1]).add(L[i][0]);
        }
        dfs(1,0);
        System.out.println(answer);
    }
    static int dfs(int cur, int before){
        //리프 노드일 경우 return 1로 해줌
        if(list.get(cur).get(0)==before&&list.get(cur).size()==1){
            return 1;
        }
        //리프 노드가 아닐경우
        int tmp = 0;
        //다른 리프노드값을 dfs해줌
        for(int next : list.get(cur)){
            if(next==before) continue;
            tmp += dfs(next,cur);
        }

        //tmp가 0으로 return 되었다는건, 이미 다른 연결노드를 켰다는 거니까 자기 자신은 안켜도 됨
        if(tmp==0) return 1;
        //다른 리트노드에 켜야될 값이 없는 경우 자기 자신을 켜야함 자기를 켰으니 ++해줌.
        answer++;
        return 0;
    }
}
